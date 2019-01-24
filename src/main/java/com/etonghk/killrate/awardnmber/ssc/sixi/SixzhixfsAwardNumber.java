package com.etonghk.killrate.awardnmber.ssc.sixi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后四星_直选复式
 * 前四星_直选复式
 * @author Ami
 *
 */
@AwardComponent(name={"sixzhixfsh","sixzhixfsq"})
public class SixzhixfsAwardNumber extends SixiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[][] rowcols = getBetItemsRows(order);
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		int[] pos = getSixiPos(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}
}