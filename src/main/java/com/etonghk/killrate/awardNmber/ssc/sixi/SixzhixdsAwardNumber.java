package com.etonghk.killrate.awardNmber.ssc.sixi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后四星_直选单式
 * 前四星_直选单式
 * @author Ami
 *
 */
@AwardComponent(name={"sixzhixdsh","sixzhixdsq"})
public class SixzhixdsAwardNumber extends SixiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int[] pos = getSixiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
		result.put("1", resultList);
		return result;
	}

	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}