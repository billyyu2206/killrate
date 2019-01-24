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
 * 三星跨度
 * @author Peter
 *
 */
@AwardComponent(name={"kdqs","kdzs","kdhs"})
public class SxzhiKdAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] cols = order.getContent().split(BetKdSplit);
		List<String> resultList = new ArrayList<String>();
		int[] sxzhi = getSxzhiPos(order.getMethod());
		
		for (String c : cols) {
			Map<String, String> ssc3Kuadu = SSCConfig.SSC3KuaDu;
			String awardNumber = ssc3Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]);
			resultList.addAll(tempList);
		}
		result.put(typeKey+"", resultList);
		return result;
	}
}
