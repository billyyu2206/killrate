package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * 五星_组选30
 * @author Ami
 *
 */
@Component("wxzux30")
public class Wxzux30AwardNumber implements AwardNumber{

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] rows = order.getContent().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(1, StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 2);
		dataCountMap.put(1, 1);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		result.put(typeKey+"", resultList);
		return result;
	}
}
