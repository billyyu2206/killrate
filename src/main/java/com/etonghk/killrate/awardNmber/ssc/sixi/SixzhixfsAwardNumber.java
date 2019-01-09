package com.etonghk.killrate.awardNmber.ssc.sixi;

import java.util.ArrayList;
import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后四星_直选复式
 * 前四星_直选复式
 * @author Ami
 *
 */
@AwardComponent(name={"sixzhixfsh,sixzhixfsq"})
public class SixzhixfsAwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[][] rowcols = new String[4][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		//FIXME 須根據前四 或後四 針對
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 1, 0);
		return resultList;
	}

}