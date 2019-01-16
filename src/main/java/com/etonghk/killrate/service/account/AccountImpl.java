package com.etonghk.killrate.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etonghk.killrate.dao.IAccountDao;
import com.etonghk.killrate.domain.Account;

public class AccountImpl implements AccountService {

	@Autowired
	IAccountDao accountDao;
	
	@Override
	public void creat(Account account) {
		accountDao.insert(account);

	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> getAccList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccById(Integer id) {
		return accountDao.selectByPrimaryKey(id);
	}
	
	@Override
	public Account getAccByName(String name) {
		return accountDao.selectByName(name);
	}

}
