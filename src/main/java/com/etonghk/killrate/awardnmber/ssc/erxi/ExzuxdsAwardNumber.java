package com.etonghk.killrate.awardnmber.ssc.erxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.ssc.SSCAwardUtils;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后二星_组选单式-h
 * 前二星_组选单式-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzuxdsh","exzuxdsq"})
public class ExzuxdsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] items = order.getContent().split(BetDsSplit);
		List<String> resultList = SSCAwardUtils.arrayToList(items);
		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation(resultList.get(i), 0, resultList.get(i).length(), "", resultList);
		}
		int[] pos = getErxiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}
}