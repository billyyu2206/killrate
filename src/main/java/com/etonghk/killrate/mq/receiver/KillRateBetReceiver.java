package com.etonghk.killrate.mq.receiver;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.config.RabbitMqConfig;
import com.etonghk.killrate.service.orderCalculate.OrderCalculateService;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Component
public class KillRateBetReceiver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	ThreadLocal<Map<String,Map<String,BigDecimal>>> awardNumberResults = new ThreadLocal<>(); 
	
	@Autowired
	private OrderCalculateService orderCalculateService;
	
	@Autowired
	private RedisCache redisCache;
	
	/**
	 * 注單計算consumer,計算完畢存在本身內存
	 * @param order
	 */
	@RabbitListener(queues = RabbitMqConfig.KILL_RATE_BET_QUEUE,concurrency="10")
    public void receive(GameLotteryOrder order) {
		String key = order.getLottery()+":"+order.getIssue();
		logger.info("receiver==> " + order.toString());
		Map<String,BigDecimal> orderResult = orderCalculateService.doCalOrder(order);
		if(awardNumberResults.get()==null) {
			logger.info("receiver==> " + key +" thread local no data");			
			Map<String,Map<String,BigDecimal>> awardNumberResult = new HashMap<>();
			awardNumberResult.put(key, orderResult);
			awardNumberResults.set(awardNumberResult);
		}else {
			Map<String,Map<String,BigDecimal>> awardNumberResultMap = awardNumberResults.get();
			Map<String,BigDecimal> gameIssueAwards = awardNumberResultMap.get(key);
			if(gameIssueAwards==null) {
				logger.info("receiver==> " + key +" result no data");							
				awardNumberResultMap.put(key, orderResult);
			}else {
				logger.info("receiver==> " + key +" get key data");							
				orderResult.entrySet().forEach(map->{
					String number  = map.getKey();
					BigDecimal award  = map.getValue();
					if(gameIssueAwards.get(number)==null) {
						gameIssueAwards.put(number, award);
					}else {
						BigDecimal beforeAward = gameIssueAwards.get(number);
						award = beforeAward.add(award);
						gameIssueAwards.put(number, award);
					}
				});
				awardNumberResultMap.put(key, gameIssueAwards);
			}
			awardNumberResults.set(awardNumberResultMap);
		}
    }
	
	/**
	 * 結果統計consumer,當收到計算通知時,將目前內存存入redis進行加總
	 * @param lotteryIssueKey
	 */
	public void clearLotteryIssueAward(String lotteryIssueKey) {
		Map<String,Map<String,BigDecimal>> awardNumberResultMap = awardNumberResults.get();
		if(awardNumberResultMap==null) {
			return;
		}else {
			Map<String,BigDecimal> gameIssueAwardResult= awardNumberResultMap.get(lotteryIssueKey);
			if(gameIssueAwardResult==null) {
				return;
			}else {
				//取出key序列化元件
				RedisSerializer<String> redisSerializer = redisCache.getRedisKeySerializer();
				//要處理的key
				byte[] key = redisSerializer.serialize(lotteryIssueKey);
				//撰寫RedisCallBack物件
				RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
					//每一個pipeline需要實作自己準備批量放入的方式
					@Override
					public Void doInRedis(RedisConnection connection) throws DataAccessException {
						//迴圈裝入物件
						gameIssueAwardResult.entrySet().forEach(entry->{
							byte[] field = redisSerializer.serialize(entry.getKey());
							connection.hIncrBy(key, field, entry.getValue().doubleValue());
						});
						return null;
					}
				};
				redisCache.excutePipeline(pipelineCallback);
				
			}
		}
	}
	
	
}