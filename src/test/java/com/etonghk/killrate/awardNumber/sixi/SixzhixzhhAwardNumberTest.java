package com.etonghk.killrate.awardNumber.sixi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;
/**
 *	后四星_直选组合 sixzhixzhh
 * @author Peter.Hong
 * @date 2019年1月21日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SixzhixzhhAwardNumberTest extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("-,0,0,0,0");
		order.setMethod("sixzhixzhh");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
}