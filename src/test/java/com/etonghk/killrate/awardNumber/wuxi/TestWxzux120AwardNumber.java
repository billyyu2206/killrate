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
 * 	五星_组选120 wxzux120
 * @author Peter.Hong
 * @date 2019年1月19日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzux120AwardNumber extends TestAwardNumberBasic{
	@Before
	public void beforeTest() {
		order.setContent("0,1,2,3,4");
		order.setMethod("wxzux120");
		order.setLottery("vipssc");
		order.setMultiple(1);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
}
