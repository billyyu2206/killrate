package com.etonghk.killrate.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisCallback;

/**
 * Cache 基礎類別
 * @author Ami
 *
 */
public interface Cache {
	
	void del(String key);

	void putObj(String key, Object value);
	
	Object getObj(String key);
	
	void putObj(String key, Object value,int liveTime,TimeUnit unit);
	
	Set<String> keys(final String pattern);
	
	boolean exists(final String key);
	
	Long incr(String key);
	
	List<?> excutePipeline(RedisCallback<?> pipelineCallback);
	
	void hset(String key,Object field,Object value);

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	Boolean setLock(String key, Object value);

	/**
	 * @param key
	 * @return
	 */
	Map<Object, Object> hgetAll(String key);
	
}