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
public class T6S180ClearListener extends BaseClearListener implements ClearKillRate{

	@Async
	@EventListener(condition="#event.clearKillRateVo.lottery == t6s180")
	public void clear(ClearEvent event) {
		resultQueue.add(event);
		clearIssueKillRate();
	}
	/*
	@Bean
	public Queue t6S180ClearQueue() {
        return new AnonymousQueue();
    }
	
	@Bean
    public Binding bindingT6S180(FanoutExchange fanoutExchange, Queue t6S180ClearQueue) {
        return BindingBuilder.bind(t6S180ClearQueue).to(fanoutExchange);
    }*/
	
	//@RabbitListener(queues= "#{t6S180ClearQueue.name}")
	public void pushAwardNumberToRedis(String gameIssueKey) {
		System.out.println(123456);
		/*
		Map<String,BigDecimal> awardResult = awardNumber.get(gameIssueKey);
		if(awardResult==null) {
			return;
		}else {
			//取出key序列化元件
			RedisSerializer<String> redisSerializer = cache.getRedisKeySerializer();
			//要處理的key
			byte[] key = redisSerializer.serialize(gameIssueKey);
			RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
				//每一個pipeline需要實作自己準備批量放入的方式
				@Override
				public Void doInRedis(RedisConnection connection) throws DataAccessException {
					//迴圈裝入物件
					awardResult.entrySet().forEach(entry->{
						byte[] field = redisSerializer.serialize(entry.getKey());
						connection.hIncrBy(key, field, entry.getValue().doubleValue());
					});
					return null;
				}
			};
			cache.excutePipeline(pipelineCallback);
		}*/
	}

}