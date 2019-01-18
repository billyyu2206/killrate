package com.etonghk.killrate.mq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.config.RabbitMqConfig;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Component
public class KillRateBetReceiver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RabbitListener(queues = RabbitMqConfig.KILL_RATE_BET_QUEUE)
    public void receive(GameLotteryOrder order) {
		logger.info("receiver==> " + order.toString());
    }

	
}
