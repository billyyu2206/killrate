package com.etonghk.killrate.awardNmber.ssc.rx;

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
 * 	任选_组选   任三組六
 * @author Billy
 *
 */
@AwardComponent(name={"rx2zx","rx3z6"})
public class RxzxAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int rxNum = getRxNum(betOrder.getGamePlayId());
		
		String[] betDatas = betOrder.getBetItem().split("]");
		String[] numsData = betDatas[1].split(BetItemSplit);
		String[] pos = getBetPos(betOrder.getBetItem());
		
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(1, StringUtils.join(numsData, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(1, rxNum);
		
		List<String[]> betPermutations = AwardNumberGenerateUtils.getTzuShiuanNumberForRenXuan(betDataMap, dataCountMap, rxNum);
		
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanTzuShiuanResult(pos, rxNum, 5, betPermutations);
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
