package com.etonghk.killrate.awardNmber.ssc.sxzhi;

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
 * 三星组三
 * @author Peter
 *
 */
@AwardComponent(name={"sxzuxzsh","sxzuxzsz","sxzuxzsq"})
public class SxzuxzAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(items, ","));
		betDataMap.put(1, StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 1);
		dataCountMap.put(1, 1);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]); // 後三
		
		result.put(typeKey+"", resultList);
		return result;
	}
	
	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}