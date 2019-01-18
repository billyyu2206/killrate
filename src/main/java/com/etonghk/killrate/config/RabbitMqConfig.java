package com.etonghk.killrate.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Configuration
public class RabbitMqConfig {

	public static final String KILL_RATE_BET_QUEUE="KILL_RATE_BET";
	
	@Bean(name= {KILL_RATE_BET_QUEUE})
	public Queue killRateBetQueue() {
		return new Queue(KILL_RATE_BET_QUEUE);
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
	
	
}