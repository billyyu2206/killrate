package com.etonghk.killrate.awardnmber.config;

import java.util.HashMap;
import java.util.Map;

public class K3Config {
	public static final Map<String, String> K3HG = new HashMap<String, String>();
	public static final String K3TH3TS = "111,222,333,444,555,666";
	public static final Map<String, String> K3BTH3BG;
	public static final String K3LH3TS = "123,234,345,456";
	public static final Map<String, String> K3TH2FS;

	static {
		K3HG.put("3", "111");
		K3HG.put("4", "112");
		K3HG.put("5", "113,122");
		K3HG.put("6", "114,123,222");
		K3HG.put("7", "115,124,133,223");
		K3HG.put("8", "116,125,134,224,233");
		K3HG.put("9", "126,135,144,225,234,333");
		K3HG.put("10", "136,145,226,235,244,334");
		K3HG.put("11", "146,155,236,245,335,344");
		K3HG.put("12", "156,246,255,336,345,444");
		K3HG.put("13", "166,256,346,355,445");
		K3HG.put("14", "266,356,446,455");
		K3HG.put("15", "366,456,555");
		K3HG.put("16", "466,556");
		K3HG.put("17", "566");
		K3HG.put("18", "666");

		K3BTH3BG = new HashMap<String, String>();

		K3BTH3BG.put("123", "123");
		K3BTH3BG.put("1234", "123,124,134,234");
		K3BTH3BG.put("12345", "123,124,125,134,135,145,234,235,245,345");
		K3BTH3BG.put("123456", "123,124,125,126,134,135,136,145,146,156,234,235,236,245,246,256,345,346,356,456");

		K3TH2FS = new HashMap<String, String>();

		K3TH2FS.put("11", "112,113,114,115,116");
		K3TH2FS.put("22", "122,223,224,225,226");
		K3TH2FS.put("33", "133,233,334,335,336");
		K3TH2FS.put("44", "144,244,344,445,446");
		K3TH2FS.put("55", "155,255,355,455,556");
		K3TH2FS.put("66", "166,266,366,466,566");
	}

	public static final Map<String, String> K3BTH2BG = new HashMap<String, String>();

	public static String getAwardNumber(String bet, String gamePlayId) {
		String awardNumber = null;
		switch (gamePlayId) {
		case "K3002001001":
			awardNumber = (String) K3HG.get(bet);
			break;
		case "K3001002002":
			awardNumber = "111,222,333,444,555,666";
			break;
		case "K3001002001":
			awardNumber = bet;
			break;
		case "K3005001001":
			awardNumber = (String) K3BTH3BG.get(bet);
			break;
		case "K3003001001":
			awardNumber = "123,234,345,456";
			break;
		case "K3001001002":
			awardNumber = (String) K3TH2FS.get(bet);
			break;
		case "K3001001001":
			awardNumber = bet;
			break;
		case "K3004001001":
			awardNumber = (String) K3BTH2BG.get(bet);
			break;
		}
		return awardNumber;
	}
}
