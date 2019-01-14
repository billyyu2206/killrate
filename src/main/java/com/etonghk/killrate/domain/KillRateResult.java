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
	
	private String gameId;

	public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
}