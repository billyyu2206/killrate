package com.etonghk.killrate.service.killrateAward;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.constant.KillrateConstant;
import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.dao.KillrateAwardDao;
import com.etonghk.killrate.dao.KillrateSettingLogDao;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.domain.KillrateSettingLog;
import com.etonghk.killrate.exception.ServiceException;
import com.etonghk.killrate.utils.CommonUtils;
import com.google.gson.reflect.TypeToken;

@Service
public class KillrateAwardServiceImpl implements KillrateAwardService{
	
	@Autowired
	private KillrateAwardDao killrateAwardDao;
	
	@Autowired
	private GameIssueDao gameIssueDao;
	
	@Autowired
	private KillrateSettingLogDao killrateSettingLogDao;
	
	@Autowired
	private RedisCache redisCache;
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
		setting.setOperateTime(new Date());
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
		Date operateTime = new Date();
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
		Date operateTime = new Date();
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
	public Page<KillrateAward> selectForRecord(String lottery, Date issueDate, Boolean isPush, Page<KillrateAward> page) {
		List<KillrateAward> result = killrateAwardDao.selectForRecord(lottery, issueDate, isPush, page);
		page.setRecords(result);
		
		return page;
	}

	/**
	 * 	删除殺率奖期設定
	 * 	@param KillrateAward.id
	 */
	@Override
	public KillrateAward calAwardNumber(String lottery, String fullIssue, Boolean isTask) {
		KillrateAward award = killrateAwardDao.selectForCalNumber(lottery, fullIssue);
		if(award == null) {
			// 沒有設定的殺率獎期
			return null;
		}else if(StringUtils.isNotBlank(award.getAwardNumber())) {
			// 如果已經有獎號了
			if(isTask) {
				return award;
			}else {
				// TODO 要再確認如果不是 task的請求如何處理
			}
		}
		
		String redisKey = lottery + ":" + fullIssue;
		Map<Object, Object> redisData = redisCache.hgetAll(redisKey);
		String tempStr = redisCache.getGson().toJson(redisData);
		Type type = new TypeToken<Map<String, BigDecimal>>(){}.getType();
		Map<String, BigDecimal> data = redisCache.getGson().fromJson(tempStr, type);
		BigDecimal total = data.get(KillrateConstant.TOTAL_BET);
		data.remove(KillrateConstant.TOTAL_BET);
		data = CommonUtils.sortByValueAsc(data);
		BigDecimal targetRate = new BigDecimal(award.getKillrate());
		
		// FIXME 確認樣本最小要多少
		int listMinSize = 1000;
		List<String> awardList = new ArrayList<String>();
		Map<String, List<String>> substituteMap = new LinkedHashMap<String, List<String>>();// 未達設定殺率號碼
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
		award.setAwardNumber(awardNumber);
		award.setAwardMoney(data.get(awardNumber));
		award.setBetMoney(total);
		award.setAwardTime(new Date());
		
		int result = killrateAwardDao.updateForAward(award);
		if(result == 0) {
			// TODO throw Exception
		}
		return award;
	}

	private String getSettingLogContent(KillrateSetting setting, List<KillrateAward> insertList) {
		StringBuilder result = new StringBuilder();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(setting.getStartTime() != null && setting.getEndTime() != null) {
			result.append("杀率区间段: ").append(formatter.format(setting.getStartTime())).append(" ~ ")
				.append(formatter.format(setting.getEndTime())).append("<br/>");
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
}
