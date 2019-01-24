/**
 * 
 */
package com.etonghk.killrate.awardNumber;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.AwardNumberFactory;
import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.jack.entity.GameLotteryOrder;

/**
 * awardNumber 測試基礎流程
 * @author Peter.Hong
 * @date 2019年1月21日
 */
public class TestAwardNumberBasic {

	@Autowired
	private AwardNumberFactory awardNumberFactory;

	protected GameLotteryOrder order = new GameLotteryOrder();

	@Autowired
	private KillRateBetSender killRateBetSender;
	

	/**
	 * 	每個類型的 號碼
	 */
//	@Test
	public void testAwardNumber() {
		long statTime = System.currentTimeMillis();
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(order.getMethod());
		Map<String, List<String>> numberResult = awardNumber.getAwardNumberWithType(order);
		
		for (Map.Entry<String, List<String>> entry : numberResult.entrySet()) {
			System.out.println("TYPE: " + entry.getKey() + "  SIZE: " + entry.getValue().size());
			System.out.println("Value: "+entry.getValue());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time : "+(endTime-statTime));
	}

	/**
	 * 	流程測試
	 */
	@Test
	public void testOrderSender() {
		for(int i=1;i<=100;i++) {
			killRateBetSender.senderGameLotteryOrder(order);			
		}
	}
}
