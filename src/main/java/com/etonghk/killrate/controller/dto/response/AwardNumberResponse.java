package com.etonghk.killrate.controller.dto.response;

import java.io.Serializable;
import java.util.Date;

public class AwardNumberResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String lottery;
	
	private String issue;
	
	private String awardNumber;
	
	private Date openTime;
	
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

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	
}