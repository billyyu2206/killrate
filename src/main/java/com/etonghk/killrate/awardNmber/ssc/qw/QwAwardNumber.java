package com.etonghk.killrate.awardNmber.ssc.qw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;
/**
 * 趣味  一帆风顺qwyffs 好事成双qwhscs 三星报喜qwsxbx 四季发财qwsjfc
 * @author Peter
 *
 */
@AwardComponent(name={"qwyffs","qwhscs","qwsxbx","qwsjfc"})
public class QwAwardNumber extends QwBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] cols = order.getContent().split(BetItemSplit);
		int methodNumber = getQwNumber(order.getMethod());
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, methodNumber, 5);
		
		result.put("1", resultList);
		return result;
	}
}
