package com.etonghk.killrate.awardNmber.ssc.erxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.config.SSCConfig;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
/**
 * 二星跨度
 * @author Peter
 *
 */
@AwardComponent(name= {"kdqe","kdhe"})
public class ErxiKdAwardNumber extends ErxiBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		String[] cols = order.getContent().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		int[] pos = getErxiKdPos(order.getMethod());
		for (String c : cols) {
			Map<String, String> ssc2Kuadu = SSCConfig.SSC2KuaDu;
			String awardNumber = ssc2Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
			resultList.addAll(tempList);
		}
		result.put("1", resultList);
		return result;
	}
}
