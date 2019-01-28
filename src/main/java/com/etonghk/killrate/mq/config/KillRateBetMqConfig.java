package com.etonghk.killrate.mq.config;

import java.util.HashMap;
import java.util.Map;

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

	public static final String KILL_RATE_BET_QUEUE="KILL_RATE_BET_QUEUE_BILLY";
	public static final String KILL_RATE_BET_QUEUE_DEAD="KILL_RATE_BET_QUEUE_DEAD_BILLY";
	
	@Bean(name= {KILL_RATE_BET_QUEUE})
	public Queue killRateBetQueue() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("x-dead-letter-exchange", "");
		args.put("x-dead-letter-routing-key", KILL_RATE_BET_QUEUE_DEAD);
		return new Queue(KILL_RATE_BET_QUEUE, true, false, false, args);
	}

	
	@Bean(name= {KILL_RATE_BET_QUEUE_DEAD})
	public Queue killRateBetQueueDead() {
		return new Queue(KILL_RATE_BET_QUEUE_DEAD);
	}
}
