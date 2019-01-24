package com.etonghk.killrate.awardNumber.rx;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	任选_任二直选单式 rx2ds
 * @author Peter.Hong
 * @date 2019年1月21日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRx2dsAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("[√,√,-,-,-]00");
		order.setMethod("rx2ds");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
