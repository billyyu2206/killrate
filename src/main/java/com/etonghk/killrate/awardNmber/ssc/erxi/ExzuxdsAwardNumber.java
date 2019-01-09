package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.ssc.SSCAwardUtils;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后二星_组选单式-h
 * 前二星_组选单式-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzuxdsh,exzuxdsq"})
public class ExzuxdsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = SSCAwardUtils.arrayToList(items);
		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation(resultList.get(i), 0, resultList.get(i).length(), "", resultList);
		}
		int[] pos = getErxiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
		return resultList;
	}
}