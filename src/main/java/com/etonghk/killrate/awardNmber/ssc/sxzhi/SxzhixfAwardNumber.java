package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 *  三星 直选复式
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixfsh","sxzhixfsz","sxzhixfsq"})
public class SxzhixfAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, sxzhi[0], sxzhi[1]);
		result.put(typeKey+"", resultList);
		return result;
	}
	
	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
