package com.etonghk.killrate.awardnmber.ssc.wuxi;

public abstract class WuxiBase {

	/**
	 * 不定位膽位數
	 * @param playId
	 * @return
	 */
    protected int getBdwNum(String playId) {
    	String lastChar = playId.substring(playId.length()-2, playId.length()-1);
    	return Integer.valueOf(lastChar);
    }

}
