package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 五星_直选单式
 * @author Ami
 *
 */
@AwardComponent(name={"wxzhixds"})
public class WxzhixdsAwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 0);
		return resultList;
	}

}
