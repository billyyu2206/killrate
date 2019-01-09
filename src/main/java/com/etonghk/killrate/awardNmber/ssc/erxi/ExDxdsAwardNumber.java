package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后二星_大小单双-h
 * 前二星_大小单双-q
 * @author Ami
 *
 */
@AwardComponent(name={"dxdsh,dxdsq"})
public class ExDxdsAwardNumber implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[][] rowcols = new String[2][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> resultList = AwardNumberGenerateUtils.getDaShiauDanShuang(rowcols);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 3, 0);
		return resultList;
	}

}