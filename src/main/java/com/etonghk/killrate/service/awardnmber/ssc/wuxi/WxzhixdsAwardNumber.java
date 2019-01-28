package com.etonghk.killrate.service.awardnmber.ssc.wuxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.service.awardnmber.AwardNumber;
import com.etonghk.killrate.service.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.service.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 五星_直选单式
 * @author Ami
 *
 */
@AwardComponent(name={"wxzhixds"})
public class WxzhixdsAwardNumber implements AwardNumber{

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] items = order.getContent().split(BetDsSplit);
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, 0, 0);
		
		result.put(typeKey+"", resultList);
		return result;
	}
}
