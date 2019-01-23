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
		allGameMap.put("t1s60","t1s60");
		allGameMap.put("t1s90","t1s90");
		allGameMap.put("t1s30","t1s30");
		allGameMap.put("t1s90a","t1s90a");
		allGameMap.put("t1s90b","t1s90b");
		allGameMap.put("t1s90c","t1s90c");
		allGameMap.put("t1s90d","t1s90d");
		allGameMap.put("t2s30","t2s30");
		allGameMap.put("t3s90","t3s90");
		allGameMap.put("t2s90","t2s90");
		allGameMap.put("t3s120","t3s120");
		allGameMap.put("t6s120","t6s120");
		allGameMap.put("t6s180","t6s180");
	}
	
	public static Map<String, String> allGameTypeMap;
	static {
		allGameTypeMap = new HashMap<String, String>();
		allGameTypeMap.put("t1s60","ssc");
		allGameTypeMap.put("t1s90","ssc");
		allGameTypeMap.put("t1s30","ssc");
		allGameTypeMap.put("t1s90a","ssc");
		allGameTypeMap.put("t1s90b","ssc");
		allGameTypeMap.put("t1s90c","ssc");
		allGameTypeMap.put("t1s90d","ssc");
		allGameTypeMap.put("t2s30","ssc");
		allGameTypeMap.put("t3s90","ssc");
		allGameTypeMap.put("t2s90","ssc");
		allGameTypeMap.put("t3s120","ssc");
		allGameTypeMap.put("t6s120","ssc");
		allGameTypeMap.put("t6s180","ssc");
	}
}
