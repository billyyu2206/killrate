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
 * 	不定胆_后三一码 bdw1mh
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SxzhiBdw1mhAwardNumberTest extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("0");
		order.setMethod("bdw1mh");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
