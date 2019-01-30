package com.etonghk.killrate.mq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.KillRateBetMqConfig;
import com.etonghk.killrate.vo.BetOrderQueueVo;
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
    public void senderGameLotteryOrder(BetOrderQueueVo queueVo) {
    	GameLotteryOrder order = queueVo.getGameLotteryOrder();
    	logger.info("bet sender==>lottery={},billno={},issue{}",order.getLottery(),order.getBillno(),order.getIssue());
    	rabbitTemplate.convertAndSend(KillRateBetMqConfig.KILL_RATE_BET_QUEUE, queueVo);
    }
    
    /**
     * 寄送Order訂單直接進死信
     * @param order
     */
    public void senderGameLotteryOrderDead(BetOrderQueueVo queueVo) {
    	GameLotteryOrder order = queueVo.getGameLotteryOrder();
    	logger.info("bet dead sender==>lottery={},billno={},issue{}",order.getLottery(),order.getBillno(),order.getIssue());
    	rabbitTemplate.convertAndSend(KillRateBetMqConfig.KILL_RATE_BET_QUEUE_DEAD, queueVo);
    }
    
	
}
