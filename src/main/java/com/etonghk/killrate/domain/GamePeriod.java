/**
 * 
 */
package com.etonghk.killrate.domain;

import java.io.Serializable;

/**
 * 獎期設定
 * 
 * @author Peter.Hong
 * @date 2019年1月23日
 */
@SuppressWarnings("serial")
public class GamePeriod implements Serializable{
	
	private Integer id;
	
	/**
	 * 	遊戲id
	 */
	private String lottery;

	/**
	 * 	開始時間
	 */
	private String startTime;
	
	/**
	 * 	周期
	 */
	private Integer periodSeconds;
	
	/**
	 * 	遊戲名稱
	 */
	private String lotteryName;
	
	/**
	 * 	總期數
	 */
	private Integer totalPeriod;
	
	/**
	 * 	使否啟用
	 */
	private Boolean status;
	
	/**
	 * 	開獎時間
	 */
	private Integer openSeconds;

		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getPeriodSeconds() {
		return periodSeconds;
	}

	public void setPeriodSeconds(Integer periodSeconds) {
		this.periodSeconds = periodSeconds;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getTotalPeriod() {
		return totalPeriod;
	}

	public void setTotalPeriod(Integer totalPeriod) {
		this.totalPeriod = totalPeriod;
	}

	public Integer getOpenSeconds() {
		return openSeconds;
	}

	public void setOpenSeconds(Integer openSeconds) {
		this.openSeconds = openSeconds;
	} 
	
}
