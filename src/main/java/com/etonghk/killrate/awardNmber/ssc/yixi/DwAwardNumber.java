package com.etonghk.killrate.awardNmber.ssc.yixi;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 定位膽
 * @author Peter
 *
 */
@AwardComponent(name= {"dw"})
public class DwAwardNumber implements AwardNumber {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] rows = betOrder.getBetItem().split(BetLineSplit, -1);
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < rows.length; i++) {
			if (!StringUtils.isEmpty(rows[i])) {
				String[] cols = rows[i].split(BetItemSplit);
				for (String c : cols) {
					AwardNumberGenerateUtils.addPreAndAfter(c, i, 4 - i, resultList);
				}
			}
		}
		return resultList;
	}

}
