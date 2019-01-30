/**
 * 
 */
package com.etonghk.killrate.controller.dto.request;

import java.util.List;

/**
 * @author Peter.Hong
 * @date 2019年1月29日
 */
public class LotteryIssue {

	private String lottery;
	
	private List<String> issueList;

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

	public List<String> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<String> issueList) {
		this.issueList = issueList;
	}
	
}
