package com.etonghk.killrate.awardNumber.wuxi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzhixzhAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Test
	public void testWxzhixzhAwardNumber() {
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("123,012,172,1,20");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("wxzhixzh");
		awardNumber.getAwardNumber(betOrder);
		
	}
	
}
