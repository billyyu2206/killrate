package com.etonghk.killrate.killerUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.config.SSCConfig;
import com.etonghk.killrate.constant.AmodeType;
import com.etonghk.killrate.constant.KillerConstant;
import com.etonghk.killrate.vo.BetRecordBean;


public class SSCKillerUtils {
	private static final String BetLineSplit = "[|]";
	private static final String BetItemSplit = "[&]";
	private static final String[] checkRepeatPlayId = { "004003006", "013003006", "003003006", "004003004", "013003004",
			"003003004", "004003005", "013003005", "003003005" };

	public static HashMap<String, String> getSSCAwardMap(HashMap<String, String> sscAwardMap,
			List<BetRecordBean> betList) {
		for (BetRecordBean betOrder : betList) {
			List<String> needAwardNumberList = getNeedAwardNumber(betOrder);

			BigDecimal award = null;
			String gamePlayId = betOrder.getGamePlayId();
			List<String> checkRepeatPlayIdList = Arrays.asList(checkRepeatPlayId);
			int startIndex;
			int endIndex;
			String[] odds;
			if (checkRepeatPlayIdList.contains(gamePlayId.substring(3))) {
				startIndex = 0;
				endIndex = 1;
				if ("004".equals(gamePlayId.substring(3, 6))) {
					startIndex = 0;
					endIndex = 3;
				} else if ("013".equals(gamePlayId.substring(3, 6))) {
					startIndex = 1;
					endIndex = 4;
				} else if ("003".equals(gamePlayId.substring(3, 6))) {
					startIndex = 2;
					endIndex = 5;
				}
				odds = betOrder.getOddsGroup().split(",");
				for (String number : needAwardNumberList) {
					String[] arr = (String[]) Arrays.copyOfRange(number.split(""), startIndex, endIndex);
					if (isRepeat(arr)) {
						award = new BigDecimal(odds[0]).multiply(new BigDecimal(betOrder.getBetMultiplier().intValue()))
								.multiply(new BigDecimal(AmodeType.getValue(betOrder.getAmode().intValue())));
					} else {
						award = new BigDecimal(odds[1]).multiply(new BigDecimal(betOrder.getBetMultiplier().intValue()))
								.multiply(new BigDecimal(AmodeType.getValue(betOrder.getAmode().intValue())));
					}
					sscAwardMap.put(number,
							BigDecimal.valueOf(Double.parseDouble(((String) sscAwardMap.get(number)).toString()))
									.add(award).toString());
				}
			} else {
				award = betOrder.getOdds().multiply(new BigDecimal(betOrder.getBetMultiplier().intValue()))
						.multiply(new BigDecimal(AmodeType.getValue(betOrder.getAmode().intValue())));
				for (String number : needAwardNumberList) {
					sscAwardMap.put(number,
							BigDecimal.valueOf(Double.parseDouble(((String) sscAwardMap.get(number)).toString()))
									.add(award).toString());
				}
			}
			sscAwardMap.put(KillerConstant.totBetAmount,
					BigDecimal.valueOf(Double.parseDouble(((String) sscAwardMap.get(KillerConstant.totBetAmount)).toString()))
							.add(betOrder.getBetAmount()).toString());
		}
		return sscAwardMap;
	}

