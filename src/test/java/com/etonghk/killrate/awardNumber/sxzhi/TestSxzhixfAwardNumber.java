package com.etonghk.killrate.awardNumber.sxzhi;

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
 * 三星直選複式
 * @author Peter
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSxzhixfAwardNumber {

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Test
	public void testWxzhixzhAwardNumber() {
		// "sxzhixfsh","sxzhixfsz","sxzhixfsq"
		// "'-,56789,01234,13579,-'"
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("12,3,2");
		
		betOrder.setGamePlayId("sxzhixfsh");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("sxzhixfsh");
		List<String> result = awardNumber.getAwardNumber(betOrder);
		System.out.println(result);
		System.out.println(result.size());
	}
}
