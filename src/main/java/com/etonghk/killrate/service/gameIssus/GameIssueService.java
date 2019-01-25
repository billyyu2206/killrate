/**
 * 
 */
package com.etonghk.killrate.service.gameIssus;

import java.util.Date;

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
	public void batchInsert(Date date ,int afterDay);
	
	/**
	 *	查詢此時間段的獎期
	 * @param lottery
	 * @param date
	 * @return
	 */
	public String getIssueByDate(String lottery,Date date);
}
