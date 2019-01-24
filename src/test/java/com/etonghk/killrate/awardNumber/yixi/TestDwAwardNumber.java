/**
 * 
 */
package com.etonghk.killrate.awardNumber.yixi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	一星_定位胆 dw
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDwAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("12,-,5,-,-");
		order.setMethod("dw");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
