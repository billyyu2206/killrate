package com.etonghk.killrate.mq.receiver;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;
import com.etonghk.killrate.mq.config.KillRateBetMqConfig;
import com.etonghk.killrate.service.ordercalculate.OrderCalculateService;
import com.etonghk.killrate.service.orderdeadletterlog.OrderDeadLetterLogService;
import com.etonghk.killrate.vo.BetOrderQueueVo;
import com.etonghk.killrate.vo.ClearKillRateVo;
import com.jack.entity.GameLotteryOrder;
import com.rabbitmq.client.Channel;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Component
public class KillRateBetReceiver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderCalculateService orderCalculateService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private OrderDeadLetterLogService orderDeadLetterLogService;
	
	/**
	 * 注單計算consumer,計算完畢存在本身內存
	 * @param order
	 * @throws IOException 
	 */
	@RabbitListener(queues=KillRateBetMqConfig.KILL_RATE_BET_QUEUE, concurrency="10")
    public void receive(BetOrderQueueVo queueVo, Message message, Channel channel) throws IOException {
    	try {
    		GameLotteryOrder order = queueVo.getGameLotteryOrder();
			logger.info("receiver==>lottery={},billno={},issue={}", order.getLottery(), order.getBillno(), order.getIssue());
			Map<String,BigDecimal> orderResult = orderCalculateService.doCalOrder(order);
			ClearKillRateVo vo = new ClearKillRateVo();
			vo.setAwardNumber(orderResult);
			vo.setIssue(order.getIssue());
			vo.setLottery(order.getLottery());
			vo.setBillNo(order.getBillno());
			applicationContext.publishEvent(new ClearEvent(vo));
			logger.info("before cal "+vo.getBillNo());
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			logger.info("ack cal {},{}",vo.getBillNo(),order.getIssue());
		}catch (Exception ex) {
			logger.error("receiver error: ", ex);
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
		}
    }
	
	/**
	 * 注單計算consumer死信
	 * @param order
	 * @throws IOException 
	 */
	@RabbitListener(queues=KillRateBetMqConfig.KILL_RATE_BET_QUEUE_DEAD, concurrency="3")
    public void receiveDead(BetOrderQueueVo queueVo, Message message, Channel channel) throws IOException {
		try {
			GameLotteryOrder order = queueVo.getGameLotteryOrder();
			logger.info("receiver dead==>lottery={},billno={},issue={},message={}", order.getLottery(), order.getBillno(), order.getIssue(), queueVo.getMessage());
			orderDeadLetterLogService.insertOrder(order, queueVo.getMessage());
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}catch (Exception ex) {
			logger.error("receiver dead error: ", ex);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
		
    }
	
}