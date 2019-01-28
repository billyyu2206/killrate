package com.etonghk.killrate.service.awardnmber.ssc.lh;

import java.util.HashMap;
import java.util.Map;

public class LhBase {
	
	public static Map<String, String> lhTypeMap = new HashMap<String, String>();
	static {
		lhTypeMap.put("龙", "1");
		lhTypeMap.put("虎", "2");
		lhTypeMap.put("和", "3");
	}
	/**
	 * 龍虎鬥位數 
	 * @param playId
	 * @return lon:[0] hu:[1]
	 */
	public int[] getLhPos(String playId) {
		int[] result = new int[2];
		String lon = playId.substring(playId.length()-2, playId.length()-1);
		String hu = playId.substring(playId.length()-1, playId.length());
		result[0] = lhPos(lon);
		result[1] = lhPos(hu);
		return result;
	}
	private int lhPos(String lh) {
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
}
