package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后二星_直选复式-h
 * 前二星_直选复式-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzhixdsh","exzhixdsq"})
public class ExzhixdsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int[] pos = getErxiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
		return resultList;
	}

}