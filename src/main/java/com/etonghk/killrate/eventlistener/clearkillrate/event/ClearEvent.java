package com.etonghk.killrate.eventlistener.clearkillrate.event;

import java.util.UUID;

import org.springframework.context.ApplicationEvent;

import com.etonghk.killrate.vo.ClearKillRateVo;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@SuppressWarnings("serial")
public class ClearEvent extends ApplicationEvent{

	protected ClearKillRateVo clearKillRateVo ;
	
	private String uuId = UUID.randomUUID().toString();
	
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

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}


}