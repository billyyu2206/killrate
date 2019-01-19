/**
 * 
 */
package com.etonghk.killrate.service.orderCalculate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.awardNmber.utils.AwardNumberUtil;
import com.etonghk.killrate.awardSample.cache.AwardSampleCache;
import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
@Service
public class OrderCalculateServiceImpl implements OrderCalculateService{

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Autowired
	private AwardSampleCache awardSampleCache;
	
	@Autowired
	private RedisCache redisCache;
	/**
	 * 	計算注單個開獎號碼金額
	 */
	@Override
	public void doCalOrder(GameLotteryOrder order) {
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(order.getMethod());
		Map<String,List<String>> typeByAwardNumber = awardNumber.getAwardNumberWithType(order);
		Map<String,BigDecimal> resultToSet = AwardNumberUtil.getCalcAwardMoney(order, typeByAwardNumber, awardSampleCache);
		
		//取出key序列化元件
		RedisSerializer<String> redisSerializer = redisCache.getRedisKeySerializer();
		//要處理的key
		byte[] key = redisSerializer.serialize(order.getLottery() + ":" + order.getIssue());
		//撰寫RedisCallBack物件
		RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
			//每一個pipeline需要實作自己準備批量放入的方式
			@Override
			public Void doInRedis(RedisConnection connection) throws DataAccessException {
				//迴圈裝入物件
				resultToSet.entrySet().forEach(entry->{
					byte[] field = redisSerializer.serialize(entry.getKey());
					connection.hIncrBy(key, field, entry.getValue().longValue());
				});
				return null;
			}
		};
		List<?> resultRedis = redisCache.excutePipeline(pipelineCallback);
	}

}
