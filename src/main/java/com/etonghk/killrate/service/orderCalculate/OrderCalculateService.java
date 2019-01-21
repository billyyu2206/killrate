package com.etonghk.killrate.service.orderCalculate;

import java.math.BigDecimal;
import java.util.Map;

import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public interface OrderCalculateService {
	public Map<String,BigDecimal> doCalOrder(GameLotteryOrder order);
}
