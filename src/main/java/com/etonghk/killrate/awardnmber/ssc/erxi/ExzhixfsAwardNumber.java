package com.etonghk.killrate.awardnmber.ssc.erxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后二星_直选复式-h
 * 前二星_直选复式-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzhixfsh","exzhixfsq"})
public class ExzhixfsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[][] rowcols = new String[2][];
		String[] rows = order.getContent().split(BetLineSplit);
		int setIndex = 0;
		for (int i = 0; i < rows.length; i++) {
			if(BetNoPickItem.equals(rows[i])) {
				continue;
			}else {
				rowcols[setIndex] = rows[i].split(BetItemSplit);
				setIndex++;
			}
			
		}
		int[] pos = getErxiPos(order.getMethod());
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}

}