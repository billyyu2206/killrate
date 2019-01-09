package com.etonghk.killrate.awardNmber.ssc.lh;

import java.util.ArrayList;
import java.util.List;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.ssc.SSCAwardUtils;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 龍虎鬥
 * @author Peter
 *
 */
@AwardComponent(name={"lhwq","lhwb","lhwg","lhws","lhqb","lhqg","lhqs","lhbs","lhbg","lhsg"})
public class LhAwardNumber implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit);
		List<String> resultList = new ArrayList<String>();
		
		int[] lhPos = SSCAwardUtils.getLhPos(betOrder.getGamePlayId());
		for(String betItems : rows) {
			List<String> tempList = AwardNumberGenerateUtils.getLongHuDou(betItems, lhPos[0], lhPos[1]);
			resultList.addAll(tempList);
		}
		return resultList;
	}

}
