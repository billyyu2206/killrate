package com.etonghk.killrate.mq.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Configuration
public class RabbitMqConfig {

	public static final String KILL_RATE_BET_QUEUE="KILL_RATE_BET";
	
	public static final String CLEAR_RATE_QUEUE="CLEAR_RATE_QUEUE.A";
	
	public static final String CLEAR_RATE_EXCHANGE="CLEAR_RATE_EXCHANGE";
	
	@Bean(name= {KILL_RATE_BET_QUEUE})
	public Queue killRateBetQueue() {
		return new Queue(KILL_RATE_BET_QUEUE);
	}
	
	@Bean(name= {CLEAR_RATE_QUEUE})
	public Queue clearRateQueue() {
//		 Map<String, Object> map = new HashMap<String, Object>();
//	     map.put("x-dead-letter-exchange", CLEAR_RATE_EXCHANGE);//设置死信交换机
		return new Queue(CLEAR_RATE_QUEUE);
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
	    return rabbitTemplate;
	}
	 
	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
	    return new Jackson2JsonMessageConverter();
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