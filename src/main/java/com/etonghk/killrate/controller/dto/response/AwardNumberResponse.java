package com.etonghk.killrate.controller.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AwardNumberResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String lottery;
	
	private String issue;
	
	private String awardNumber;
	
	private LocalDateTime openTime;
	
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

	public LocalDateTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalDateTime openTime) {
		this.openTime = openTime;
	}
	
}