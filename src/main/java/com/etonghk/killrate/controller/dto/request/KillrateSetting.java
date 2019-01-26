package com.etonghk.killrate.controller.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Billy.Yu
 * @date 2019年1月17日
 */
@SuppressWarnings("serial")
public class KillrateSetting implements Serializable{
	
	private String lottery;
	private String issue;
	private Integer killrate;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	private LocalDateTime operateTime;
	
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
	public Integer getKillrate() {
		return killrate;
	}
	public void setKillrate(Integer killrate) {
		this.killrate = killrate;
	}
	public LocalDateTime getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(LocalDateTime operateTime) {
		this.operateTime = operateTime;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
}
