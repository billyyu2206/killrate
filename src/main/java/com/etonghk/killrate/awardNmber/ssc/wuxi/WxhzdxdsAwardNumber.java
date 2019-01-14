package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.utils.CommonUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 五星和值大小單雙
 * @author Peter
 *
 */
@AwardComponent(name= {"wxhzdxds"})
public class WxhzdxdsAwardNumber implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
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
	
	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
