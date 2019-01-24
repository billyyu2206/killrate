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
 * 	跨度_前二跨度 kdqe
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErxiKdqeAwardNumberTest extends TestAwardNumberBasic{

	/*
	 *  選號:組合
	 * 0:10 1:18 2:16 3:14 4:12 5:10 6:8 7:6 8:4 9:2
	 * 
	 */
	@Before
	public void beforeTest() {
		order.setContent("0");
		order.setMethod("kdqe");
		order.setLottery("t1s30");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
