package com.etonghk.killrate.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class GameIssue implements Serializable{
    private Integer id;

    private String lottery;

    private String issue;

    private String fullIssue;

    private LocalDateTime issueStartTime;

    private LocalDateTime issueEndTime;
    
    private LocalDateTime issueOpenTime;

    private LocalDateTime issueDate;

    private String playId;

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

    public String getFullIssue() {
        return fullIssue;
    }

    public void setFullIssue(String fullIssue) {
        this.fullIssue = fullIssue == null ? null : fullIssue.trim();
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId == null ? null : playId.trim();
    }

	public LocalDateTime getIssueStartTime() {
		return issueStartTime;
	}

	public void setIssueStartTime(LocalDateTime issueStartTime) {
		this.issueStartTime = issueStartTime;
	}

	public LocalDateTime getIssueEndTime() {
		return issueEndTime;
	}

	public void setIssueEndTime(LocalDateTime issueEndTime) {
		this.issueEndTime = issueEndTime;
	}

	public LocalDateTime getIssueOpenTime() {
		return issueOpenTime;
	}

	public void setIssueOpenTime(LocalDateTime issueOpenTime) {
		this.issueOpenTime = issueOpenTime;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameIssue [id=" + id + ", lottery=" + lottery + ", issue="
				+ issue + ", fullIssue=" + fullIssue + ", issueStartTime="
				+ issueStartTime + ", issueEndTime=" + issueEndTime
				+ ", issueOpenTime=" + issueOpenTime + ", issueDate="
				+ issueDate + ", playId=" + playId + "]";
	}
    
    
}