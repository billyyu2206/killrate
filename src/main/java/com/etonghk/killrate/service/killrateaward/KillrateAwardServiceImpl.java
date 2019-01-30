package com.etonghk.killrate.service.killrateaward;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.cache.key.RedisKey;
import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.BetRecordDao;
import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.dao.KillrateAwardDao;
import com.etonghk.killrate.dao.KillrateSettingLogDao;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.domain.KillrateSettingLog;
import com.etonghk.killrate.exception.ServiceException;
import com.etonghk.killrate.service.awardnmber.config.SSCConfig;
import com.etonghk.killrate.service.awardnmber.constant.KillrateConstant;
import com.etonghk.killrate.service.ordercalculate.OrderCalculateService;
import com.etonghk.killrate.utils.CommonUtils;
import com.etonghk.killrate.utils.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jack.entity.GameLotteryOrder;

@Service
public class KillrateAwardServiceImpl implements KillrateAwardService{
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Gson gson = new Gson();
	
	@Autowired
	private KillrateAwardDao killrateAwardDao;
	
	@Autowired
	private GameIssueDao gameIssueDao;
	
	@Autowired
	private BetRecordDao betRecordDao;
	
	@Autowired
	private KillrateSettingLogDao killrateSettingLogDao;
	
	@Autowired
	private RedisCache redisCache;
	
	@Autowired
	private OrderCalculateService orderCalculateService;
	
	/**
	 * 	取得殺率設定獎期
	 * 	@param KillrateAward.lottery
	 * 	@param KillrateAward.issueEndDate
	 */
	@Override
	public Page<KillrateAward> selectForSettingPage(KillrateAward cond,Page<KillrateAward> page) {
		List<KillrateAward> result = killrateAwardDao.selectForSettingPage(cond,page);
		page.setRecords(result);
		return page;
	}
	
	/**
	 * 	生成殺率設定獎期
	 * 	@param KillrateSetting.lottery
	 * 	@param KillrateSetting.issueEndDate
	 */
	@Override
	public int generateKillrateAward(KillrateSetting setting, Account account) {
		if(StringUtils.isNotBlank(setting.getIssue()) && setting.getStartTime() != null && setting.getEndTime() != null) {
			throw new ServiceException("杀率区间段与杀率奖期不可同时输入");
		}
		setting.setOperateTime(LocalDateTime.now());
		List<GameIssue> matchGameIssues = gameIssueDao.selectForGenerateKillrate(setting);
		if(matchGameIssues == null || matchGameIssues.size() == 0){
			throw new ServiceException("找不到符合的奖期资料!");
		}
		
		List<KillrateAward> existKillrateAward = killrateAwardDao.selectForGenerateKillrate(setting);
		
		List<KillrateAward> insertList = new ArrayList<KillrateAward>();
		KillrateAward insertData = new KillrateAward();
		// 整理需要新增的清單
		for(GameIssue issueData : matchGameIssues) {
			insertData = new KillrateAward();
			insertData.setAwardNumber("");
			insertData.setLottery(setting.getLottery());
			insertData.setIssue(issueData.getFullIssue());
			insertData.setIssueEndTime(issueData.getIssueEndTime());
			insertData.setKillrate(setting.getKillrate());
			insertData.setIsPush(0);
			insertList.add(insertData);
		}
		if(existKillrateAward != null && existKillrateAward.size() > 0) {
			killrateAwardDao.deleteForGenerateKillrate(setting);
		}
		
		if(insertList != null && insertList.size() > 0) {
			killrateAwardDao.batchInsert(insertList);
		}
		
		KillrateSettingLog settingLog = new KillrateSettingLog();
		settingLog.setLottery(setting.getLottery());
		settingLog.setOperateType(0);
		settingLog.setUpdateTime(setting.getOperateTime());
		settingLog.setUpdateUser(account.getAccount());
		settingLog.setDescription(getSettingLogContent(setting, insertList));
		killrateSettingLogDao.insert(settingLog);
		return 0;
	}

