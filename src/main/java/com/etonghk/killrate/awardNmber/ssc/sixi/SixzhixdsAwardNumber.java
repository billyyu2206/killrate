package com.etonghk.killrate.awardNmber.ssc.sixi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * 后四星_直选单式
 * 前四星_直选单式
 * @author Ami
 *
 */
@AwardComponent(name={"sixzhixdsh","sixzhixdsq"})
public class SixzhixdsAwardNumber extends SixiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] items = order.getContent().split(BetItemSplit);
		int[] pos = getSixiPos(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}
}