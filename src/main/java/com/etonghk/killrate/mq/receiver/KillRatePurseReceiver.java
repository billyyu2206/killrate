package com.etonghk.killrate.mq.receiver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.dao.BetRecordDao;
import com.etonghk.killrate.mq.config.KillRatePurseMqConfig;
import com.jack.entity.GameLotteryOrder;
import com.rabbitmq.client.Channel;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@Component
public class KillRatePurseReceiver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BetRecordDao betRecordDao;
	
	/**
	 * 追號注單consumer,直接寫入DB
	 * @param order
	 * @throws IOException 
	 */
	@RabbitListener(queues=KillRatePurseMqConfig.KILL_RATE_PURSE_QUEUE, concurrency="5")
    public void receive(GameLotteryOrder order, Message message, Channel channel) throws IOException {
    	try {
			logger.info("purse receiver==>lottery={},billno={},issue{}",order.getLottery(),order.getBillno(),order.getIssue());
			betRecordDao.insertPurseRec(order, order.getLottery(), order.getIssue().substring(0, 8));
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}catch (Exception ex) {
			logger.error("receiver error: ", ex);
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
		}
    }
	
	/**
	 * 追號注死信 consumer,直接寫入DB
	 * @param order
	 * @throws IOException 
	 */
	@RabbitListener(queues=KillRatePurseMqConfig.KILL_RATE_PURSE_QUEUE_DEAD, concurrency="3")
    public void receiveDead(GameLotteryOrder order, Message message, Channel channel) throws IOException {
		try {
			logger.info("purse receiver dead==>lottery={},billno={},issue{}", order.getLottery(),order.getBillno(),order.getIssue());
			betRecordDao.insertPurseRec(order, order.getLottery(), order.getIssue().substring(0, 8));
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}catch (Exception ex) {
			logger.error("receiver dead error: ", ex);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
		
    }
	
}