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
 * 二星跨度
 * @author Peter
 *
 */
@AwardComponent(name= {"kdqe","kdhe"})
public class ErxiKdAwardNumber extends ErxiBase implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		int[] pos = getErxiKdPos(betOrder.getGamePlayId());
		for (String c : cols) {
			Map<String, String> ssc2Kuadu = SSCConfig.SSC2KuaDu;
			String awardNumber = ssc2Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, pos[0], pos[1]);
			resultList.addAll(tempList);
		}
		return resultList;
	}

}
