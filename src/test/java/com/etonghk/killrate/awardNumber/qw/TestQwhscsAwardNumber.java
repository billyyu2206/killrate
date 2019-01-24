/**
 * 
 */
package com.etonghk.killrate.awardNumber.qw;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	趣味_好事成双 qwhscs
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQwhscsAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("0,1");
		order.setMethod("qwhscs");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}