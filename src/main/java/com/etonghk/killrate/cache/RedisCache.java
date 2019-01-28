package com.etonghk.killrate.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Ami
 *
 */
@Component("redisCache")
public class RedisCache implements Cache{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void putObj(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void putObj(String key, Object value, int liveTime, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value, liveTime, unit);
	}

	@Override
	public Object getObj(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void del(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Long incr(String key) {
		return redisTemplate.opsForValue().increment(key);
	}

	/* (non-Javadoc)
	 * @see com.etonghk.killrate.cache.Cache#excutePipeline(org.springframework.data.redis.core.RedisCallback)
	 */
	@Override
	public List<?> excutePipeline(RedisCallback<?> pipelineCallback) {
		return redisTemplate.executePipelined(pipelineCallback);
	}
	

	@Override
	public Map<Object, Object> hgetAll(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	/* (non-Javadoc)
	 * @see com.etonghk.killrate.cache.Cache#hset(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public void hset(String key, Object field, Object value) {
		redisTemplate.opsForHash().put(key, field, value);
	}
	
	@Override
	public Boolean setLock(String key,Object value) {
		return redisTemplate.opsForValue().setIfAbsent(key, value);
	}

	/* (non-Javadoc)
	 * @see com.etonghk.killrate.cache.Cache#decrby(java.lang.String, long)
	 */
	@Override
	public Long decrby(String key) {
		return redisTemplate.opsForValue().decrement(key);
	}

	/* (non-Javadoc)
	 * @see com.etonghk.killrate.cache.Cache#hdel(java.lang.String, java.lang.Object)
	 */
	@Override
	public Long hdel(String key, Object field) {
		return redisTemplate.opsForHash().delete(key, field);
	}
}