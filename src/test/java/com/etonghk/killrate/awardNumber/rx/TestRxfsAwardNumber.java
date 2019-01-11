package com.etonghk.killrate.awardNumber.rx;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 任选_任X直选复式
 * @author Peter
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRxfsAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	// rx2fs rx3fs rx4fs
	@Test
	public void testRxfsAwardNumber() {
		// "sxzhixdsh","sxzhixdsz","sxzhixdsq"
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("1,2,-,9,-");
		
		betOrder.setGamePlayId("rx3fs");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("rx3fs");
		List<String> result = awardNumber.getAwardNumber(betOrder);
		System.out.println(result);
		System.out.println(result.size());
	}

}
