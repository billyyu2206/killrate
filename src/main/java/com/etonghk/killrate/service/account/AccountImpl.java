package com.etonghk.killrate.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.etonghk.killrate.dao.AccountDao;
import com.etonghk.killrate.domain.Account;

@Service
public class AccountImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	
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
	
	@Override
	public Account login(String account, String password) {
		password = getMd5(password);
		Account acc = accountDao.login(account, password);
		return acc;
	}
	
	private static String getMd5(String password) {
		String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return DigestUtils.md5DigestAsHex(passwordMd5.getBytes()).toUpperCase();
	}
}
