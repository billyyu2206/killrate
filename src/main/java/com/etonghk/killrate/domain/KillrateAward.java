package com.etonghk.killrate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @author Ami.Tsai
 * @date 2019年1月25日
 */
@SuppressWarnings("serial")
public class KillrateAward implements Serializable{

	private Integer id;

    private String lottery;

    private String issue;

    private String awardNumber;

    private LocalDateTime awardTime;
    
    private LocalDateTime issueEndTime;

    private Integer isPush;
    
    private Integer killrate;
    
    private BigDecimal awardMoney;
    
    private BigDecimal betMoney;
    
    /**
     * 0:未開 1:正常開獎 2:異常開獎
     */
    private Integer openStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery == null ? null : lottery.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public Integer getIsPush() {
        return isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

	public Integer getKillrate() {
		return killrate;
	}

	public void setKillrate(Integer killrate) {
		this.killrate = killrate;
	}

	public BigDecimal getAwardMoney() {
		return awardMoney;
	}

	public void setAwardMoney(BigDecimal awardMoney) {
		this.awardMoney = awardMoney;
	}

	public BigDecimal getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(BigDecimal betMoney) {
		this.betMoney = betMoney;
	}

	public LocalDateTime getAwardTime() {
		return awardTime;
	}

	public void setAwardTime(LocalDateTime awardTime) {
		this.awardTime = awardTime;
	}

	public LocalDateTime getIssueEndTime() {
		return issueEndTime;
	}

	public void setIssueEndTime(LocalDateTime issueEndTime) {
		this.issueEndTime = issueEndTime;
	}

	public Integer getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(Integer openStatus) {
		this.openStatus = openStatus;
	}
	
}