package com.etonghk.killrate.awardNumber.sixi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSixzhixzhhAwardNumber extends TestSixzhixzhAwardNumber{

	@Before
	public void beforeTest() {
		betOrder.setBetItem("-,0,0,0,0");
		betOrder.setGamePlayId("sixzhixzhh");
	}
	
}