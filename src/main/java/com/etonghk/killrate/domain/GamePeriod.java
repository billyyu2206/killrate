/**
 * 
 */
package com.etonghk.killrate.domain;

/**
 * 獎期設定
 * 
 * @author Peter.Hong
 * @date 2019年1月23日
 */
public class GamePeriod {
	
	private Integer id;
	
	/**
	 * 	遊戲id
	 */
	private String gameId;

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
	private String gameName;
	
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

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
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

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
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
