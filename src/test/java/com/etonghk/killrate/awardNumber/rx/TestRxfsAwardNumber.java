package com.etonghk.killrate.awardNumber.rx;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.awardNmber.ssc.rx.RxfsAwardNumber;
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

//		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("rx3fs");
		AwardNumber awardNumber = new RxfsAwardNumber();
		Map<String,List<String>> result = awardNumber.getAwardNumberOfType(betOrder);
		System.out.println(result.get("1"));
		System.out.println(result.size());
	}
	
	private Map<String,List<String>> getAwardNumber(AwardNumber awardNumber,BetRecordBean betOrder){
		betOrder.setGamePlayId("rx2fs");
//		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("rx3fs");
		awardNumber = new RxfsAwardNumber();
		Map<String,List<String>> result = awardNumber.getAwardNumberOfType(betOrder);
		return result;
	}
		
	@Test
	public void getCalcAwardMoney() {
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("0,2,-,-,-");
		betOrder.setGamePlayId("rx2fs");
		AwardNumber awardNumber = new RxfsAwardNumber();
		Map<String,List<String>> typeByAwardNumber = getAwardNumber(awardNumber, betOrder);
		Map<String,BigDecimal> result = awardNumber.getCalcAwardMoney(betOrder, typeByAwardNumber);
		System.out.println(result);
	}

}
