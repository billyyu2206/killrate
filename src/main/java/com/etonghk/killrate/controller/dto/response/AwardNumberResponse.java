package com.etonghk.killrate.controller.dto.response;

import java.io.Serializable;

public class AwardNumberResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String lottery;
	
	private String issue;
	
	private String awardNumber;
	
	private Long timeStamp;
	
	private String time;

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
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
