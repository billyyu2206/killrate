package com.etonghk.killrate.service.killratesender;

import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
public interface KillrateSenderService {
	public void sendGameLotteryOrder(GameLotteryOrder order);
}
