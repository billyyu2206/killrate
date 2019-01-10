package com.etonghk.killrate.awardNmber.ssc.wuxi;

public abstract class WuxiBase {

	/**
	 * 定位膽位數
	 * @param playId
	 * @return
	 */
    protected  int getBdwNum(String playId) {
    	String lastChar = playId.substring(playId.length()-3, playId.length()-2);
    	return Integer.valueOf(lastChar);
    }
}
