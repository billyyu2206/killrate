package com.etonghk.killrate.cache;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.reflect.TypeToken;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisCacheTest {

	
	@Autowired
	private RedisCache cache;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Test
	public void tesCachePipeline() {
		
		//取出key序列化元件
		RedisSerializer<String> redisSerializer = cache.getRedisKeySerializer();
		//要處理的key
		byte[] key = redisSerializer.serialize("vipssc:201901191001");
		//裝載號碼及金額資料
//		Map<String,Double> aa = new HashMap<>();
//		for(Integer i=1 ;i<=100000;i++) {
//			aa.put(i.toString(), i*1.0);
//		}
//		aa.put("tot", 10000*1.0);
//		//撰寫RedisCallBack物件
//		RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
//			//每一個pipeline需要實作自己準備批量放入的方式
//			@Override
//			public Void doInRedis(RedisConnection connection) throws DataAccessException {
//				//迴圈裝入物件
//				aa.entrySet().forEach(entry->{
//					byte[] field = redisSerializer.serialize(entry.getKey());
//					connection.hIncrBy(key, field, entry.getValue());
//				});
//				return null;
//			}
//		};
//		List<?> result = cache.excutePipeline(pipelineCallback);
//		System.out.println(123);
		Map<String, Double> tesmp = cache.hgetAll("vipssc:201901191001", String.class, Double.class);
		String temp = cache.getGson().toJson(tesmp);
		Type type = new TypeToken<Map<String, BigDecimal>>(){}.getType();
		Map<String, BigDecimal> test = cache.getGson().fromJson(temp, type);
		
		//在使用String的数据结构的时候使用这个来更改序列化方式  
//		redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(String.class));
//		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<>(Double.class));
//		Map<Object, Object> tesmp = redisTemplate.opsForHash().entries("vipssc:201901191001");
		System.out.println(test);
	}
	
}
