package com.etonghk.killrate.awardNmber.ssc.rx;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 任選複式
 * 
 * @author Peter
 *
 */
@AwardComponent(name = { "rx2fs", "rx3fs", "rx4fs" })
public class RxfsAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberOfType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<>();
		String[][] rowcols = new String[5][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit, -1);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		int rxNum = getRxNum(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanZhiXuan(rowcols, rxNum); // rxNum 任幾位數
		result.put("1", resultList);

		return result;

	}

	Map<String, Map<String, String>> playNumberMap;

	static Map<String, String> awardNumberMap = new HashMap<String, String>();
	static Map<String, String> betNumberMap = new HashMap<String, String>();
	static {
		awardNumberMap.put("rx2fs-1", "11---");
	}
	static {
		betNumberMap.put("rx2fs-1", "11000");
	}

	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {

		Map<String, BigDecimal> result = new HashMap<>();
		String playId = betOrder.getGamePlayId();
		Integer betMultiplier = betOrder.getBetMultiplier();

		for (Entry<String, List<String>> map : typeByAwardNumber.entrySet()) {
			String propertyKey = playId + "-" + map.getKey();

			// 拿投注項目 中獎號碼
			String awardNumber = awardNumberMap.get(propertyKey);
			String betNumber = betNumberMap.get(propertyKey);
			System.out.println(propertyKey + " awardNumber : " + awardNumber);
			System.out.println(propertyKey + " betNumber : " + betNumber);
			// 中獎金額
//			 String awardMoney = jar.getAwardMoney(playId,awardNumber,betNumber,betMultiplier);
			BigDecimal awardMoney = getAwardMoney(awardNumber, betNumber);
			List<String> numberList = map.getValue();
			for (String number : numberList) {
				addResult(result, number, awardMoney);
			}
		}
		return result;
	}

	private void addResult(Map<String, BigDecimal> numberMap, String number, BigDecimal awardMoney) {
		if (numberMap.get(number) == null) {
			numberMap.put(number, awardMoney);
		} else {
			numberMap.put(number, numberMap.get(number).add(awardMoney));
		}
	}
	
	// 假的回傳金額
	private BigDecimal getAwardMoney(String awardNumber, String betNumber) {
		BigDecimal result;
		result = new BigDecimal("123.00");

		return result;
	}

}
