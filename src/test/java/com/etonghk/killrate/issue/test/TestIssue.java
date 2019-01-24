package com.etonghk.killrate.issue.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.service.gameIssus.GameIssueService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestIssue {
	
	@Autowired
	private GameIssueDao gameIssueDao;
	
	@Autowired
	private GameIssueService gameIssueService;
	
//	@Test
	public void testInsertIssue() {
		String lottery = "tls90";
		Calendar c = Calendar.getInstance();
		
		c.set(2019, 0, 23, 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(c.getTime());
		Date dateStart = c.getTime();
		List<GameIssue> data = new ArrayList<GameIssue>();
		GameIssue issue = null;
		// 90 960 10and40
		for(int i = 1; i <= 960; i++) {
			issue = new GameIssue();
			issue.setPlayId("ssc");
			issue.setLottery(lottery);
			issue.setIssueDate(dateStart);
			issue.setIssue(StringUtils.leftPad(i+"", 3, "0"));
			issue.setFullIssue("" + c.get(Calendar.YEAR) + "0" + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH) + issue.getIssue());
			issue.setIssueStartTime(c.getTime());
			c.add(Calendar.SECOND, 90);
			issue.setIssueEndTime(c.getTime());
			issue.setIssueOpenTime(DateUtils.addSeconds(c.getTime(), 10));
			data.add(issue);
		}
		System.out.println(data);
		gameIssueDao.batchInsert(data, lottery);
		System.out.println("test end");
	}
	
	@Test
	public void testBatch() {
		gameIssueService.batchInsert(new Date(),0);
	}
	
	
}