	/**
	 * 	修改殺率奖期設定
	 * 	@param KillrateAward.id
	 * 	@param KillrateAward.killrate
	 */
	@Override
	public int updateKillrateAward(KillrateAward record, Account account) {
		LocalDateTime operateTime = LocalDateTime.now();
		KillrateAward dataForLog = killrateAwardDao.selectByPrimaryKey(record.getId());
		int result = killrateAwardDao.updateByPK(record, operateTime);
		if(result > 0) {
			KillrateSettingLog settingLog = new KillrateSettingLog();
			settingLog.setLottery(dataForLog.getLottery());
			settingLog.setOperateType(1);
			settingLog.setUpdateTime(operateTime);
			settingLog.setUpdateUser(account.getAccount());
			settingLog.setDescription("修改杀率奖期 " + dataForLog.getIssue() + "<br/>杀率比例: " + dataForLog.getKillrate() + " --> " + record.getKillrate());
			killrateSettingLogDao.insert(settingLog);
		}
		
		return result;
	}

	/**
	 * 	删除殺率奖期設定
	 * 	@param KillrateAward.id
	 */
	@Override
	public int deleteKillrateAward(KillrateAward record, Account account) {
		LocalDateTime operateTime = LocalDateTime.now();
		KillrateAward dataForLog = killrateAwardDao.selectByPrimaryKey(record.getId());
		
		int result = killrateAwardDao.deleteByPK(record, operateTime);
		
		if(result > 0) {
			KillrateSettingLog settingLog = new KillrateSettingLog();
			settingLog.setLottery(dataForLog.getLottery());
			settingLog.setOperateType(2);
			settingLog.setUpdateTime(operateTime);
			settingLog.setUpdateUser(account.getAccount());
			settingLog.setDescription("删除杀率奖期 " + dataForLog.getIssue());
			killrateSettingLogDao.insert(settingLog);
		}
		return result;
	}

	@Override
	public Page<KillrateAward> selectForRecord(String lottery, LocalDateTime issueDate, Boolean isPush, Page<KillrateAward> page) {
		List<KillrateAward> result = killrateAwardDao.selectForRecord(lottery, issueDate, isPush, page);
		page.setRecords(result);
		
		return page;
	}

