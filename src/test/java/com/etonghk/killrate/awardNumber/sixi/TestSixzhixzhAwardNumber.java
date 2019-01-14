package com.etonghk.killrate.awardNumber.sixi;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 	四星組合
 * @author Billy
 *
 */
public class TestSixzhixzhAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	BetRecordBean betOrder = new BetRecordBean();
	
	@Test
	public void testSixzhixzhAwardNumber() {
		
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(betOrder.getGamePlayId());
		Map<String, List<String>> numberResult = awardNumber.getAwardNumberOfType(betOrder);
		for(Map.Entry<String, List<String>> entry : numberResult.entrySet()) {
			System.out.println("TYPE: " + entry.getKey() + "  SIZE: " + entry.getValue().size());
		}
	}
	
}

