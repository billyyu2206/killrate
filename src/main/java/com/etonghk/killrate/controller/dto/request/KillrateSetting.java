package com.etonghk.killrate.controller.dto.request;

import java.util.Date;

/**
 * @author Billy.Yu
 * @date 2019年1月17日
 */
public class KillrateSetting {
	
	private String lottery;
	private String issue;
	private Integer killrate;
	private Date startTime;
	private Date endTime;
	
	private Date operateTime;
	
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
}
