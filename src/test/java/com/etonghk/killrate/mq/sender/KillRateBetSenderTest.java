package com.etonghk.killrate.mq.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jack.entity.GameLotteryOrder;

/**
 * @author Ami.Tsai
 * @date 2019年1月18日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class KillRateBetSenderTest {

	@Autowired
	private KillRateBetSender killRateBetSender;
	
	@Test
	public void testSenderGameLotteryOrder() {
		GameLotteryOrder order = new GameLotteryOrder();
		order.setAccountId(123);
		order.setLottery("vipssc");
		killRateBetSender.senderGameLotteryOrder(order);
	}
	
}
