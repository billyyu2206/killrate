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
import com.etonghk.killrate.vo.ClearKillRateVo;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@Component
public class T3S90ClearListener extends BaseClearListener implements ClearKillRate{

	@Async
	@EventListener(condition="#event.clearKillRateVo.lottery == 't3s90'")
	public void handler(ClearEvent event) {
		resultQueue.add(event);
		clearIssueKillRate();
	}

	@Bean
	public Queue t3S90ClearQueue() {
        return new AnonymousQueue();
    }
	
	@Bean
    public Binding bindingT3S90(FanoutExchange fanoutExchange, Queue t3S90ClearQueue) {
        return BindingBuilder.bind(t3S90ClearQueue).to(fanoutExchange);
    }
	
	@RabbitListener(queues= "#{t3S90ClearQueue.name}")
	public void clearResult(ClearKillRateVo vo) {
		pushAwardNumberToRedis(vo);
	}
	
}