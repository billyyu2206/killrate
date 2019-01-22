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
		allGameMap.put("tls60","tls60");
		allGameMap.put("tls90","tls90");
		allGameMap.put("tls30","tls30");
		allGameMap.put("tls90a","tls90a");
		allGameMap.put("tls90b","tls90b");
		allGameMap.put("tls90c","tls90c");
		allGameMap.put("tls90d","tls90d");
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
		allGameTypeMap.put("tls60","ssc");
		allGameTypeMap.put("tls90","ssc");
		allGameTypeMap.put("tls30","ssc");
		allGameTypeMap.put("tls90a","ssc");
		allGameTypeMap.put("tls90b","ssc");
		allGameTypeMap.put("tls90c","ssc");
		allGameTypeMap.put("tls90d","ssc");
		allGameTypeMap.put("t2s30","ssc");
		allGameTypeMap.put("t3s90","ssc");
		allGameTypeMap.put("t2s90","ssc");
		allGameTypeMap.put("t3s120","ssc");
		allGameTypeMap.put("t6s120","ssc");
		allGameTypeMap.put("t6s180","ssc");
	}
}
