/**
 * 
 */
package com.etonghk.killrate.awardNumber.wuxi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	五星_组选30 wxzux30
 * @author Peter.Hong
 * @date 2019年1月19日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzux30AwardNumber extends TestAwardNumberBasic{
	
	@Before
	public void beforeTest() {
		order.setContent("01,2");
		order.setMethod("wxzux30");
		order.setLottery("t1s30");
		order.setMultiple(1);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
}
