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
		order.setContent("0,2,-,-,-");
		order.setMethod("rx2fs");
	}
	
}