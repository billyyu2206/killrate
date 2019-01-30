/**
 * 
 */
package com.etonghk.killrate.service.orderdeadletterlog;

import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
public interface OrderDeadLetterLogService {
	public void insertOrder(GameLotteryOrder order, String message);
}
