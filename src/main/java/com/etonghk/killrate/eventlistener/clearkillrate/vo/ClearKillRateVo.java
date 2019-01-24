package com.etonghk.killrate.eventlistener.clearkillrate.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@SuppressWarnings("serial")
public class ClearKillRateVo implements Serializable{

	private String lottery;
	
	private String issue;
	
	private Map<String,BigDecimal> awardNumber ;

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

	public Map<String, BigDecimal> getAwardNumber() {
		return awardNumber;
	}

	public void setAwardNumber(Map<String, BigDecimal> awardNumber) {
		this.awardNumber = awardNumber;
	}
	
}