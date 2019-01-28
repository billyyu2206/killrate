package com.etonghk.killrate.cache;

import java.util.ArrayList;
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
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.domain.GameIssue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisCacheTest {

	
	@Autowired
	private RedisCache cache;
	
	@SuppressWarnings("unused")
//	@Test
	public void tesCachePipeline() {
		long a1 = System.currentTimeMillis();
		//取出key序列化元件
		RedisSerializer<String> redisSerializer = cache.getRedisTemplate().getStringSerializer();
		//要處理的key
		byte[] key = redisSerializer.serialize("vipssc:201901191001");
		//裝載號碼及金額資料
		Map<String,Double> aa = new HashMap<>();
		for(Integer i=1 ;i<=100000;i++) {
			aa.put(i.toString(), i*1.0);
		}
		aa.put("tot", 10000*1.0);
		//撰寫RedisCallBack物件
		RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
			//每一個pipeline需要實作自己準備批量放入的方式
			@Override
			public Void doInRedis(RedisConnection connection) throws DataAccessException {
				//迴圈裝入物件
				aa.entrySet().forEach(entry->{
					byte[] field = redisSerializer.serialize(entry.getKey());
					connection.hIncrBy(key, field, entry.getValue());
				});
				return null;
			}
		};
		
		List<?> result = cache.excutePipeline(pipelineCallback);
		long a2 = System.currentTimeMillis();
		System.out.println((a2-a1)/1000);
		System.out.println(123);
	}
	
	//@Test
	public void testPutObj() {
		GameIssue issue = new GameIssue();
		List<GameIssue> issues = new ArrayList<GameIssue>();
		issues.add(issue);
		issue.setFullIssue("1234");
		cache.putObj("aa", issues);
	}
	
	@SuppressWarnings("unchecked")
//	@Test
	public void testGteObj() {
		List<GameIssue> issues = (List<GameIssue>) cache.getObj("aa");
		System.out.println(issues);
	}
	
	//@Test
	public void testHset() {
		GameIssue issue = new GameIssue();
		List<GameIssue> issues = new ArrayList<GameIssue>();
		issues.add(issue);
		issue.setFullIssue("1234");
		cache.hset("aaa", "111", issues);
	}
	
	//@Test
	public void testHgetAll() {
		Map<Object, Object> issues = cache.hgetAll("aaa");
		System.out.println(issues);
	}
	
	@Test
	public void testHmset() {
		long a1 = System.currentTimeMillis();
		//裝載號碼及金額資料
		Map<String,Double> aa = new HashMap<>();
		for(Integer i=1 ;i<=200000;i++) {
			aa.put(i.toString(), i*1.0);
		}
		aa.put("tot", 10000*1.0);
		cache.getRedisTemplate().opsForHash().putAll("a1234", aa);
		
		long a2 = System.currentTimeMillis();
		System.out.println((a2-a1));
		
	}

	
}
