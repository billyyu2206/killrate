package com.etonghk.killrate.awardnmber.ssc.rx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 任選複式
 * 
 * @author Peter
 *
 */
@AwardComponent(name = { "rx2fs", "rx3fs", "rx4fs" })
public class RxfsAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<>();
		String[][] rowcols = new String[5][];
		String[] rows = order.getContent().split(BetLineSplit, -1);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		int rxNum = getRxNum(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanZhiXuan(rowcols, rxNum); // rxNum 任幾位數
		result.put("1", resultList);

		return result;

	}
}
