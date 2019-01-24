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
public class T6S120ClearListener extends BaseClearListener implements ClearKillRate{

	@Async
	@EventListener(condition="#event.clearKillRateVo.lottery == 't6s120'")
	public void handler(ClearEvent event) {
		resultQueue.add(event);
		clearIssueKillRate();
	}

	@Bean
	public Queue t6S120ClearQueue() {
        return new AnonymousQueue();
    }
	
	@Bean
    public Binding bindingT6S120(FanoutExchange fanoutExchange, Queue t6S120ClearQueue) {
        return BindingBuilder.bind(t6S120ClearQueue).to(fanoutExchange);
    }
	
	@RabbitListener(queues= "#{t6S120ClearQueue.name}")
	public void clearResult(ClearKillRateVo vo) {
		pushAwardNumberToRedis(vo);
	}
	
}