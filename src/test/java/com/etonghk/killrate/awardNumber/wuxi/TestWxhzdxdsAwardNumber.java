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
 * 	五星_和值大小单双 wxhzdxds
 * @author Peter.Hong
 * @date 2019年1月21日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxhzdxdsAwardNumber extends TestAwardNumberBasic{
	
	@Before
	public void beforeTest() {
		order.setContent("大");
		order.setMethod("wxhzdxds");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
