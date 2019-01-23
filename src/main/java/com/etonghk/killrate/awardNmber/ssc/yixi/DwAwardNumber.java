package com.etonghk.killrate.awardNmber.ssc.yixi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;
/**
 * 	定位膽 dw
 * @author Peter
 *
 */
@AwardComponent(name= {"dw"})
public class DwAwardNumber implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] rows = order.getContent().split(BetLineSplit, -1);
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < rows.length; i++) {
			if (!StringUtils.isEmpty(rows[i]) && !BetNoPickItem.equals(rows[i])) {
				String[] cols = rows[i].split(BetItemSplit);
				for (String c : cols) {
					AwardNumberGenerateUtils.addPreAndAfter(c, i, 4 - i, resultList);
				}
			}
		}
		result.put(typeKey+"", resultList);
		return result;
	}
}
