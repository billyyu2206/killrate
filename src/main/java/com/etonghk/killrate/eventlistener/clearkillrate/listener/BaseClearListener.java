package com.etonghk.killrate.eventlistener.clearkillrate.listener;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.etonghk.killrate.cache.key.RedisKey;
import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;
import com.etonghk.killrate.service.clearkillrate.ClearKillRateService;
import com.etonghk.killrate.vo.ClearKillRateVo;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
public abstract class BaseClearListener {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected Map<String,Map<String,BigDecimal>> awardNumber = new ConcurrentHashMap<>();
	
	protected Queue<ClearEvent> resultQueue = new ConcurrentLinkedQueue<>();

	@Autowired
	private ClearKillRateService clearKillRateService;
	
	protected void clearIssueKillRate() {
		ClearEvent event = resultQueue.poll();
		synchronized (awardNumber) {
			ClearKillRateVo vo = event.getClearKillRateVo();
			logger.info("receiver==>lottery={},billno={},issue{}",vo.getLottery(),vo.getBillNo(),vo.getIssue());
		      Map<String,BigDecimal> issueAward = vo.getAwardNumber();
		      String lotteryIssueKey = RedisKey.getLotteryIssueKey(vo.getLottery(), vo.getIssue());
		      if(awardNumber.get(lotteryIssueKey)!=null) {
		        Map<String,BigDecimal> issueResult = awardNumber.get(lotteryIssueKey);
		        issueResult.entrySet().forEach(entry->{
		          String number = entry.getKey();
		          BigDecimal value = entry.getValue();
		          if(issueAward.containsKey(number)) {
		            issueAward.put(number,value.add(issueAward.get(number)));
		          }else {
		            issueAward.put(number, value);
		          }
		        });
		      }
		      awardNumber.put(lotteryIssueKey, issueAward);
		}
	}
	
	protected void pushAwardNumberToRedis(ClearKillRateVo vo) {
		String lottery = vo.getLottery();
		String issue = vo.getIssue();
		String lotteryIssueKey = RedisKey.getLotteryIssueKey(lottery, issue);
		Map<String,BigDecimal> awardResult = awardNumber.get(lotteryIssueKey);
		
		// 判斷彩種是否與listener相同
		if(!getLottery().equals(lottery)) {
			return;
		}
		
		if(awardResult != null) {
			//將該獎期資料存入redis
			clearKillRateService.pushClearRateToRedis(awardResult, lotteryIssueKey);
		}
		//進行該獎期分區完成通知
		clearKillRateService.doClearRateFinishMark(lottery, issue);
		//移除資料
		awardNumber.remove(lotteryIssueKey);
		//進行殺率開獎流程
		clearKillRateService.clearFinishCalKillNumber(lottery, issue);
	}
	
	protected abstract String getLottery();
	
}