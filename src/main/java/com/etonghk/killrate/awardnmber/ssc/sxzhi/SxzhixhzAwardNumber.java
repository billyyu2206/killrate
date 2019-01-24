package com.etonghk.killrate.awardnmber.ssc.sxzhi;

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
 * 三星直選和值
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixhzh","sxzhixhzz","sxzhixhzq"})
public class SxzhixhzAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] cols = order.getContent().split(BetHgSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			int[] sxzhi = getSxzhiPos(order.getMethod());
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]); // 前三
			resultList.addAll(tempList);
		}
		result.put(typeKey+"", resultList);
		return result;
	}
}
