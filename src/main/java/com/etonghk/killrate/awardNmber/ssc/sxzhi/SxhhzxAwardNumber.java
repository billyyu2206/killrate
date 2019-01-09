package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.ArrayList;
import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 三星混合组选
 * @author Peter
 *
 */
@AwardComponent(name={"sxhhzxh","sxhhzxz","sxhhzxq"})
public class SxhhzxAwardNumber extends Sxzhi implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = arrayToList(items);

		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation(resultList.get(i), 0, resultList.get(i).length(), "",
					resultList);
		}
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]);
		return resultList;
	}
	
	private static List<String> arrayToList(String[] array) {
		List<String> result = new ArrayList<String>();
		for (String item : array) {
			result.add(item);
		}
		return result;
	}

}
