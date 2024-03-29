package com.etonghk.killrate.service.awardnmber.ssc.wuxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.service.awardnmber.AwardNumber;
import com.etonghk.killrate.service.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.service.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 五星_组选120
 * @author Ami
 *
 */
@AwardComponent(name={"wxzux120"})
public class Wxzux120AwardNumber implements AwardNumber{

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] rows = order.getContent().split(BetZxSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, 5);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		result.put(typeKey+"", resultList);
		return result;
	}
}
