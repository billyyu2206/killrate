package com.etonghk.killrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

//	@Autowired
	AccountService accountService;
	
	@RequestMapping("createAccount")
	public String createAccount(Account account) {
		
		accountService.creat(account);
		
		return "login";
	}
	
	@RequestMapping("detail/{accid}")
	public String accDetail(Integer id,Model model) {
		
		Account account =  accountService.getAccById(id);
		model.addAttribute("account", account);
		
		return "detail";
	}
	
	@RequestMapping("updateAccount/{accId}")
	public String updateAccount(@PathVariable Integer accId,Account account) {
		
		accountService.update(account);
		
		return "detail";
	}
	
	@RequestMapping("list")
	public String accountList(Model model) {
		List<Account> list =  accountService.getAccList();
		model.addAttribute("accList", list);
		return "list";
	}
}
