package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.List;

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
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		
		int bdwNum = getBdwNum(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, bdwNum, 3);

		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]);
		
		return resultList;
	}
}
