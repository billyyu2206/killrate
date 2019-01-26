package com.etonghk.killrate.service.account;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.etonghk.killrate.dao.AccountDao;
import com.etonghk.killrate.domain.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void creat(Account account) {
		account.setPassword(getMd5(account.getPassword()));
		account.setCreateTime(LocalDateTime.now());
		accountDao.insert(account);
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> getAccList(Account account) {
		return accountDao.selectByCondition(account);
	}

	@Override
	public Account getAccById(Integer id) {
		return accountDao.selectByPrimaryKey(id);
	}
	
	@Override
	public Account login(String account, String password,String ip) throws Exception{
		password = getMd5(password);
		Account acc = accountDao.login(account, password);
		if(acc == null) {
			throw new RuntimeException("帳號密碼錯誤");
		}
		acc.setLastLoginIp(ip);
		acc.setLastLoginTime(LocalDateTime.now());
		accountDao.updateLogin(acc);
		return acc;
	}
	
	private static String getMd5(String password) {
		String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return DigestUtils.md5DigestAsHex(passwordMd5.getBytes()).toUpperCase();
	}
}
