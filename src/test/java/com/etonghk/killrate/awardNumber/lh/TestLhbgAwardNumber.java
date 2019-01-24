/**
 * 
 */
package com.etonghk.killrate.awardNumber.lh;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	龙虎_百个 lhbg
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLhbgAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("龙|虎|和");
		order.setMethod("lhbg");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
