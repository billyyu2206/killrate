package com.etonghk.killrate.service.enums;

/**
 * @author Billy.Yu
 * @date 2019年1月29日
 */
public enum MemoryEnum {
	
	AwardSample("award_sample", "awardSampleMemory"),
	KillrateAward("killrate_award", "killrateAwardMemory"),
	GameIssue("game_issue", "gameIssueMemory");
	private String memoryName;
	private String redisKey;
	
	private MemoryEnum(String memoryName,String redisKey){
		this.memoryName = memoryName;
		this.redisKey = redisKey;
	}

	public String getMemoryName() {
		return memoryName;
	}

	public void setMemoryName(String memoryName) {
		this.memoryName = memoryName;
	}

	public String getRedisKey() {
		return redisKey;
	}

	public void setRedisKey(String redisKey) {
		this.redisKey = redisKey;
	}
	
}
