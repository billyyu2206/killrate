package com.etonghk.killrate.domain;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 
 * @author Ami
 *
 */
@SuppressWarnings("serial")
public class KillRateResult extends HashMap<String,BigDecimal>{

	private String issueCode;
	
	private String lottery;

	public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}
	
}