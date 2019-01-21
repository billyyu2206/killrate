/**
 * 
 */
package com.etonghk.killrate.awardNumber.wuxi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.jack.entity.GameLotteryOrder;

/**
 * 	五星_组选5 wxzux5
 * @author Peter.Hong
 * @date 2019年1月21日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzux5AwardNumber {
	@Autowired
	private KillRateBetSender killRateBetSender;
	
	private GameLotteryOrder order = new GameLotteryOrder();
	
	@Before
	public void beforeTest() {
		order.setContent("0,12");
		order.setMethod("wxzux5");
		order.setLottery("vipssc");
		order.setMultiple(1);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
	@Test
	public void testWxzhixfsAwardNumber() {
		killRateBetSender.senderGameLotteryOrder(order);
	}

}
