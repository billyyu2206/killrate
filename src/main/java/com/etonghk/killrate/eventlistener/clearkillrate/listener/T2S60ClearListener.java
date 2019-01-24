package com.etonghk.killrate.eventlistener.clearkillrate.listener;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@Component
public class T2S60ClearListener extends BaseClearListener implements ClearKillRate{

	@Async
	@EventListener(condition="#event.clearKillRateVo.lottery == t2s60")
	public void handler(ClearEvent event) {
		resultQueue.add(event);
		clearIssueKillRate();
	}
	
	@Bean
	public Queue t2S60ClearQueue() {
        return new AnonymousQueue();
    }
	
	@Bean
    public Binding bindingT2S60(FanoutExchange fanoutExchange, Queue t2S60ClearQueue) {
        return BindingBuilder.bind(t2S60ClearQueue).to(fanoutExchange);
    }
	
	@RabbitListener(queues= "#{t2S60ClearQueue.name}")
	public void clearResult(String gameIssueKey) {
		pushAwardNumberToRedis(gameIssueKey);
	}

}