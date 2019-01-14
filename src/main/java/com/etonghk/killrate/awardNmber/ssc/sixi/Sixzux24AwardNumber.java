package com.etonghk.killrate.awardNmber.ssc.sixi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后四星_组选24
 * 前四星_组选24
 * @author Ami
 *
 */
@AwardComponent(name={"sixzux24h","sixzux24q"})
public class Sixzux24AwardNumber extends SixiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] rows = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(rows, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, 4);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 4);
		int[] pos = getSixiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, pos[0], pos[1]);
		
		result.put("1", resultList);
		return result;
	}

	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}