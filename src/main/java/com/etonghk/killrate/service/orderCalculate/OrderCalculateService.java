package com.etonghk.killrate.service.orderCalculate;

import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public interface OrderCalculateService {
	public void doCalOrder(GameLotteryOrder order);
}
