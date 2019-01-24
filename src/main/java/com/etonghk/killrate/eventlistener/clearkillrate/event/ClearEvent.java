package com.etonghk.killrate.eventlistener.clearkillrate.event;

import org.springframework.context.ApplicationEvent;

import com.etonghk.killrate.eventlistener.clearkillrate.vo.ClearKillRateVo;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@SuppressWarnings("serial")
public class ClearEvent extends ApplicationEvent{

	protected ClearKillRateVo clearKillRateVo ;
	
	/**
	 * @param source
	 */
	public ClearEvent(Object source) {
		super(source);
		clearKillRateVo = (ClearKillRateVo) source;
	}

	public ClearKillRateVo getClearKillRateVo() {
		return clearKillRateVo;
	}

	public void setClearKillRateVo(ClearKillRateVo clearKillRateVo) {
		this.clearKillRateVo = clearKillRateVo;
	}


}