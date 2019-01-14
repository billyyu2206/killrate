package com.etonghk.killrate.awardNumber.wuxi;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 五星組合
 * @author Ami
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzhixzhAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Test
	public void testWxzhixzhAwardNumber() {
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("01,01,0,0,0");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("wxzhixzh");
		Map<String, List<String>> numberResult = awardNumber.getAwardNumberOfType(betOrder);
		for(Map.Entry<String, List<String>> entry : numberResult.entrySet()) {
			System.out.println("TYPE: " + entry.getKey() + "  SIZE: " + entry.getValue().size());
		}
	}
	
}
