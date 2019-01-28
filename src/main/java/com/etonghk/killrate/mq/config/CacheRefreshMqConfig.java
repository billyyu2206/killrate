package com.etonghk.killrate.mq.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 緩存更新MQ
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Configuration
public class CacheRefreshMqConfig {
	public static final String CACHE_REFRESH_EXCHANGE = "CACHE_REFRESH_EXCHANGE";
	
	@Bean(name= {CACHE_REFRESH_EXCHANGE})
	public FanoutExchange cacheRefreshExchange() {
        return new FanoutExchange(CACHE_REFRESH_EXCHANGE);
    }
}
