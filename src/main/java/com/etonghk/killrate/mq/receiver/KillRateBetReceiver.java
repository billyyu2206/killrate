package com.etonghk.killrate.mq.receiver;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;
import com.etonghk.killrate.eventlistener.clearkillrate.vo.ClearKillRateVo;
import com.etonghk.killrate.mq.config.KillRateBetMqConfig;
import com.etonghk.killrate.service.orderCalculate.OrderCalculateService;
import com.jack.entity.GameLotteryOrder;

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
	
	/**
	 * 注單計算consumer,計算完畢存在本身內存
	 * @param order
	 */
	@RabbitListener(queues = KillRateBetMqConfig.KILL_RATE_BET_QUEUE,concurrency="10")
    public void receive(GameLotteryOrder order) {
    	logger.info("receiver==>lottery={},billno={},issue{}",order.getLottery(),order.getBillno(),order.getIssue());
		Map<String,BigDecimal> orderResult = orderCalculateService.doCalOrder(order);
		ClearKillRateVo vo = new ClearKillRateVo();
		vo.setAwardNumber(orderResult);
		vo.setIssue(order.getIssue());
		vo.setLottery(order.getLottery());
		vo.setBillNo(order.getBillno());
		applicationContext.publishEvent(new ClearEvent(vo));
    }
	
}