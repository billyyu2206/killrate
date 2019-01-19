package com.etonghk.killrate.mq.sender;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.config.RabbitMqConfig;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Component
public class KillRateBetSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
     
    @Resource(name=RabbitMqConfig.KILL_RATE_BET_QUEUE)
    private Queue queue;
    
    /**
     * 寄送Order訂單
     * @param order
     */
    public void senderGameLotteryOrder(GameLotteryOrder order) {
    	logger.info("bet data==>lottery={},billno={}",order.getLottery(),order.getBillno());
    	rabbitTemplate.convertAndSend(queue.getName(), order);
    }
    
	
}
