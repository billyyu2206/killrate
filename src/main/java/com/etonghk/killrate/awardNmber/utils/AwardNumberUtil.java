package com.etonghk.killrate.awardNmber.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.etonghk.killrate.awardNmber.ssc.SSCAwardUtils;
import com.etonghk.killrate.vo.BetRecordBean;

public class AwardNumberUtil {

	Map<String, Map<String, String>> playNumberMap;

	static Map<String, String> awardNumberMap = new HashMap<String, String>();
	static Map<String, String> betNumberMap = new HashMap<String, String>();
	static {
		awardNumberMap.put("rx2fs-1", "11---");
	}
	static {
		betNumberMap.put("rx2fs-1", "11000");
	}
	
	/**
	 * 依類型 計算號碼中獎金額
	 * @param betOrder
	 * @param typeByAwardNumber
	 * @return
	 */
	public static Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO 需call jar拿取中獎金額 下面寫死供測試用
		Map<String, BigDecimal> result = new HashMap<>();
		String playId = betOrder.getGamePlayId();
		// Integer betMultiplier = betOrder.getBetMultiplier(); // 倍數

		for (Entry<String, List<String>> map : typeByAwardNumber.entrySet()) {
			String propertyKey = playId + "-" + map.getKey();

			// 拿投注項目 中獎號碼
			String awardNumber = awardNumberMap.get(propertyKey);
			String betNumber = betNumberMap.get(propertyKey);
			// 中獎金額
//			 String awardMoney = jar.getAwardMoney(playId,awardNumber,betNumber,betMultiplier);
			BigDecimal awardMoney = getAwardMoney(awardNumber, betNumber);
			List<String> numberList = map.getValue();
			for (String number : numberList) {
				SSCAwardUtils.addAwardMoney(result, number, awardMoney);
			}
		}
		return result;
	}
	
	// 假的回傳金額
	private static BigDecimal getAwardMoney(String awardNumber, String betNumber) {
		BigDecimal result;
		result = new BigDecimal("123.00");

		return result;
	}
	
	public static String getAwardNumber(String gameId,String issue) {
		
		return "1,2,3,4,5";
	}
}
