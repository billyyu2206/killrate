package com.etonghk.killrate.domain;

import java.util.Date;

public class GameIssue {
    private Integer id;

    private String gameId;

    private String issue;

    private String fullIssue;

    private Date issueStartTime;

    private Date issueEndTime;
    
    private Date issueOpenTime;

    private Date issueDate;

    private String playId;

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

    public String getFullIssue() {
        return fullIssue;
    }

    public void setFullIssue(String fullIssue) {
        this.fullIssue = fullIssue == null ? null : fullIssue.trim();
    }

    public Date getIssueStartTime() {
        return issueStartTime;
    }

    public void setIssueStartTime(Date issueStartTime) {
        this.issueStartTime = issueStartTime;
    }

    public Date getIssueEndTime() {
        return issueEndTime;
    }

    public void setIssueEndTime(Date issueEndTime) {
        this.issueEndTime = issueEndTime;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId == null ? null : playId.trim();
    }

	public Date getIssueOpenTime() {
		return issueOpenTime;
	}

	public void setIssueOpenTime(Date issueOpenTime) {
		this.issueOpenTime = issueOpenTime;
	}
    
    
}