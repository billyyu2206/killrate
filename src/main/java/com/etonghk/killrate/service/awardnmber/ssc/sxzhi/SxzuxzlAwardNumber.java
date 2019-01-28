package com.etonghk.killrate.service.awardnmber.ssc.sxzhi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.service.awardnmber.AwardNumber;
import com.etonghk.killrate.service.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.service.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 三星组六
 * @author Peter
 *
 */
@AwardComponent(name={"sxzuxzlh","sxzuxzlz","sxzuxzlq"})
public class SxzuxzlAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] items = order.getContent().split(BetZxSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, 3);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		int[] sxzhi = getSxzhiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]); // 後三
		result.put(typeKey+"", resultList);
		return result;
	}
}
