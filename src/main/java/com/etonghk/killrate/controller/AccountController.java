package com.etonghk.killrate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping("createAccount")
	public String createAccount(Account account) {
		
		
		
		return "/login";
	}
	
	@RequestMapping("updateAccount/{accId}")
	public String updateAccount(@PathVariable String accId) {
		
		
		return "/account/detail";
	}
	
	@RequestMapping("list")
	public String accountList(Account account) {
		
		return "/account/detail";
	}
}
