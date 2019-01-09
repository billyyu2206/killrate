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
@AwardComponent(name={"exzhixdsh,exzhixdsq"})
public class ExzhixdsAwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 3, 0);
		return resultList;
	}

}