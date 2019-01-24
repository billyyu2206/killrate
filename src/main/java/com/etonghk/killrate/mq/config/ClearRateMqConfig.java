package com.etonghk.killrate.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 殺率結算
 * @author Ami.Tsai
 * @date 2019年1月24日
 */
@Configuration
public class ClearRateMqConfig {

	public static final String CLEAR_RATE_QUEUE="CLEAR_RATE_QUEUE";
	
	public static final String CLEAR_RATE_EXCHANGE="CLEAR_RATE_EXCHANGE";
	
	
	@Bean(name= {CLEAR_RATE_QUEUE})
	public Queue clearRateQueue() {
		return new Queue(CLEAR_RATE_QUEUE);
	}

	
	@Bean(name= {CLEAR_RATE_EXCHANGE})
	public FanoutExchange clearRateExchange() {
        return new FanoutExchange(CLEAR_RATE_EXCHANGE);
    }
	
	@Bean
	public Binding bindingClearRateExchange(@Qualifier(CLEAR_RATE_QUEUE)Queue clearRateQueue, 
    		@Qualifier(CLEAR_RATE_EXCHANGE) FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(clearRateQueue).to(fanoutExchange);
    }
	
}
