package com.etonghk.killrate.awardNmber;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 計算中獎金額
 * @author Peter
 *
 */
public interface CalcAwardMoney {

	/**
	 * @param playId
	 * @param TypeByAwardNumber key:AwardNumber value:AwardMoney
	 * @return
	 */
	public Map<String,BigDecimal> calcAwardMoney(BetRecordBean betOrder,Map<String,List<String>> TypeByAwardNumber);

}
