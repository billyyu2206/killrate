package com.etonghk.killrate.service.betrecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.dao.BetRecordDao;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.etonghk.killrate.mq.sender.KillRatePurseSender;
import com.etonghk.killrate.service.awardnmber.constant.KillrateConstant;
import com.etonghk.killrate.service.gameIssus.memory.GameIssueMemory;
import com.etonghk.killrate.service.killrateaward.memory.KillrateAwardMemory;
import com.etonghk.killrate.vo.BetOrderQueueVo;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
@Service
public class BetRecordServiceImpl implements BetRecordService {

	@Autowired
	private BetRecordDao betRecordDao;
	@Autowired
	private KillRatePurseSender killRatePurseSender;
	@Autowired
	private KillRateBetSender killRateBetSender;
	
	@Autowired
	private RedisCache redisCache;
	@Autowired
	private KillrateAwardMemory killrateAwardMemory;
	@Autowired
	private GameIssueMemory gameIssueMemory;
	
	@Override
	public void createPurseTable(LocalDateTime date, int afterDay) {

		for (int i = 0; i <= afterDay; i++) {
			for (String lottery : KillrateConstant.allGameMap.keySet()) {
				String dateStr = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				int exist = betRecordDao.checkTableExist(lottery, dateStr);
				if (exist == 0) {
					betRecordDao.createPurseTable(lottery, dateStr);
				}
			}
			date = date.plusDays(1);
		}
	}
	
	@Override
	public void sendGameLotteryOrder(GameLotteryOrder order) {
		String memoryKey = order.getLottery() + ":" + order.getIssue();
		
		if(order.getType() == 0) {
			String orderCalMode = (String) redisCache.getObj(KillrateConstant.ORDER_CAL_MODE_KEY);
			if(StringUtils.isBlank(orderCalMode)) {
				orderCalMode = "0";
			}
			if("0".equals(orderCalMode)) {
				
				KillrateAward killrateAward = killrateAwardMemory.getKillrateAwardByKey(memoryKey);
				if(killrateAward == null) {
					return;
				}
				
				GameIssue issue = gameIssueMemory.getGameIssueByKey(memoryKey);
				BetOrderQueueVo queueVo = new BetOrderQueueVo();
				queueVo.setGameLotteryOrder(order);
				LocalDateTime now = LocalDateTime.now();
				if((issue.getIssueStartTime().isEqual(now) || issue.getIssueStartTime().isBefore(now)) && 
						(issue.getIssueEndTime().isEqual(now.plusSeconds(2)) || issue.getIssueEndTime().isAfter(now.minusSeconds(2)))) {
					// 當期 注單 容許獎期結束時間後兩秒也算在當期要計算注單
					killRateBetSender.senderGameLotteryOrder(queueVo);
				}else if(issue.getIssueStartTime().isAfter(now)) {
					// 未來注單
					killRateBetSender.senderGameLotteryOrder(queueVo);
					queueVo.setMessage("future order");
					killRateBetSender.senderGameLotteryOrderDead(queueVo);
				}// 過去注單不處理
				
			}
		}else { // order.getType() == 1 追號
			
			GameIssue issue = gameIssueMemory.getGameIssueByKey(memoryKey);
			LocalDateTime now = LocalDateTime.now();
			BetOrderQueueVo queueVo = new BetOrderQueueVo();
			queueVo.setGameLotteryOrder(order);
			if(issue != null) {
				if((issue.getIssueStartTime().isEqual(now) || issue.getIssueStartTime().isBefore(now)) && 
						(issue.getIssueEndTime().isEqual(now.plusSeconds(2)) || issue.getIssueEndTime().isAfter(now.minusSeconds(2)))) {
					// 當期 注單 容許獎期結束時間後兩秒也算在當期要計算注單
					killRateBetSender.senderGameLotteryOrder(queueVo);
				}else if(issue.getIssueStartTime().isAfter(now)) {
					// 未來注單
					killRatePurseSender.senderGameLotteryOrder(queueVo);
				}// 過去注單不處理
			}
			
		}
	}

}
