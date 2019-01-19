package com.etonghk.killrate.awardNumber.sixi;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.jack.entity.GameLotteryOrder;

/**
 * 	四星組合
 * @author Billy
 *
 */
public class TestSixzhixzhAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	GameLotteryOrder order = new GameLotteryOrder();
	
	@Test
	public void testSixzhixzhAwardNumber() {
		
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(order.getMethod());
		Map<String, List<String>> numberResult = awardNumber.getAwardNumberWithType(order);
		for(Map.Entry<String, List<String>> entry : numberResult.entrySet()) {
			System.out.println("TYPE: " + entry.getKey() + "  SIZE: " + entry.getValue().size());
		}
	}
	
}

