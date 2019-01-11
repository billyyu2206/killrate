package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 三星直选单式
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixdsh","sxzhixdsz","sxzhixdsq"})
public class SxzhixdAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		// FIXME 投注內容需重新確認
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]); 
		return resultList;
	}

}
