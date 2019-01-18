package com.etonghk.killrate.awardNumber.sixi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSixzhixzhqAwardNumber extends TestSixzhixzhAwardNumber{

	@Before
	public void beforeTest() {
		order.setContent("0,0,0,0,-");
		order.setMethod("sixzhixzhq");
	}
	
}