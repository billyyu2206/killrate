package com.etonghk.killrate.awardNmber.ssc.qw;

public class QwBase {

	/**
	 *  趣味玩法判斷
	 * @param playId
	 * @return 一帆风顺qwyffs:1 好事成双qwhscs:2 三星报喜qwsxbx:3 四季发财qwsjfc:4
	 */
	public static int getQwNumber(String playId) {
		if("qwyffs".equals(playId)) {
			return 1;
		} else if("qwhscs".equals(playId)) {
			return 2;
		} else if("qwsxbx".equals(playId)) {
			return 3;
		} else if("qwsjfc".equals(playId)) {
			return 4;
		}
		return -1;
	}
}
