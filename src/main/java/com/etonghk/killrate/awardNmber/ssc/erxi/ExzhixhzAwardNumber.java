package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 后二星_直选和值-h
 * 前二星_直选和值-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzhixhzh","exzhixhzq"})
public class ExzhixhzAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2HG = SSCConfig.SSC2HG;
			String awardNumber = ssc2HG.get(c);
			String[] items = awardNumber.split(",");
			
			int[] pos = getErxiPos(betOrder.getGamePlayId());
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
			resultList.addAll(tempList);
		}
		return resultList;
	}

}
