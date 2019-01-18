/**
 * 
 */
package com.etonghk.killrate.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Billy.Yu
 * @date 2019年1月16日
 */
public class KillrateConstant {
	public static final String TOTAL_BET = "tot";
	
	public static Map<String, String> allGameMap;
	static {
		allGameMap = new HashMap<String, String>();
		allGameMap.put("vipssc", "VIP时时彩");
	}
	
	public static Map<String, String> allGameTypeMap;
	static {
		allGameTypeMap = new HashMap<String, String>();
		allGameTypeMap.put("vipssc", "ssc");
	}
}
