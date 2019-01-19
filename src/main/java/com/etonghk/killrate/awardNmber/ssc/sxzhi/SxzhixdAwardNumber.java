package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;
/**
 * 三星直选单式
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixdsh","sxzhixdsz","sxzhixdsq"})
public class SxzhixdAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		// FIXME 投注內容需重新確認
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] items = order.getContent().split(BetZhSplit);
		int[] sxzhi = getSxzhiPos(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]); 
		result.put(typeKey+"", resultList);
		return result;
	}
}
