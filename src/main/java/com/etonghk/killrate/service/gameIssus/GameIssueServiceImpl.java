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
		
		LocalDateTime nowStartTime = LocalDateTime.now().plusDays(afterDay).with(LocalTime.MIN);
		for (GamePeriod gamePeriod : gamelist) {
			LocalDateTime issueStartTime = nowStartTime;
			
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
				issue.setIssueDate(nowStartTime);
				issue.setIssue(StringUtils.leftPad(i+"", 4, "0"));
				String dateStr= nowStartTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				issue.setFullIssue(dateStr+"-"+ issue.getIssue());
				issue.setIssueStartTime(issueStartTime);
				LocalDateTime issueEndTime = issueStartTime.plusSeconds(periodSeconds);
				issue.setIssueEndTime(issueEndTime);
				issue.setIssueOpenTime(issueEndTime.plusSeconds(openSeconds));				
				gameIssueList.add(issue);
				issueStartTime = issueEndTime;
			}
			gameIssueDao.batchInsert(gameIssueList, gamePeriod.getLottery());
		}
		
	}
	
	@Override
	public String getIssueByDate(String lottery, LocalDateTime date) {
		return gameIssueDao.selectIssueByDate(lottery, date);
	}
	
	@Override
	public List<GameIssue> selectIssueByLotteryAndDate(String lottery, LocalDateTime date) {
		date = LocalDateTime.of(date.toLocalDate(),LocalTime.MIN);
		return gameIssueDao.selectIssueByLotteryAndDate(lottery, date);
	}

}
