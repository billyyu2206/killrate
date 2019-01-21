package com.etonghk.killrate.awardNumber.wuxi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNumber.TestAwardNumberBasic;

/**
 * 	五星_直选复式 wxzhixfs
 * @author Peter.Hong
 * @date 2019年1月19日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWxzhixfsAwardNumber extends TestAwardNumberBasic{

	@Before
	public void beforeTest() {
		order.setContent("1,2,3,4,5");
		order.setMethod("wxzhixfs");
		order.setLottery("vipssc");
		order.setMultiple(1);
		order.setMoney(1);
		order.setModel("yuan");
		order.setIssue("201901191002");
	}
	
}

