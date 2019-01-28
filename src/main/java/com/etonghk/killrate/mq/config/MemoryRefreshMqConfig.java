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
public class MemoryRefreshMqConfig {
	public static final String MEMORY_REFRESH_EXCHANGE = "MEMORY_REFRESH_EXCHANGE";
	
	@Bean(name= {MEMORY_REFRESH_EXCHANGE})
	public FanoutExchange memoryRefreshExchange() {
        return new FanoutExchange(MEMORY_REFRESH_EXCHANGE);
    }
}
