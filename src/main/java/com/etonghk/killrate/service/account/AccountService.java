package com.etonghk.killrate.service.account;

import java.util.List;

import com.etonghk.killrate.domain.Account;

public interface AccountService {

	public void creat(Account account);
	
	
	public void update(Account account);
	
	public List<Account> getAccList();
	
	public Account getAccById(Integer id);

	public Account login(String account,String password) throws Exception;
}


