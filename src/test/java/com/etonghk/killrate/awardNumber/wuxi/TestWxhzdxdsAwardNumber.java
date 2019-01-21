/**
 * 
 */
package com.etonghk.killrate.awardNumber.wuxi;

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
import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.jack.entity.GameLotteryOrder;

/**
 * 	五星_和值大小单双 wxhzdxds
 * @author Peter.Hong
 * @date 2019年1月21日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxhzdxdsAwardNumber {

	@Autowired
	private KillRateBetSender killRateBetSender;
	
	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	private GameLotteryOrder order = new GameLotteryOrder();
	
	@Before
	public void beforeTest() {
		order.setContent("大");
		order.setMethod("wxhzdxds");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
	@Test
	public void testWuxiBdw() {
		killRateBetSender.senderGameLotteryOrder(order);
	}
	
	@Test
	public void testSixzhixzhAwardNumber() {
		
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(order.getMethod());
		Map<String, List<String>> numberResult = awardNumber.getAwardNumberWithType(order);
		for(Map.Entry<String, List<String>> entry : numberResult.entrySet()) {
			System.out.println("TYPE: " + entry.getKey() + "  SIZE: " + entry.getValue().size());
		}
	}
}
