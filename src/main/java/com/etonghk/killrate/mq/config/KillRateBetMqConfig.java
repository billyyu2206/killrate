package com.etonghk.killrate.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 殺率獎號計算
 * @author Ami.Tsai
 * @date 2019年1月24日
 */
@Configuration
public class KillRateBetMqConfig {

	public static final String KILL_RATE_BET_QUEUE="KILL_RATE_BET_QUEUE";
	
	@Bean(name= {KILL_RATE_BET_QUEUE})
	public Queue killRateBetQueue() {
		return new Queue(KILL_RATE_BET_QUEUE);
	}

}
