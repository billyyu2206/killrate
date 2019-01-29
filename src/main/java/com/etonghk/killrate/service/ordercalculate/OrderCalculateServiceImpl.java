/**
 * 
 */
package com.etonghk.killrate.service.ordercalculate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.service.awardnmber.AwardNumber;
import com.etonghk.killrate.service.awardnmber.AwardNumberFactory;
import com.etonghk.killrate.service.awardnmber.utils.AwardNumberUtil;
import com.etonghk.killrate.service.awardsample.memory.AwardSampleMemory;
import com.jack.entity.GameLotteryOrder;
import com.jack.pool.DataFactory;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
@Service
public class OrderCalculateServiceImpl implements OrderCalculateService{

	@Autowired
	private AwardNumberFactory awardNumberFactory;
	
	@Autowired
	private AwardSampleMemory awardSampleCache;

	@Autowired
	private DataFactory dataFactory;
	
	/**
	 * 	計算注單個開獎號碼金額
	 */
	@Override
	public Map<String,BigDecimal> doCalOrder(GameLotteryOrder order) {
		AwardNumber awardNumber = awardNumberFactory.getAwardNumber(order.getMethod());
		Map<String,List<String>> typeByAwardNumber = awardNumber.getAwardNumberWithType(order);
		Map<String,BigDecimal> resultToSet = AwardNumberUtil.getCalcAwardMoney(order, typeByAwardNumber, awardSampleCache, dataFactory);
		return resultToSet;
	}

}
