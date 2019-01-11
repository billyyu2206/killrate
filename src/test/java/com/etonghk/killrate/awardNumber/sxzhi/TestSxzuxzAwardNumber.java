package com.etonghk.killrate.awardNumber.sxzhi;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.vo.BetRecordBean;
/**
 * 三星組三
 * @author Peter
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSxzuxzAwardNumber { 

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Test
	public void testSxzuxzAwardNumber() {
		// "後 sxzuxzsh","中sxzuxzsz","前sxzuxzsq"
		BetRecordBean betOrder = new BetRecordBean();
		betOrder.setBetItem("13");
		
		betOrder.setGamePlayId("sxzuxzsh");
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber("sxzuxzsh");
		List<String> result = awardNumber.getAwardNumber(betOrder);
		System.out.println(result);
		System.out.println(result.size());
	}
	
	public void testSxzuxzCalcMoney() {
		
	}
	
	public void testAll() {
		// oriMap // 傳入的資料
		// BetRecordBean bean = BeanConverFactory.getConverHelper(oriMap);
		// AwardNumber awardNumber = awardNumberFactory.getAwardNumber(bean.getGamePlayId());
		// Map<String,List<String>> awardMap = awardNumber.getAwardNumber(betOrder);
		// Map<String, BigDecimal> result = calcAwardMoney(BetRecordBean betOrder, Map<String, List<String>>
		
	}
	
}
