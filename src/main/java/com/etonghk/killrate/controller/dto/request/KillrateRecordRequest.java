/**
 * 
 */
package com.etonghk.killrate.controller.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Peter.Hong
 * @date 2019年1月18日
 */
public class KillrateRecordRequest {

	@DateTimeFormat (pattern="YYYY-MM-dd")
	private LocalDateTime issueDate;
	
	private String lottery;
	
	private Boolean isKillRate;

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

	public Boolean getIsKillRate() {
		return isKillRate;
	}

	public void setIsKillRate(Boolean isKillRate) {
		this.isKillRate = isKillRate;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}
}
