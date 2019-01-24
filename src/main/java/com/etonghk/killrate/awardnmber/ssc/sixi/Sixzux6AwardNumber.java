package com.etonghk.killrate.awardnmber.ssc.sixi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后四星_组选6
 * 前四星_组选6
 * @author Ami
 *
 */
@AwardComponent(name={"sixzux6h","sixzux6q"})
public class Sixzux6AwardNumber extends SixiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] rows = order.getContent().split(BetZxSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 2);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		int[] pos = getSixiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, pos[0], pos[1]);
		
		result.put("1", resultList);
		return result;
	}
}