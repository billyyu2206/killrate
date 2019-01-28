package com.etonghk.killrate.mq.receiver;

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
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.CacheRefreshMqConfig;
import com.etonghk.killrate.vo.CacheRefreshVo;
import com.rabbitmq.client.Channel;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Component
public class CacheRefreshReceiver {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	public Queue cacheRefreshQueue() {
        return new AnonymousQueue();
    }
	
	@Bean
    public Binding bindingCacheRefresh(@Qualifier(CacheRefreshMqConfig.CACHE_REFRESH_EXCHANGE) FanoutExchange fanoutExchange, Queue cacheRefreshQueue) {
        return BindingBuilder.bind(cacheRefreshQueue).to(fanoutExchange);
    }
	
	@RabbitListener(queues= "#{cacheRefreshQueue.name}")
	public void receive(CacheRefreshVo cacheRefreshVo, Message message, Channel channel) throws IOException {
		try {
			logger.info("cache refresh receiver ==> cacheName={}",cacheRefreshVo.getCacheName());
			// TODO cacheRefreshService
			System.out.println("test receive");
		}catch (Exception e) {
			logger.error("cacheRefreshQueue receive error ", e);
		}finally {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
	}
}
