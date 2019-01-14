package com.etonghk.killrate.awardNmber.ssc.wuxi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 五星x碼不定位
 * @author Peter
 *
 */
@AwardComponent(name= {"wxbdw1m","wxbdw2m","wxbdw3m"})
public class WuxiBdw extends WuxiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder){
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		int bdwNum = getBdwNum(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getBuDingWeiPermutation(items, bdwNum, 5);
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, 0, 0);
		
		result.put(typeKey+"", resultList);
		return result;
	}
	
	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
