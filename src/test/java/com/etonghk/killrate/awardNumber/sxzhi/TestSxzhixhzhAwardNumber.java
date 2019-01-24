/**
 * 
 */
package com.etonghk.killrate.awardNumber.sxzhi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	后三码_直选和值 sxzhixhzh
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSxzhixhzhAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("2");
		order.setMethod("sxzhixhzh");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
