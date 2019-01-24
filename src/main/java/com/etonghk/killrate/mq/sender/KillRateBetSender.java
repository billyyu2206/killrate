package com.etonghk.killrate.mq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.KillRateBetMqConfig;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Component
public class KillRateBetSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
             * 寄送Order訂單
     * @param order
     */
    public void senderGameLotteryOrder(GameLotteryOrder order) {
    	logger.info("bet data==>lottery={},billno={}",order.getLottery(),order.getBillno());
    	rabbitTemplate.convertAndSend(KillRateBetMqConfig.KILL_RATE_BET_QUEUE, order);
    }
    
	
}
