package com.etonghk.killrate.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BetRecordBean implements Serializable {
	private String gameId;
	private Integer betMultiplier;
	private Integer betStake;
	private String betItem;
	private String betContent;
	private BigDecimal odds;
	private String oddsGroup;
	private String gamePlayId;
	private Integer status;
	private Integer sendMsgNumber;
	private BigDecimal betAmount;
	private Integer amode = Integer.valueOf(1);
	private Integer siteId;
	private Date periodEndDate;

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Integer getBetMultiplier() {
		return this.betMultiplier;
	}

	public void setBetMultiplier(Integer betMultiplier) {
		this.betMultiplier = betMultiplier;
	}

	public Integer getBetStake() {
		return this.betStake;
	}

	public void setBetStake(Integer betStake) {
		this.betStake = betStake;
	}

	public String getBetItem() {
		return this.betItem;
	}

	public void setBetItem(String betItem) {
		this.betItem = betItem;
	}

	public String getBetContent() {
		return this.betContent;
	}

	public void setBetContent(String betContent) {
		this.betContent = betContent;
	}

	public BigDecimal getOdds() {
		return this.odds;
	}

	public void setOdds(BigDecimal odds) {
		this.odds = odds;
	}

	public String getOddsGroup() {
		return this.oddsGroup;
	}

	public void setOddsGroup(String oddsGroup) {
		this.oddsGroup = oddsGroup;
	}

	public String getGamePlayId() {
		return this.gamePlayId;
	}

	public void setGamePlayId(String gamePlayId) {
		this.gamePlayId = gamePlayId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSendMsgNumber() {
		return this.sendMsgNumber;
	}

	public void setSendMsgNumber(Integer sendMsgNumber) {
		this.sendMsgNumber = sendMsgNumber;
	}

	public BigDecimal getBetAmount() {
		return this.betAmount;
	}

	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}

	public Integer getAmode() {
		return this.amode;
	}

	public void setAmode(Integer amode) {
		this.amode = amode;
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Date getPeriodEndDate() {
		return this.periodEndDate;
	}

	public void setPeriodEndDate(Date periodEndDate) {
		this.periodEndDate = periodEndDate;
	}
}