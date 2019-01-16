package com.etonghk.killrate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.domain.Account;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAccountDao {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void testSelect() {
		Account account = accountDao.selectByPrimaryKey(12);
	}
	
}
