package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.util.ArrayList;
import java.util.List;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.utils.CommonUtils;
import com.etonghk.killrate.vo.BetRecordBean;

public class WxhzdxdsAwardNumber implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
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
		return resultList;
	}

}
