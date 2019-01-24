package com.etonghk.killrate.cache.key;

/**
 * @author Ami.Tsai
 * @date 2019年1月24日
 */
public class RedisKey {
	
	/**
	 * 遊戲獎期Key
	 * @param gameId
	 * @param issue
	 * @return
	 */
	public static String getLotteryIssueKey(String lottery,String issue) {
		return lottery+":"+issue;
	}
	
	public static String getLotteryIssueLockKey(String lottery,String issue) {
		return lottery+"-"+issue+"-lock";
	}
	
	/**
	 * 判斷該獎期是否結算完成key
	 * @param gameId
	 * @param issue
	 * @return
	 */
	public static String getLotteryIssueClearFinishKey(String lottery,String issue) {
		return lottery+"-"+issue+"-"+"finish";
	}
	
	/**
	 * 判斷該獎期是否結算完成key
	 * @param gameId
	 * @param issue
	 * @return
	 */
	public static String getServerCount() {
		return "KillRate-Server";
	}
	
}