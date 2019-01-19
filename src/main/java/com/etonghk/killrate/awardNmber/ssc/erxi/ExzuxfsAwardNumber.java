package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后二星_组选复式-h
 * 前二星_组选复式-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzuxfsh","exzuxfsq"})
public class ExzuxfsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] rows = order.getContent().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, 2);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		int[] pos = getErxiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}
}