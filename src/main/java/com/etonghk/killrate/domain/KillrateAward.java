package com.etonghk.killrate.domain;

import java.util.Date;

public class KillrateAward {
    private Integer id;

    private String gameId;

    private String issue;

    private String awardNumber;

    private Date awardTime;
    
    private Date issueEndTime;

    private Integer isPush;
    
    private Integer killrate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
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

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public Integer getIsPush() {
        return isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

	public Date getIssueEndTime() {
		return issueEndTime;
	}

	public void setIssueEndTime(Date issueEndTime) {
		this.issueEndTime = issueEndTime;
	}

	public Integer getKillrate() {
		return killrate;
	}

	public void setKillrate(Integer killrate) {
		this.killrate = killrate;
	}
    
	
}