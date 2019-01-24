/**
 * 
 */
package com.etonghk.killrate.service.gameIssus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.constant.KillrateConstant;
import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.dao.GamePeriodDao;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.domain.GamePeriod;

/**
 * @author Peter.Hong
 * @date 2019年1月23日
 */
@Service
public class GameIssueServiceImpl implements GameIssueService{

	@Autowired
	private GameIssueDao gameIssueDao;
	
	@Autowired
	private GamePeriodDao gamePeriodDao;
	
	@Override
	public void batchInsert(Date date,int afterDay) {
		
		List<GamePeriod> gamelist = gamePeriodDao.getGamePeriodsList();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int day = calendar.get(Calendar.DATE);
		int year = calendar.get(Calendar.YEAR);
		
		for (GamePeriod gamePeriod : gamelist) {
		
			String gameId = gamePeriod.getGameId();
			int totoalPeriod = gamePeriod.getTotalPeriod();
			int openSeconds =  gamePeriod.getOpenSeconds();
			int periodSeconds = gamePeriod.getPeriodSeconds();
			
			// 產X天後獎期
			calendar.set(year, 0, day+afterDay, 0, 0, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			List<GameIssue> gameIssueList = new ArrayList<GameIssue>();
			GameIssue issue = null;
			
			for(int i = 1; i <= totoalPeriod; i++) {
				issue = new GameIssue();
				issue.setPlayId(KillrateConstant.allGameTypeMap.get(gameId));
				issue.setGameId(gameId);
				issue.setIssueDate(calendar.getTime());
				issue.setIssue(StringUtils.leftPad(i+"", 4, "0"));
				issue.setFullIssue("" + calendar.get(Calendar.YEAR) + "0" + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DAY_OF_MONTH)+"-"+ issue.getIssue());
				issue.setIssueStartTime(calendar.getTime());
				calendar.add(Calendar.SECOND, periodSeconds);
				issue.setIssueEndTime(calendar.getTime());
				issue.setIssueOpenTime(DateUtils.addSeconds(calendar.getTime(), openSeconds));
				gameIssueList.add(issue);
			}
			gameIssueDao.batchInsert(gameIssueList, gamePeriod.getGameId());
		}
		
	}

}
