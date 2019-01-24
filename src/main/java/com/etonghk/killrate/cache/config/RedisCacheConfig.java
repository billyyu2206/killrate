package com.etonghk.killrate.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 
 * @author Ami.Tsai
 * @date 2019年1月17日
 */
@Configuration
public class RedisCacheConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
//		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return redisTemplate;
	}
	
}