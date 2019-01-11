package com.etonghk.killrate.awardNumber.erxi;

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
 * 后二星_组选复式-h
 * 前二星_组选复式-q
 * @author Peter
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExzuxfsAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Test
	public void testExzuxfsAwardNumber() {
		// "exzuxfsh","exzuxfsq"
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("12");
		betOrder.setGamePlayId("exzuxfsq");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("exzuxfsq");
		List<String> result = awardNumber.getAwardNumber(betOrder);
		System.out.println(result);
		System.out.println(result.size());
	}
	
}
