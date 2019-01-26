package com.etonghk.killrate.controller.dto.request;

import java.time.LocalDateTime;

/**
 * @author Billy.Yu
 * @date 2019年1月23日
 */
public class KillrateSettingLogRequest {
	private String lottery;
    private Integer operateType;
    private String updateUser;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String sort = "desc";
	public String getLottery() {
		return lottery;
	}
	public void setLottery(String lottery) {
		this.lottery = lottery;
	}
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
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
