package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 五星_组选5
 * @author Ami
 *
 */
@AwardComponent(name={"wxzux5"})
public class Wxzux5AwardNumber implements AwardNumber{

	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(4, StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(1, StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(4, 1);
		dataCountMap.put(1, 1);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		result.put(typeKey+"", resultList);
		return result;
	}
}
