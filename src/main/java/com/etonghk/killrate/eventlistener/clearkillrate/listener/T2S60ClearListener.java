package com.etonghk.killrate.eventlistener.clearkillrate.listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;
import com.etonghk.killrate.mq.config.ClearRateMqConfig;
import com.etonghk.killrate.vo.ClearKillRateVo;
import com.rabbitmq.client.Channel;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@Component
public class T2S60ClearListener extends BaseClearListener implements ClearKillRate{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Async
	@EventListener(condition="#event.clearKillRateVo.lottery == 't2s60'")
	public void handler(ClearEvent event) {
		resultQueue.add(event);
		clearIssueKillRate();
	}
	
	@Bean
	public Queue t2S60ClearQueue() {
        return new AnonymousQueue();
    }
	
	@Bean
    public Binding bindingT2S60(@Qualifier(ClearRateMqConfig.CLEAR_RATE_EXCHANGE) FanoutExchange fanoutExchange, Queue t2S60ClearQueue) {
        return BindingBuilder.bind(t2S60ClearQueue).to(fanoutExchange);
    }
	
	@RabbitListener(queues= "#{t2S60ClearQueue.name}")
	public void clearResult(ClearKillRateVo vo ,Message message, Channel channel) throws IOException {
		try {
			pushAwardNumberToRedis(vo);
		}catch (Exception e) {
			logger.error("t2S60ClearQueue receive error ", e);
		}finally {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
	}

}