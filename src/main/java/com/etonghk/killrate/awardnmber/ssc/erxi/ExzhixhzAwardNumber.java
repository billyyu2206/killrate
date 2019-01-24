package com.etonghk.killrate.awardnmber.ssc.erxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 后二星_直选和值-h
 * 前二星_直选和值-q
 * @author Ami
 *
 */
@AwardComponent(name={"exzhixhzh","exzhixhzq"})
public class ExzhixhzAwardNumber extends ErxiBase implements AwardNumber{

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] cols = order.getContent().split(BetHgSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc2HG = SSCConfig.SSC2HG;
			String awardNumber = ssc2HG.get(c);
			String[] items = awardNumber.split(",");
			
			int[] pos = getErxiPos(order.getMethod());
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
			resultList.addAll(tempList);
		}
		result.put("1", resultList);
		return result;
	}
}
