package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.util.ArrayList;
import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 五星直選組合
 * @author user
 *
 */
@AwardComponent(name= {"wxzhixzh"})
public class WxzhixzhAwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		
		String[][] rowcols = new String[5][];
		//取得五星號碼[0123,122,233,321,311]
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> itemlist = new ArrayList<String>();
		//計算五星號碼
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, 0, 0);
		
		
		
		//計算四星號碼
		
		
		
		
		
		return resultList;
		
	}

}