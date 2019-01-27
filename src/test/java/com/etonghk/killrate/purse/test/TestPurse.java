package com.etonghk.killrate.purse.test;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.service.betrecord.BetRecordService;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPurse {
	@Autowired
	private BetRecordService betRecordService;
	
	@Test
	public void testCreateTable() {
		betRecordService.createPurseTable(LocalDateTime.now(), 1);
	}
}
