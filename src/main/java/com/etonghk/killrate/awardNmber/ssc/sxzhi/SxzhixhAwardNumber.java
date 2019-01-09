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
 * 三星直選和值
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixhzh","sxzhixhzz","sxzhixhzq"})
public class SxzhixhAwardNumber extends Sxzhi implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] cols = betOrder.getBetItem().split(BetItemSplit);
		List<String> resultList = new ArrayList<String>();
		for (String c : cols) {
			Map<String, String> ssc3HG = SSCConfig.SSC3HG;
			String awardNumber = ssc3HG.get(c);
			String[] items = awardNumber.split(",");
			int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
			List<String> tempList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]); // 前三
			resultList.addAll(tempList);
		}
		return resultList;
	}

}
