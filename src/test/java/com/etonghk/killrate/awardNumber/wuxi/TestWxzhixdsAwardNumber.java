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
 * 	五星_直选单式 wxzhixds
 * @author Peter.Hong
 * @date 2019年1月19日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzhixdsAwardNumber {
	
	@Autowired
	private KillRateBetSender killRateBetSender;
	
	GameLotteryOrder order = new GameLotteryOrder();
	
	@Before
	public void beforeTest() {
		order.setContent("00001");
		order.setMethod("wxzhixds");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
	@Test
	public void testWxzhixfsAwardNumber() {
		killRateBetSender.senderGameLotteryOrder(order);
	}
}
