package com.etonghk.killrate.awardNmber.ssc.qw;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 趣味  一帆风顺qwyffs 好事成双qwhscs 三星报喜qwsxbx 四季发财qwsjfc
 * @author Peter
 *
 */
@AwardComponent(name={"qwyffs","qwhscs","qwsxbx","qwsjfc"})
public class QwAwardNumber extends QwBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		int methodNumber = getQwNumber(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, methodNumber, 5);
		
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
