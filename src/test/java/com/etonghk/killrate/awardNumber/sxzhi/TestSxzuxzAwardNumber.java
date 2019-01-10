package com.etonghk.killrate.awardNumber.sxzhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 三星組三
 * @author Peter
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSxzuxzAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Test
	public void testWxzhixzhAwardNumber() {
		// "後 sxzuxzsh","中sxzuxzsz","前sxzuxzsq"
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("123");
		betOrder.setGamePlayId("sxzuxzsh");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("sxzuxzsh");
		System.out.println(awardNumber.getAwardNumber(betOrder));
		
	}
	
}
