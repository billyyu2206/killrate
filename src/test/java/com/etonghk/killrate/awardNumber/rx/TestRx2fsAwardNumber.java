package com.etonghk.killrate.awardNumber.rx;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRx2fsAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("0,2,-,-,-");
		order.setMethod("rx2fs");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
}