	private static List<String> getNeedAwardNumber(BetRecordBean betOrder) {
		List<String> resultList = new ArrayList<String>();
		String gamePlayId = betOrder.getGamePlayId();
		switch (gamePlayId.substring(3)) {
		case "001001001":
			resultList = SSC001001001(betOrder);
			break;
		case "001001002":
			resultList = SSC001001002(betOrder);
			break;
		case "001003001":
			resultList = SSC001003001(betOrder);
			break;
		case "001003002":
			resultList = SSC001003002(betOrder);
			break;
		case "001003003":
			resultList = SSC001003003(betOrder);
			break;
		case "001003004":
			resultList = SSC001003004(betOrder);
			break;
		case "001003005":
			resultList = SSC001003005(betOrder);
			break;
		case "001003006":
			resultList = SSC001003006(betOrder);
			break;
		case "002001001":
			resultList = SSC002001001(betOrder);
			break;
		case "002001002":
			resultList = SSC002001002(betOrder);
			break;
		case "002003001":
			resultList = SSC002003001(betOrder);
			break;
		case "002003002":
			resultList = SSC002003002(betOrder);
			break;
		case "002003003":
			resultList = SSC002003003(betOrder);
			break;
		case "002003004":
			resultList = SSC002003004(betOrder);
			break;
		case "003001001":
			resultList = SSC003001001(betOrder);
			break;
		case "003001002":
			resultList = SSC003001002(betOrder);
			break;
		case "003001003":
			resultList = SSC003001003(betOrder);
			break;
		case "003003001":
			resultList = SSC003003001(betOrder);
			break;
		case "003003002":
			resultList = SSC003003002(betOrder);
			break;
		case "003003004":
			resultList = SSC003003004(betOrder);
			break;
		case "003003005":
			resultList = SSC003003005(betOrder);
			break;
		case "004001001":
			resultList = SSC004001001(betOrder);
			break;
		case "004001002":
			resultList = SSC004001002(betOrder);
			break;
		case "004001003":
			resultList = SSC004001003(betOrder);
			break;
		case "004003001":
			resultList = SSC004003001(betOrder);
			break;
		case "004003002":
			resultList = SSC004003002(betOrder);
			break;
		case "004003004":
			resultList = SSC004003004(betOrder);
			break;
		case "004003005":
			resultList = SSC004003005(betOrder);
			break;
		case "013001001":
			resultList = SSC013001001(betOrder);
			break;
		case "013001002":
			resultList = SSC013001002(betOrder);
			break;
		case "013001003":
			resultList = SSC013001003(betOrder);
			break;
		case "013003001":
			resultList = SSC013003001(betOrder);
			break;
		case "013003002":
			resultList = SSC013003002(betOrder);
			break;
		case "013003004":
			resultList = SSC013003004(betOrder);
			break;
		case "013003005":
			resultList = SSC013003005(betOrder);
			break;
		case "005001001":
			resultList = SSC005001001(betOrder);
			break;
		case "005001002":
			resultList = SSC005001002(betOrder);
			break;
		case "005001003":
			resultList = SSC005001003(betOrder);
			break;
		case "005001005":
			resultList = SSC005001005(betOrder);
			break;
		case "005001006":
			resultList = SSC005001006(betOrder);
			break;
		case "005001007":
			resultList = SSC005001007(betOrder);
			break;
		case "005002001":
			resultList = SSC005002001(betOrder);
			break;
		case "005002002":
			resultList = SSC005002002(betOrder);
			break;
		case "005002003":
			resultList = SSC005002003(betOrder);
			break;
		case "005002005":
			resultList = SSC005002005(betOrder);
			break;
		case "005002006":
			resultList = SSC005002006(betOrder);
			break;
		case "005002007":
			resultList = SSC005002007(betOrder);
			break;
		case "006001002":
			resultList = SSC006001002(betOrder);
			break;
		case "007001001":
			resultList = SSC007001001(betOrder);
			break;
		case "007001002":
			resultList = SSC007001002(betOrder);
			break;
		case "007001003":
			resultList = SSC007001003(betOrder);
			break;
		case "007001004":
			resultList = SSC007001004(betOrder);
			break;
		case "007001005":
			resultList = SSC007001005(betOrder);
			break;
		case "007001006":
			resultList = SSC007001006(betOrder);
			break;
		case "007002001":
			resultList = SSC007002001(betOrder);
			break;
		case "007002002":
			resultList = SSC007002002(betOrder);
			break;
		case "007003001":
			resultList = SSC007003001(betOrder);
			break;
		case "007003002":
			resultList = SSC007003002(betOrder);
			break;
		case "007003003":
			resultList = SSC007003003(betOrder);
			break;
		case "008001001":
			resultList = SSC008001001(betOrder);
			break;
		case "008001003":
			resultList = SSC008001003(betOrder);
			break;
		case "009001001":
			resultList = SSC009001001(betOrder);
			break;
		case "009001002":
			resultList = SSC009001002(betOrder);
			break;
		case "009001003":
			resultList = SSC009001003(betOrder);
			break;
		case "009001004":
			resultList = SSC009001004(betOrder);
			break;
		case "003001004":
			resultList = SSC003001004(betOrder);
			break;
		case "004001004":
			resultList = SSC004001004(betOrder);
			break;
		case "013001004":
			resultList = SSC013001004(betOrder);
			break;
		case "003003006":
			resultList = SSC003003006(betOrder);
			break;
		case "004003006":
			resultList = SSC004003006(betOrder);
			break;
		case "013003006":
			resultList = SSC013003006(betOrder);
			break;
		case "003003007":
			resultList = SSC003003007(betOrder);
			break;
		case "004003007":
			resultList = SSC004003007(betOrder);
			break;
		case "013003007":
			resultList = SSC013003007(betOrder);
			break;
		case "003003008":
			resultList = SSC003003008(betOrder);
			break;
		case "004003008":
			resultList = SSC004003008(betOrder);
			break;
		case "013003008":
			resultList = SSC013003008(betOrder);
			break;
		case "005001004":
			resultList = SSC005001004(betOrder);
			break;
		case "005001008":
			resultList = SSC005001008(betOrder);
			break;
		case "005002004":
			resultList = SSC005002004(betOrder);
			break;
		case "005002008":
			resultList = SSC005002008(betOrder);
			break;
		case "008001004":
			resultList = SSC008001004(betOrder);
			break;
		case "008001005":
			resultList = SSC008001005(betOrder);
		}
		return resultList;
	}

