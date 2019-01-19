package com.etonghk.killrate.awardNmber.ssc.rx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 任選三組三
 * 
 * @author Billy
 *
 */
@AwardComponent(name = {"rx3z3"})
public class Rxz3AwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int rxNum = getRxNum(order.getMethod());

		String[] betDatas = order.getContent().split("]");
		String[] numsData = betDatas[1].split(BetZxSplit);
		String[] pos = getBetPos(order.getContent());

		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(numsData, ","));
		betDataMap.put(1, StringUtils.join(numsData, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 1);
		dataCountMap.put(1, 1);

		List<String[]> betPermutations = AwardNumberGenerateUtils.getTzuShiuanNumberForRenXuan(betDataMap, dataCountMap, 2);

		List<String> resultList = AwardNumberGenerateUtils.getRenXuanTzuShiuanResult(pos, rxNum, 5, betPermutations);
		result.put("1", resultList);
		return result;
	}
}
