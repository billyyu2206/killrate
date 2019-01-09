package com.etonghk.killrate.awardNmber.ssc;

/**
 * 时时彩工具类别
 * @author Ami
 *
 */
public class SSCAwardUtils {
	
	/**
	 * 判断 四星 三星 二星
	 * @param playId
	 * @return 0前  1中 2后
	 */
	public static Integer getFrontOrMiddleOrBack(String playId) {
		String lastChar = playId.substring(playId.length()-2, playId.length()-1);
		if("q".equals(lastChar)) {
			return 0;
		}else if("z".equals(lastChar)) {
			return 1;			
		}else if("h".equals(lastChar)) {
			return 2;			
		}
		return -1;
	}
	
	/**
	 * 判断跨度 前 中 后
	 * @param playId
	 * @return 0前  1中 2后
	 */
	public static Integer getKDFrontOrMiddleOrBack(String playId) {
		String lastChar = playId.substring(playId.length()-3, playId.length()-2);
		if("q".equals(lastChar)) {
			return 0;
		}else if("z".equals(lastChar)) {
			return 1;			
		}else if("h".equals(lastChar)) {
			return 2;			
		}
		return -1;
	}
	/**
	 * 龍虎鬥位數 
	 * @param playId
	 * @return lon:[0] hu:[1]
	 */
	public static int[] getLhPos(String playId) {
		int[] result = new int[2];
		String lon = playId.substring(playId.length()-2, playId.length()-1);
		String hu = playId.substring(playId.length()-1, playId.length());
		result[0] = lhPos(lon);
		result[1] = lhPos(hu);
		return result;
	}
	private static int lhPos(String lh) {
		// 萬 w 千 q 百 b 十 s 個 g
		if("w".equals(lh)) {
			return 1;
		} else if("q".equals(lh)) {
			return 2;
		} else if("b".equals(lh)) {
			return 3;
		} else if("s".equals(lh)) {
			return 4;
		} else if("g".equals(lh)) {
			return 5;
		}
		return -1;
	}
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