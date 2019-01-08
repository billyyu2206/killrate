package com.etonghk.killrate.killerUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.etonghk.killrate.utils.CommonUtils;

public class SSCAwardKillerUtils {
	public static void calSSCAwardMap(HashMap<String, String> awardMap, Map<String, BigDecimal> totalAwardMap,
			Map<String, String> calMap, Map<String, BigDecimal> totalBetMap, Set<String> badAwardSet, String siteId) {
		BigDecimal totBetAmount = BigDecimal
				.valueOf(Double.parseDouble(((String) awardMap.get("totBetAmount")).toString()));
		awardMap.remove("totBetAmount");
		for (String awardKey : awardMap.keySet()) {
			BigDecimal betTotal = (BigDecimal) totalBetMap.get(siteId);
			BigDecimal point = totBetAmount.subtract(new BigDecimal((String) awardMap.get(awardKey)));
			if (!((String) calMap.get(siteId)).equals("1")) {
				point = BigDecimal.ZERO.subtract(point);
				if ((point.compareTo(BigDecimal.ZERO) == 1) && (betTotal.compareTo(BigDecimal.ZERO) == 1)) {
					BigDecimal percent = point.divide(betTotal, 3, 0).multiply(new BigDecimal(100));
					if (percent.compareTo(new BigDecimal(3)) == 1) {
						badAwardSet.add(awardKey);
					}
				}
			}
			if (totalAwardMap.containsKey(awardKey)) {
				totalAwardMap.put(awardKey, ((BigDecimal) totalAwardMap.get(awardKey)).add(point));
			} else {
				totalAwardMap.put(awardKey, point);
			}
		}
	}

	public static void calAwardList(List<String> awardList, Map<String, BigDecimal> totalAwardMap,
			Set<String> badAwardSet) {
		int dataCount = (int) Math.floor(totalAwardMap.keySet().size() * 0.3D);
		totalAwardMap = CommonUtils.sortByValueAsc(totalAwardMap);
		List<String> tempList = new ArrayList<String>();
		List<BigDecimal> tempValueList = new ArrayList<BigDecimal>();
		int count = 0;
		for (Map.Entry<String, BigDecimal> entry : totalAwardMap.entrySet()) {
			tempList.add(entry.getKey());
			tempValueList.add(entry.getValue());
		}
		for (int index = tempList.size() - 1; index >= 0; index--) {
			if ((count >= dataCount) && (((BigDecimal) tempValueList.get(index))
					.compareTo((BigDecimal) tempValueList.get(index + 1)) != 0)) {
				break;
			}
			String awardNum = (String) tempList.get(index);
			awardList.add(awardNum);
			count++;
		}
		if (badAwardSet.size() > 0) {
			for (String badAward : badAwardSet) {
				if (awardList.contains(badAward)) {
					awardList.remove(badAward);
				}
			}
		}
	}
}