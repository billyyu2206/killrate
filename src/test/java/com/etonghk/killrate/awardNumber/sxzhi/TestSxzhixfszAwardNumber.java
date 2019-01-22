package com.etonghk.killrate.awardNumber.sxzhi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 *	後三星 直选复式 sxzhixfsz
 * @author Peter.Hong
 * @date 2019年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSxzhixfszAwardNumber extends TestAwardNumberBasic{
	
	@Before
	public void beforeTest() {
		order.setContent("-,1,2,3,-");
		order.setMethod("sxzhixfsz");
		order.setLottery("vipssc");
		order.setMultiple(100);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
}
