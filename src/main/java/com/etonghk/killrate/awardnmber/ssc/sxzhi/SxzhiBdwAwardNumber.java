package com.etonghk.killrate.awardnmber.ssc.sxzhi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 三星不定位
 * @author Peter
 *
 */
@AwardComponent(name={"bdw1mh","bdw1mz","bdw1mq","bdw2mh","bdw2mz","bdw2mq"})
public class SxzhiBdwAwardNumber extends SxzhiBase implements AwardNumber{
	
	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		
		String[] items = order.getContent().split(BetBdwSplit);
		
		int bdwNum = getBdwNum(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, bdwNum, 3);

		int[] sxzhi = getSxzhiPos(order.getMethod());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]);
		
		result.put(typeKey+"", resultList);
		return result;
	}
}
