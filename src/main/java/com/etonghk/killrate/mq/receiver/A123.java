package com.etonghk.killrate.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.RabbitMqConfig;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@Component
@RabbitListener(queues= {RabbitMqConfig.CLEAR_RATE_QUEUE})
public class A123 {

	@RabbitHandler
	public void pushAwardNumberToRedis(String gameIssueKey) {
		System.out.println(123456);
	}
	
}
