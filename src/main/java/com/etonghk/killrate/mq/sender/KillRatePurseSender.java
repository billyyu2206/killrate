package com.etonghk.killrate.mq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.KillRatePurseMqConfig;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
@Component
public class KillRatePurseSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 寄送Order訂單
     * @param order
     */
    public void senderGameLotteryOrder(GameLotteryOrder order) {
    	logger.info("purse sender==>lottery={},billno={},issue{}",order.getLottery(),order.getBillno(),order.getIssue());
    	rabbitTemplate.convertAndSend(KillRatePurseMqConfig.KILL_RATE_PURSE_QUEUE, order);
    }
    
	
}
