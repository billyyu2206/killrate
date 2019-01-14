package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后二星_直选复式-h
 * 前二星_直选复式-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzhixdsh","exzhixdsq"})
public class ExzhixdsAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int[] pos = getErxiPos(betOrder.getGamePlayId());
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