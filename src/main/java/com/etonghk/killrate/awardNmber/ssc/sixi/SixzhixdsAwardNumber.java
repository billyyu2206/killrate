package com.etonghk.killrate.awardNmber.ssc.sixi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后四星_直选单式
 * 前四星_直选单式
 * @author Ami
 *
 */
@AwardComponent(name={"sixzhixdsh,sixzhixdsq"})
public class SixzhixdsAwardNumber extends SixiBase implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int[] pos = getSixiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
		return resultList;
	}

}