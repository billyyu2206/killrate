package com.etonghk.killrate.awardNmber.ssc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 五星_直选复式
 * @author Ami
 *
 */
@Component("wxzhixfs")
public class WxzhixfsAwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[][] rowcols = new String[5][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);

		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 0, 0);
		return resultList;
	}

}
