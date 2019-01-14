package com.etonghk.killrate.awardNumber.rx;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRx2fsAwardNumber extends TestRxfsAwardNumber{

	@Before
	public void beforeTest() {
		betOrder.setBetItem("0,2,-,-,-");
		betOrder.setGamePlayId("rx2fs");
	}
	
}