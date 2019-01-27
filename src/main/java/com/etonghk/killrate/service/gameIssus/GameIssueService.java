/**
 * 
 */
package com.etonghk.killrate.service.gameIssus;

import java.time.LocalDateTime;
import java.util.List;

import com.etonghk.killrate.domain.GameIssue;

/**
 * @author Peter.Hong
 * @date 2019年1月23日
 */
public interface GameIssueService {

	/**
	 * 	產幾天後的獎期
	 * @param date
	 * @param afterDay 
	 */
	public void batchInsert(LocalDateTime date ,int afterDay);
	
	/**
	 *	查詢此時間段的獎期
	 * @param lottery
	 * @param date
	 * @return
	 */
	public String getIssueByDate(String lottery,LocalDateTime date);
	
	public List<GameIssue> selectIssueByLotteryAndDate(String lottery,LocalDateTime date);
}
