package com.etonghk.killrate.eventlistener.clearkillrate.listener;

import com.etonghk.killrate.eventlistener.clearkillrate.event.ClearEvent;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
public interface ClearKillRate {

	void handler(ClearEvent event);
}
