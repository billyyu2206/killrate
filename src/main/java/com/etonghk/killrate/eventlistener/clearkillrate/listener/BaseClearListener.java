package com.etonghk.killrate.eventlistener.clearkillrate.listener;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;
import com.etonghk.killrate.eventlistener.clearkillrate.vo.ClearKillRateVo;

import groovy.transform.Synchronized;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
public class BaseClearListener {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RedisCache cache;
	
	protected Map<String,Map<String,BigDecimal>> awardNumber = new HashMap<>();
	
	protected Queue<ClearEvent> resultQueue = new LinkedList<>();

	@Synchronized
	protected void clearIssueKillRate() {
		ClearEvent event = resultQueue.poll();
		logger.info("vo info");
		System.out.println(event.getClearKillRateVo());

		ClearKillRateVo vo = event.getClearKillRateVo();
		Map<String,BigDecimal> issueAward = vo.getAwardNumber();
		String gameIssue = vo.getLottery()+":"+vo.getIssue();
		if(awardNumber.get(gameIssue)!=null) {
			Map<String,BigDecimal> issueResult = awardNumber.get(gameIssue);
			issueResult.entrySet().forEach(entry->{
				String number = entry.getKey();
				BigDecimal value = entry.getValue();
				if(issueAward.containsKey(number)) {
					issueAward.put(number,value.add(issueAward.get(number)));
				}
			});
		}
		awardNumber.put(gameIssue, issueAward);
	}
	
	protected void pushAwardNumberToRedis(String gameIssueKey) {
		System.out.println(123456);
		Map<String,BigDecimal> awardResult = awardNumber.get(gameIssueKey);
		if(awardResult==null) {
			return;
		}else {
			//取出key序列化元件
			RedisSerializer<String> redisSerializer = cache.getRedisKeySerializer();
			//要處理的key
			byte[] key = redisSerializer.serialize(gameIssueKey);
			RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
				//每一個pipeline需要實作自己準備批量放入的方式
				@Override
				public Void doInRedis(RedisConnection connection) throws DataAccessException {
					//迴圈裝入物件
					awardResult.entrySet().forEach(entry->{
						byte[] field = redisSerializer.serialize(entry.getKey());
						connection.hIncrBy(key, field, entry.getValue().doubleValue());
					});
					return null;
				}
			};
			cache.excutePipeline(pipelineCallback);
		}
		//移除資料
		awardNumber.remove(gameIssueKey);
	}
	
}