	private static List<String> SSC001001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[5][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);

		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 0, 0);
		return resultList;
	}

	private static List<String> SSC002001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[4][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 1, 0);
		return resultList;
	}

	private static List<String> SSC003001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 2, 0);
		return resultList;
	}

	private static List<String> SSC004001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 0, 2);
		return resultList;
	}

	private static List<String> SSC013001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 1, 1);
		return resultList;
	}

	private static List<String> SSC005001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[2][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 0, 3);
		return resultList;
	}

	private static List<String> SSC005001005(BetRecordBean betOrder) {
		String[][] rowcols = new String[2][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 3, 0);
		return resultList;
	}

	private static List<String> SSC001001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 0);
		return resultList;
	}

	private static List<String> SSC002001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 1, 0);
		return resultList;
	}

	private static List<String> SSC003001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 2, 0);
		return resultList;
	}

	private static List<String> SSC004001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 2);
		return resultList;
	}

	private static List<String> SSC013001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 1, 1);
		return resultList;
	}

	private static List<String> SSC005001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 3);
		return resultList;
	}

	private static List<String> SSC005001006(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 3, 0);
		return resultList;
	}

	private static List<String> SSC003001003(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = (String) ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 2, 0);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC004001003(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = (String) ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 2);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC013001003(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = (String) ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 1, 1);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC005001003(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2HG = SSCConfig.SSC2HG;
			String awardNumber = (String) ssc2HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 3);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC005001007(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2HG = SSCConfig.SSC2HG;
			String awardNumber = (String) ssc2HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 3, 0);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC001003001(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(5));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC001003002(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(3));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 4);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC001003003(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(2));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC001003004(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(3), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(3), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(2));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC001003005(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(3), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(2), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(3), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC001003006(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(4), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(4), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC002003001(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(4));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 4);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 0);
		return resultList;
	}

	private static List<String> SSC002003002(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(2));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 0);
		return resultList;
	}

	private static List<String> SSC002003003(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(2));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 0);
		return resultList;
	}

	private static List<String> SSC002003004(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(3), StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(3), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 0);
		return resultList;
	}

	private static List<String> SSC004003001(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(items, ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC013003001(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(items, ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC003003001(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(2), StringUtils.join(items, ","));
		betDataMap.put(Integer.valueOf(1), StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(2), Integer.valueOf(1));
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(1));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC004003002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(3));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC013003002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(3));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC003003002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(3));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC004003005(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC013003005(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC003003005(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC003003006(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String betItem : items) {
			List<String> tempList = AwardNumberGenerateUtils.getTsuShiuanBauDanNumber(betItem, 3);
			resultList.addAll(tempList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC004003006(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String betItem : items) {
			List<String> tempList = AwardNumberGenerateUtils.getTsuShiuanBauDanNumber(betItem, 3);
			resultList.addAll(tempList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC013003006(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String betItem : items) {
			List<String> tempList = AwardNumberGenerateUtils.getTsuShiuanBauDanNumber(betItem, 3);
			resultList.addAll(tempList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC005002004(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String betItem : items) {
			List<String> tempList = AwardNumberGenerateUtils.getTsuShiuanBauDanNumber(betItem, 2);
			resultList.addAll(tempList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 3);
		return resultList;
	}

	private static List<String> SSC005002008(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String betItem : items) {
			List<String> tempList = AwardNumberGenerateUtils.getTsuShiuanBauDanNumber(betItem, 2);
			resultList.addAll(tempList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 3, 0);
		return resultList;
	}

	private static List<String> SSC003003007(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC004003007(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC013003007(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC003003008(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC004003008(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC013003008(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC003003004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = (String) ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> itemList = arrayToList(items);
			if (SSCConfig.SSC3HGBAUTZ.keySet().contains(c)) {
				itemList.remove(SSCConfig.SSC3HGBAUTZ.get(c));
			}
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(itemList, 2, 0);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC004003004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = (String) ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> itemList = arrayToList(items);
			if (SSCConfig.SSC3HGBAUTZ.keySet().contains(c)) {
				itemList.remove(SSCConfig.SSC3HGBAUTZ.get(c));
			}
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(itemList, 0, 2);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC013003004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = (String) ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> itemList = arrayToList(items);
			if (SSCConfig.SSC3HGBAUTZ.keySet().contains(c)) {
				itemList.remove(SSCConfig.SSC3HGBAUTZ.get(c));
			}
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(itemList, 1, 1);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC005002001(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(2));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 3);
		return resultList;
	}

	private static List<String> SSC005002005(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(Integer.valueOf(1), StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(Integer.valueOf(1), Integer.valueOf(2));

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 3, 0);
		return resultList;
	}

	private static List<String> SSC005002002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 3);
		return resultList;
	}

	private static List<String> SSC005002006(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation((String) resultList.get(i), 0,
					((String) resultList.get(i)).length(), "", resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 3, 0);
		return resultList;
	}

	private static List<String> SSC005002003(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2HG = SSCConfig.SSC2HG;
			String awardNumber = (String) ssc2HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> itemList = arrayToList(items);
			if (SSCConfig.SSC2HGPAIR.keySet().contains(c)) {
				itemList.remove(SSCConfig.SSC2HGPAIR.get(c));
			}
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(itemList, 0, 3);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC005002007(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2HG = SSCConfig.SSC2HG;
			String awardNumber = (String) ssc2HG.get(c);
			String[] items = awardNumber.split(",");
			List<String> itemList = arrayToList(items);
			if (SSCConfig.SSC2HGPAIR.keySet().contains(c)) {
				itemList.remove(SSCConfig.SSC2HGPAIR.get(c));
			}
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(itemList, 3, 0);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC006001002(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit, -1);
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < rows.length; i++) {
			if (!StringUtils.isEmpty(rows[i])) {
				String[] cols = rows[i].split(BetItemSplit);
				for (String c : cols) {
					AwardNumberGenerateUtils.addPreAndAfter(c, i, 4 - i, resultList);
				}
			}
		}
		return resultList;
	}

	private static List<String> SSC007001001(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 1, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC007001002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 2, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC007001003(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 1, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC007001004(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 2, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC007001005(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 1, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC007001006(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 2, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 1);
		return resultList;
	}

	private static List<String> SSC007002001(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 1, 4);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 0);
		return resultList;
	}

	private static List<String> SSC007002002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 2, 4);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 1, 0);
		return resultList;
	}

	private static List<String> SSC007003001(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 1, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC007003002(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 2, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC007003003(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, 3, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

	private static List<String> SSC008001001(BetRecordBean betOrder) {
		String[][] rowcols = new String[2][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> resultList = AwardNumberGenerateUtils.getDaShiauDanShuang(rowcols);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 3, 0);
		return resultList;
	}

	private static List<String> SSC008001003(BetRecordBean betOrder) {
		String[][] rowcols = new String[2][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> resultList = AwardNumberGenerateUtils.getDaShiauDanShuang(rowcols);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 3);
		return resultList;
	}

	private static List<String> SSC008001004(BetRecordBean betOrder) {
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> resultList = AwardNumberGenerateUtils.getDaShiauDanShuang(rowcols);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 2, 0);
		return resultList;
	}

	private static List<String> SSC008001005(BetRecordBean betOrder) {
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> resultList = AwardNumberGenerateUtils.getDaShiauDanShuang(rowcols);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 2);
		return resultList;
	}

	private static List<String> SSC009001001(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, 1, 5);
		return resultList;
	}

	private static List<String> SSC009001002(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, 2, 5);
		return resultList;
	}

	private static List<String> SSC009001003(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, 3, 5);
		return resultList;
	}

	private static List<String> SSC009001004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, 4, 5);
		return resultList;
	}

	private static List<String> SSC003001004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3Kuadu = SSCConfig.SSC3KuaDu;
			String awardNumber = (String) ssc3Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 2, 0);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC004001004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3Kuadu = SSCConfig.SSC3KuaDu;
			String awardNumber = (String) ssc3Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 2);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC013001004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3Kuadu = SSCConfig.SSC3KuaDu;
			String awardNumber = (String) ssc3Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 1, 1);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC005001004(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2Kuadu = SSCConfig.SSC2KuaDu;
			String awardNumber = (String) ssc2Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 3);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> SSC005001008(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2Kuadu = SSCConfig.SSC2KuaDu;
			String awardNumber = (String) ssc2Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, 3, 0);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	private static List<String> getAwardList(String[] itemList, int start, int end) {
		List<String> resultList = arrayToList(itemList);
		return getAwardList(resultList, start, end);
	}

	private static List<String> getAwardList(List<String> itemList, int start, int end) {
		List<String> resultList = new ArrayList<String>();
		for (String data : SSCConfig.allDataList) {
			for (String betItem : itemList) {
				if (betItem.equals(data.substring(start, end))) {
					resultList.add(data);
				}
			}
		}
		return resultList;
	}

	private void testWriteLog(String data) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter("D://log.txt", true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(data);
			return;
		} catch (IOException localIOException1) {
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static List<String> arrayToList(String[] array) {
		List<String> result = new ArrayList<String>();
		for (String item : array) {
			result.add(item);
		}
		return result;
	}

	public static HashMap<String, String> getNewSSCAwardMap() {
		HashMap<String, String> sscAwardProfitMap = new HashMap<String, String>();
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						for (int m = 0; m <= 9; m++) {
							sscAwardProfitMap.put("" + i + j + k + l + m, "0");
						}
					}
				}
			}
		}
		sscAwardProfitMap.put(KillerConstant.totBetAmount, "0");
		return sscAwardProfitMap;
	}

	public static boolean isRepeat(String[] a) {
		if (a == null) {
			return false;
		}
		Set<String> set = new HashSet<String>();
		for (String str : a) {
			set.add(str);
		}
		if (set.size() != a.length) {
			return true;
		}
		return false;
	}
}