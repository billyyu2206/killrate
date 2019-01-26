/**
 * 
 */
package com.etonghk.killrate.service.gameIssus;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.awardnmber.constant.KillrateConstant;
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
	public void batchInsert(LocalDateTime date,int afterDay) {
		
		List<GamePeriod> gamelist = gamePeriodDao.getGamePeriodsList();
		
		LocalDateTime startTime = LocalDateTime.now().with(LocalTime.MIN);
		LocalDateTime issueTime = startTime;
		for (GamePeriod gamePeriod : gamelist) {
		
			String lottery = gamePeriod.getLottery();
			int totoalPeriod = gamePeriod.getTotalPeriod();
			int openSeconds =  gamePeriod.getOpenSeconds();
			int periodSeconds = gamePeriod.getPeriodSeconds();
			
			// 產X天後獎期
			List<GameIssue> gameIssueList = new ArrayList<GameIssue>();
			GameIssue issue = null;
			
			for(int i = 1; i <= totoalPeriod; i++) {
				issue = new GameIssue();
				issue.setPlayId(KillrateConstant.allGameTypeMap.get(lottery));
				issue.setLottery(lottery);
				issue.setIssueDate(issueTime);
				issue.setIssue(StringUtils.leftPad(i+"", 4, "0"));
				String dateStr= startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				issue.setFullIssue(dateStr+"-"+ issue.getIssue());
				issue.setIssueStartTime(issueTime);
				LocalDateTime endTime = startTime.plusSeconds(periodSeconds);
				issue.setIssueEndTime(endTime);
				issue.setIssueOpenTime(endTime.plusSeconds(openSeconds));				
				gameIssueList.add(issue);
				startTime = endTime;
			}
			gameIssueDao.batchInsert(gameIssueList, gamePeriod.getLottery());
		}
		
	}
	
	@Override
	public String getIssueByDate(String lottery, LocalDateTime date) {
		return gameIssueDao.selectIssueByDate(lottery, date);
	}

}
