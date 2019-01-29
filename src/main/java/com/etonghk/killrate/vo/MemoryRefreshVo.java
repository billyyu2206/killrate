package com.etonghk.killrate.vo;

import java.io.Serializable;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@SuppressWarnings("serial")
public class MemoryRefreshVo implements Serializable{

	private String memoryName;
	
	public MemoryRefreshVo() {
		
	}
	
	public MemoryRefreshVo(String memoryName) {
		this.memoryName = memoryName;
	}

	public String getMemoryName() {
		return memoryName;
	}

	public void setMemoryName(String memoryName) {
		this.memoryName = memoryName;
	}

}
