package com.etonghk.killrate.awardNmber.ssc.sixi;

import com.etonghk.killrate.awardNmber.ssc.SSCAwardUtils;

/**
 * 四星基础类别
 * @author Peter
 *
 */
public abstract class SixiBase {

		
	/**
	 * 
	 * @param pos 0前 1中 2后
	 * @return [0]:pre [1]:suf
	 */
	public int[] getSixiPos(String playId) {
		int pos = SSCAwardUtils.getFrontOrMiddleOrBack(playId);
		int[] result = new int[2];
		if(pos==0) {
			result[0] = 0;
			result[1] = 1;
		}else {
			result[0] = 1;
			result[1] = 0;			
		}
		return result;
	}
}
