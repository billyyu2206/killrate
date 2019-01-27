package com.etonghk.killrate.service.betrecord;

import java.time.LocalDateTime;

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
	
}
