package com.etonghk.killrate.mq.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.vo.ClearKillRateVo;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClearKillRateSenderTest {

	@Autowired
	private ClearKillRateSender clearKillRateSender;
	
	@Test
	public void clearKillRate() throws InterruptedException {
		ClearKillRateVo vo = new ClearKillRateVo();
		vo.setIssue("201901191002");
		vo.setLottery("t1s30");
		clearKillRateSender.sendClearLotteryIssue(vo);
	}
	
}
