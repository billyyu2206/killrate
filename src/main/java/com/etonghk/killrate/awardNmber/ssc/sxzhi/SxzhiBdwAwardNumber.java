package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 三星不定位
 * @author Peter
 *
 */
@AwardComponent(name={"bdw1mh","bdw1mz","bdw1mq","bdw2mh","bdw2mz","bdw2mq"})
public class SxzhiBdwAwardNumber extends SxzhiBase implements AwardNumber{
	
	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		
		int bdwNum = getBdwNum(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, bdwNum, 3);

		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]);
		
		result.put(typeKey+"", resultList);
		return result;
	}
	
	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
