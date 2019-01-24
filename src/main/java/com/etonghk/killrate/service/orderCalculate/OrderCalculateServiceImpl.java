/**
 * 
 */
package com.etonghk.killrate.service.orderCalculate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.AwardNumberFactory;
import com.etonghk.killrate.awardNmber.utils.AwardNumberUtil;
import com.etonghk.killrate.awardSample.cache.AwardSampleCache;
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
	private AwardSampleCache awardSampleCache;

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