	/**
	 * 	結算金額
	 * 	@param KillrateAward.id
	 */
	@Override
	public KillrateAward calAwardNumber(String lottery, String issue) {
		KillrateAward award = killrateAwardDao.selectForCalNumber(lottery, issue);
		if(award == null) {
			// 沒有設定的殺率獎期
			return null;
		}else if(StringUtils.isNotBlank(award.getAwardNumber())) {
			return award;
		}
		
		List<GameLotteryOrder> purseData = betRecordDao.selectPurseByLotteryAndIssue(lottery, issue, issue.substring(0, 8));
		
		String redisKey = RedisKey.getLotteryIssueKey(lottery, issue);
		Map<Object, Object> redisData = redisCache.hgetAll(redisKey);
		String tempStr = gson.toJson(redisData);
		Type type = new TypeToken<Map<String, BigDecimal>>(){}.getType();
		Map<String, BigDecimal> data = gson.fromJson(tempStr, type);

		// 決定開獎號碼時再把追號注單內容算入
		if(purseData != null && purseData.size() > 0) {
			for(GameLotteryOrder purseOrder : purseData) {
				Map<String,BigDecimal> temp = orderCalculateService.doCalOrder(purseOrder);
				for(String number : temp.keySet()) {
					if(data.containsKey(number)) {
						data.put(number, data.get(number).add(temp.get(number)));
					}else {
						data.put(number, temp.get(number));
					}
				}
			}
		}
		
		for (String number : SSCConfig.allNumberList) {
			if(!data.containsKey(number)) {
				data.put(number, BigDecimal.ZERO);
			}
		}
		
		BigDecimal total = data.get(KillrateConstant.TOTAL_BET);
		data.remove(KillrateConstant.TOTAL_BET);
		data = CommonUtils.sortByValueAsc(data);
		BigDecimal targetRate = new BigDecimal(award.getKillrate());
		
		int listMinSize = 1000;
		List<String> awardList = new ArrayList<String>();
		Map<String, List<String>> substituteMap = new LinkedHashMap<String, List<String>>();// 未達設定殺率號碼
		Integer openStatus = 0;
		
		if(total!=null && !BigDecimal.ZERO.equals(total)) { // 正常流程
			for(Map.Entry<String, BigDecimal> entry : data.entrySet()) {
				BigDecimal numberMoney = entry.getValue();
				BigDecimal rate = total.subtract(numberMoney).divide(total, 2, BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(100));
				if(rate.compareTo(targetRate) >= 0) {
					awardList.add(entry.getKey());
				}else if(rate.compareTo(BigDecimal.ZERO) >= 0) {
					List<String> temp = null;
					if(substituteMap.containsKey(rate.toString())) {
						temp = substituteMap.get(rate.toString());
					}else {
						temp = new ArrayList<String>();
					}
					temp.add(entry.getKey());
					substituteMap.put(rate.toString(), temp);
				}
			}
			openStatus = 1;
		} else { // tot為null或0 隨機開出號碼
			data.forEach((k,v)->awardList.add(k));
			openStatus = 2;
		}
		
		if(awardList.size() < listMinSize) {
			for(Map.Entry<String, List<String>> entry : substituteMap.entrySet()) {
				awardList.addAll(entry.getValue());
				if(awardList.size() >= listMinSize) {
					break;
				}
			}
		}
		
		int chooseIndex = (int) Math.floor(awardList.size() * Math.random());
		String awardNumber = awardList.get(chooseIndex);
		award.setAwardNumber(StringUtil.join(awardNumber, ","));
		award.setAwardMoney(data.get(awardNumber));
		award.setBetMoney(total);
		award.setAwardTime(LocalDateTime.now());
		award.setOpenStatus(openStatus);
		int result = killrateAwardDao.updateForAward(award);
		if(result == 0) {
			award = killrateAwardDao.selectByPrimaryKey(award.getId());
		}
		
		redisKey = RedisKey.getLotteryIssueResultKey(lottery, issue);
		data.put(KillrateConstant.TOTAL_BET, total);
		redisCache.putObj(redisKey, data, 3, TimeUnit.DAYS);
		return award;
	}

	private String getSettingLogContent(KillrateSetting setting, List<KillrateAward> insertList) {
		StringBuilder result = new StringBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if(setting.getStartTime() != null && setting.getEndTime() != null) {
			result.append("杀率区间段: ").append(setting.getStartTime().format(formatter)).append(" ~ ")
				.append(setting.getStartTime().format(formatter)).append("<br/>");
		}
		
		if(setting.getStartTime() != null && setting.getEndTime() != null) {
			result.append("杀率奖期: ").append(setting.getIssue()).append("<br/>");
		}
		result.append("杀率比例: ").append(setting.getKillrate()).append("<br/>");
		
		result.append("生成結果: ").append(setting.getKillrate()).append("<br/>");
		result.append("奖期  ");
		if(insertList.size() == 1) {
			result.append(insertList.get(0).getIssue());
		}else {
			result.append(insertList.get(0).getIssue()).append(" ~ ").append(insertList.get(insertList.size() - 1).getIssue());
		}
		
		return result.toString();
	}

	@Override
	public Map<String, KillrateAward> getRefreshMemoryData() {
		Map<String, KillrateAward> result = new HashMap<String, KillrateAward>();
		List<KillrateAward> datas = killrateAwardDao.selectForRefreshCache();
		for(KillrateAward killrateAward : datas) {
			result.put(killrateAward.getLottery() + ":" + killrateAward.getIssue(), killrateAward);
		}
		return result;
	}
}
