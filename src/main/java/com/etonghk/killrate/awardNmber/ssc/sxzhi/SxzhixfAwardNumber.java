package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.ArrayList;
import java.util.List;

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
public class SxzhixfAwardNumber extends Sxzhi implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[][] rowcols = new String[3][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, sxzhi[0], sxzhi[1]);
		return resultList;
	}

}
