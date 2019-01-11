package com.etonghk.killrate.awardNumber.sxzhi;

import java.util.List;

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
		// T oriBetBean  // 傳入的資料
		// BetDataConvert betDataConvert = BeanConverFactory.getConvertObj(oriBetBean);
		// BetRecordBean bean = betDataConvert.convertBetRecord(oriBetBean);
		
		// AwardNumber awardNumber = AwardNumberFactory.getAwardNumber(bean.getGamePlayId());
		// Map<String,List<String>> awardMap = awardNumber.getAwardNumber(betOrder);
		
		
		//CalcAwardMoney calcAwardMoney = FactoryCalcAwardMoney.getcalcAwardMoney(bean.getGamePlayId());
		
		// Map<String, BigDecimal> result = calcAwardMoney.calcAwardMoney(BetRecordBean betOrder, Map<String, List<String>>
		
	}
	
}
