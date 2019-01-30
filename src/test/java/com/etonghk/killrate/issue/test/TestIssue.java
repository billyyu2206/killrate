package com.etonghk.killrate.issue.test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.service.gameIssus.GameIssueService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestIssue {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GameIssueDao gameIssueDao;
	
	@Autowired
	private GameIssueService gameIssueService;
	
	@Test
	public void testInsertIssue() {
		String lottery = "tls90";
		LocalDateTime startTime = LocalDateTime.now().with(LocalTime.MIN);
		List<GameIssue> data = new ArrayList<GameIssue>();
		GameIssue issue = null;
		// 90 960 10and40
		int periodSeconds = 90;
		int openSeconds =  10;
		LocalDateTime issueTime = startTime;
		for(int i = 0; i <960; i++) {
			issue = new GameIssue();
			issue.setPlayId("ssc");
			issue.setLottery(lottery);
			issue.setIssueDate(issueTime);
			issue.setIssue(StringUtils.leftPad(i+"", 4, "0"));
			String dateStr= startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			issue.setFullIssue(dateStr+"-"+ issue.getIssue());
			issue.setIssueStartTime(startTime);
			LocalDateTime endTime = startTime.plusSeconds(periodSeconds);
			issue.setIssueEndTime(endTime);
			issue.setIssueOpenTime(endTime.plusSeconds(openSeconds));
			data.add(issue);
			startTime = endTime;
			System.out.println(issue);
		}
		gameIssueDao.batchInsert(data, lottery);
		System.out.println("test end");
	}
	
	@Test
	public void testBatch() {
		gameIssueService.batchInsert(LocalDateTime.now(),0);
	}
	
	@Test
	public void testGetIssuByDate() {
		String lottery = "t1s60";
		List<String> issue = gameIssueService.getIssueByDate(lottery, LocalDateTime.now());
		issue.forEach(num->System.out.println(num));
		logger.info("issue {}",issue);
	}
	
	
}
