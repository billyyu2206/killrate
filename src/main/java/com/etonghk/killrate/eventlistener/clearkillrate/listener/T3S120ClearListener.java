package com.etonghk.killrate.eventlistener.clearkillrate.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@Component
public class T3S120ClearListener extends BaseClearListener implements ClearKillRate{

	@Async
	@EventListener(condition="#event.clearKillRateVo.lottery == t3s120")
	public void clear(ClearEvent event) {
		resultQueue.add(event);
		clearIssueKillRate();
	}

}