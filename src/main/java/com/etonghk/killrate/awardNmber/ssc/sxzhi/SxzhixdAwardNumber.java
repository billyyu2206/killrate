package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 三星直选单式
 * @author Peter
 *
 */
@AwardComponent(name={"sxzhixdsh","sxzhixdsz","sxzhixdsq"})
public class SxzhixdAwardNumber extends SxzhiBase implements AwardNumber {

	@Override
	public Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		// FIXME 投注內容需重新確認
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		int typeKey = TypeStartIndex;
		String[] items = betOrder.getBetItem().split(BetZhSplit);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		List<String> resultList = AwardNumberGenerateUtils.getCompleteAwardList(items, sxzhi[0], sxzhi[1]); 
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
