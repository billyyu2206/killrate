package com.etonghk.killrate.awardnmber.ssc.lh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;
/**
 * 龍虎鬥
 * @author Peter
 *
 */
@AwardComponent(name={"lhwq","lhwb","lhwg","lhws","lhqb","lhqg","lhqs","lhbs","lhbg","lhsg"})
public class LhAwardNumber extends LhBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] rows = order.getContent().split(BetLongHuSplit);
		List<String> resultList = new ArrayList<String>();
		
		int[] lhPos = getLhPos(order.getMethod());
		for(String betItems : rows) {
			resultList = AwardNumberGenerateUtils.getLongHuDou(betItems, lhPos[0], lhPos[1]);
			result.put(lhTypeMap.get(betItems), resultList);
		}
		
		return result;
	}
}
