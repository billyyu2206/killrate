package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 三星跨度
 * @author Peter
 *
 */
@AwardComponent(name={"kdqs","kdzs","kdhs"})
public class SxzhiKdAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		
		for (String c : cols) {
			Map<String, String> ssc3Kuadu = SSCConfig.SSC3KuaDu;
			String awardNumber = ssc3Kuadu.get(c);
			String[] items = awardNumber.split(",");
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]);
			resultList.addAll(tempList);
		}
		return resultList;
	}

}
