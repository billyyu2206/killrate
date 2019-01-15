package com.etonghk.killrate.awardNmber.ssc.rx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 任選複式
 * 
 * @author Peter
 *
 */
@AwardComponent(name = { "rx2fs", "rx3fs", "rx4fs" })
public class RxfsAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<>();
		String[][] rowcols = new String[5][];
		String[] rows = betOrder.getBetItem().split(BetLineSplit, -1);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		int rxNum = getRxNum(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanZhiXuan(rowcols, rxNum); // rxNum 任幾位數
		result.put("1", resultList);

		return result;

	}
}
