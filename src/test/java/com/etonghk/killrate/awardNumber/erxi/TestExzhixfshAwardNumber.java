/**
 * 
 */
package com.etonghk.killrate.awardNumber.erxi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	后二星_直选复式 exzhixfsh
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExzhixfshAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("-,-,-,0,0");
		order.setMethod("exzhixfsh");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
