package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 五星x碼不定位
 * @author Peter
 *
 */
@AwardComponent(name= {"wxbdw1m","wxbdw2m","wxbdw3m"})
public class WuxiBdw extends WuxiBase implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int bdwNum = getBdwNum(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, bdwNum, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		return resultList;
	}
}
