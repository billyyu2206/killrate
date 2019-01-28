package com.etonghk.killrate.service.awardnmber.ssc.sixi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.service.awardnmber.AwardNumber;
import com.etonghk.killrate.service.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.service.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后四星_组选12
 * 前四星_组选12
 * @author Ami
 *
 */
@AwardComponent(name={"sixzux12h","sixzux12q"})
public class Sixzux12AwardNumber extends SixiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] rows = order.getContent().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(1, StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 1);
		dataCountMap.put(1, 2);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		
		int[] pos = getSixiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, pos[0], pos[1]);
		
		result.put("1", resultList);
		return result;
	}
}