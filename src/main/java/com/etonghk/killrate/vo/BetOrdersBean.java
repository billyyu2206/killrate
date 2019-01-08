package com.etonghk.killrate.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BetOrdersBean implements Serializable {
	private List<BetRecordBean> betList;
	private Integer sendMsgNumber;
	private String issue;
	private String gameId;
	private boolean isAdd;
	private Date endTime;

	public List<BetRecordBean> getBetList() {
		return this.betList;
	}

	public void setBetList(List<BetRecordBean> betList) {
		this.betList = betList;
	}

	public Integer getSendMsgNumber() {
		return this.sendMsgNumber;
	}

	public void setSendMsgNumber(Integer sendMsgNumber) {
		this.sendMsgNumber = sendMsgNumber;
	}

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public boolean isAdd() {
		return this.isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
