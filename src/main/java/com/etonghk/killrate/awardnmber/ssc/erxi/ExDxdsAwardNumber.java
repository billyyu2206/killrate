package com.etonghk.killrate.awardnmber.ssc.erxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后二星_大小单双-h
 * 前二星_大小单双-q
 * @author Ami
 *
 */
@AwardComponent(name={"dxdsh","dxdsq"})
public class ExDxdsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[][] rowcols = new String[2][];
		String[] rows = order.getContent().split(BetLineSplit);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(BetItemSplit);
		}
		List<String> resultList = AwardNumberGenerateUtils.getDaShiauDanShuang(rowcols);
		
		int[] pos = getErxiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}
}