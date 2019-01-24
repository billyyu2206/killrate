package com.etonghk.killrate.awardnmber.ssc.wuxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.utils.CommonUtils;
import com.jack.entity.GameLotteryOrder;
/**
 * 五星和值大小單雙
 * @author Peter
 *
 */
@AwardComponent(name= {"wxhzdxds"})
public class WxhzdxdsAwardNumber implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] rows = order.getContent().split(BetHgdxdsSplit);
		List<String> resultList = new ArrayList<String>();
		for(String betItem : rows) {
			List<Integer[]> numsCombineList = SSCConfig.SSC5HG.get(betItem);
			List<String> tempList = null;
			for(Integer[] nums : numsCombineList) {
				String[] numsString = CommonUtils.arrayToStringArray(nums);
				tempList = AwardNumberGenerateUtils.getCombinationPermutation(numsString);
				resultList.addAll(tempList);
			}
		}
		result.put(typeKey+"", resultList);
		return result;
	}
}
