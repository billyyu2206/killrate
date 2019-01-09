package com.etonghk.killrate.awardNmber.ssc.qw;

import java.util.List;

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
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		int methodNumber = getQwNumber(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getChiuWei(cols, methodNumber, 5);
		return resultList;
	}

}
