package com.etonghk.killrate.service.awardnmber.ssc.sxzhi;

import com.etonghk.killrate.service.awardnmber.ssc.SSCAwardUtils;

/**
 * 三星基础类别
 * @author Peter
 *
 */
public abstract class SxzhiBase {

		
	/**
	 * 
	 * @param pos 0前 1中 2后
	 * @return [0]:pre [1]:suf
	 */
    protected int[] getSxzhiPos(String playId) {
		int pos = SSCAwardUtils.getFrontOrMiddleOrBack(playId);
		return getPadArray(pos);
	}
	/**
	 * 
	 * @param pos 0前 1中 2后
	 * @return [0]:pre [1]:suf
	 */
    protected int[] getSxzhiKDPos(String playId) {
		int pos = SSCAwardUtils.getKDFrontOrMiddleOrBack(playId);
		return getPadArray(pos);
	}
    
    /**
               *   計算前後須補足的位數
     * @param pos
     * @return [0]:pre [1]:suf
     */
    private int[] getPadArray(int pos) {
		int[] result = new int[2];
		int preLength = pos;
		int sufLength = 2-preLength;
		
		result[0] = preLength;
		result[1] = sufLength;
		
		return result;
    }
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
