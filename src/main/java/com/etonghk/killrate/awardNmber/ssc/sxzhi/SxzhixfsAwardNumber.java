package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;
/**
 *  三星 直选复式
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixfsh","sxzhixfsz","sxzhixfsq"})
public class SxzhixfsAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[][] rowcols = new String[3][];
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
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		int[] sxzhi = getSxzhiPos(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, sxzhi[0], sxzhi[1]);
		result.put(typeKey+"", resultList);
		return result;
	}
}
