package com.etonghk.killrate.awardNmber.ssc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 五星_组选20
 * @author Ami
 *
 */
@Component("wxzux20")
public class Wxzux20AwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(3, StringUtils.join(rows[0].split(BetItemSplit), ","));
		betDataMap.put(1, StringUtils.join(rows[1].split(BetItemSplit), ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(3, 1);
		dataCountMap.put(1, 2);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}

}
