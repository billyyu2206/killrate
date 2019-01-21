package com.etonghk.killrate.awardNumber.rx;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	任选_任三混合
 * @author Peter.Hong
 * @date 2019年1月21日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRxhhAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("[√,√,√,-,-]033");
		order.setMethod("rx3hh");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
