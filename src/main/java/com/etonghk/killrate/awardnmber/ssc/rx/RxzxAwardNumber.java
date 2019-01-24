package com.etonghk.killrate.awardnmber.ssc.rx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 	任选_组选   任二组选 任三组六
 * @author Billy
 *
 */
@AwardComponent(name={"rx2zx","rx3z6"})
public class RxzxAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int rxNum = getRxNum(order.getMethod());
		
		String[] betDatas = order.getContent().split("]");
		String[] numsData = betDatas[1].split(BetZxSplit);
		String[] pos = getBetPos(order.getContent());
		
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(numsData, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, rxNum);
		
		List<String[]> betPermutations = AwardNumberGenerateUtils.getTzuShiuanNumberForRenXuan(betDataMap, dataCountMap, rxNum);
		
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanTzuShiuanResult(pos, rxNum, 5, betPermutations);
		result.put("1", resultList);
		return result;
	}
}
