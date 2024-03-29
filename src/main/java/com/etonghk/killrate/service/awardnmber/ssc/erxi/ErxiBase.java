package com.etonghk.killrate.service.awardnmber.ssc.erxi;

import com.etonghk.killrate.service.awardnmber.ssc.SSCAwardUtils;

/**
 * 二星基础类别
 * @author Peter
 *
 */
public abstract class ErxiBase {

		
	/**
	 * 
	 * @param pos 0前 1中 2后
	 * @return [0]:pre [1]:suf
	 */
	public int[] getErxiPos(String playId) {
		int pos = SSCAwardUtils.getFrontOrMiddleOrBack(playId);
		int[] result = new int[2];
		if(pos==0) {
			result[0] = 0;
			result[1] = 3;
		}else {
			result[0] = 3;
			result[1] = 0;			
		}
		return result;
	}
	
	/**
	 * 判斷跨度位數
	 * @param pos 0前 1中 2后
	 * @return [0]:pre [1]:suf
	 */
	public int[] getErxiKdPos(String playId) {
		int pos = SSCAwardUtils.getKDFrontOrMiddleOrBack(playId);
		int[] result = new int[2];
		if(pos==0) {
			result[0] = 0;
			result[1] = 3;
		}else {
			result[0] = 3;
			result[1] = 0;			
		}
		return result;
	}
}
