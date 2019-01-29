package com.etonghk.killrate.service.betrecord;

import java.time.LocalDateTime;

import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
public interface BetRecordService {
	/**
	 * 	產追號資料table
	 * @param date
	 * @param afterDay 
	 */
	public void createPurseTable(LocalDateTime date ,int afterDay);
	
	public void sendGameLotteryOrder(GameLotteryOrder order);
}
