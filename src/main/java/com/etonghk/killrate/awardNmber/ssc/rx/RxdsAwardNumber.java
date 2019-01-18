package com.etonghk.killrate.awardNmber.ssc.rx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * 	任選單式
 * @author Billy
 *
 */
@AwardComponent(name={"rx2ds","rx3ds","rx4ds"})
public class RxdsAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int rxNum = getRxNum(order.getMethod());
		
		String[] betDatas = order.getContent().split("]");
		String[] numsData = betDatas[1].split(BetLineSplit);
		String[] pos = getBetPos(order.getContent());

		List<String[]> betPermutations = new ArrayList<String[]>();
		for (int i = 0; i < numsData.length; i++) {
			betPermutations.add(numsData[i].split(""));
		}
		
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanTzuShiuanResult(pos, rxNum, 5, betPermutations);
		result.put("1", resultList);
		return result;
	}
}
