package com.etonghk.killrate.vo;

import java.io.Serializable;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@SuppressWarnings("serial")
public class CacheRefreshVo implements Serializable{

	private String cacheName;
	
	public CacheRefreshVo() {
		
	}
	
	public CacheRefreshVo(String cacheName) {
		this.cacheName = cacheName;
	}
	
	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}
	

}
