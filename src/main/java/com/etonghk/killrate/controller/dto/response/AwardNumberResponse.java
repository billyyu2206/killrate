package com.etonghk.killrate.controller.dto.response;

import java.io.Serializable;

public class AwardNumberResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String gameId;
	
	private String issue;
	
	private String awardNumber;
	
	private Long timeStamp;
	
	private String time;
	
	private String statCode;
	
	private String statMsg;

	public String getStatCode() {
		return statCode;
	}

	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}

	public String getStatMsg() {
		return statMsg;
	}

	public void setStatMsg(String statMsg) {
		this.statMsg = statMsg;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getAwardNumber() {
		return awardNumber;
	}

	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
