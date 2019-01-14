package com.etonghk.killrate.awardNumber.rx;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 *	 任选_任X直选复式
 * 	 玩法  "rx2fs","rx3fs","rx4fs"
 * 	 @author Peter
 *	
 */
public class TestRxfsAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;

	BetRecordBean betOrder = new BetRecordBean();
	
	
	@Test
	public void testRxfsAwardNumber() {

		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(betOrder.getGamePlayId());
		Map<String,List<String>> result = awardNumber.getAwardNumberWithType(betOrder);
		System.out.println(result.get("1"));
		System.out.println(result.get("1").size());
	}
	
	@Test
	public void getCalcAwardMoney() {
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(betOrder.getGamePlayId());
		Map<String,List<String>> typeByAwardNumber = awardNumber.getAwardNumberWithType(betOrder);
		Map<String,BigDecimal> result = awardNumber.getCalcAwardMoney(betOrder, typeByAwardNumber);
		System.out.println(result);
		System.out.println(result.size());
	}

}
