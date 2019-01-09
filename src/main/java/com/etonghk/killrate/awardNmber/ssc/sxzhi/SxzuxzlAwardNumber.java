package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 三星组六
 * @author Peter
 *
 */
@AwardComponent(name={"sxzuxzlh","sxzuxzlz","sxzuxzlq"})
public class SxzuxzlAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, 3);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 3);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]); // 後三
		return resultList;
	}

}
