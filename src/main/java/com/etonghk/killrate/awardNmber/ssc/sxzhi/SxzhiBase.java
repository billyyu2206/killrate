package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import com.etonghk.killrate.awardNmber.ssc.SSCAwardUtils;

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
	public int[] getSxzhiPos(String playId) {
		int pos = SSCAwardUtils.getFrontOrMiddleOrBack(playId);

		int[] result = new int[2];
		int preLength = pos;
		int sufLength = 2-preLength;
		
		result[0] = preLength;
		result[1] = sufLength;
		
		return result;
	}
}
