package com.etonghk.killrate.service.awardnmber.config;

import java.util.Date;

public class LHCNumberConfig {
	private Integer id;
	private String gameId;
	private String numType;
	private String gameNumber;
	private Date startTime;
	private Date endTime;
	private String specialFlag;
	private Integer idx;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getNumType() {
		return this.numType;
	}

	public void setNumType(String numType) {
		this.numType = numType;
	}

	public String getGameNumber() {
		return this.gameNumber;
	}

	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getSpecialFlag() {
		return this.specialFlag;
	}

	public void setSpecialFlag(String specialFlag) {
		this.specialFlag = specialFlag;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}
}
