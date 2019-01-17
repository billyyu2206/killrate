package com.etonghk.killrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("createAccount")
	public String createAccountIndex(Account account) {
		
		return "/account/createAcc";
	}
	
	@PostMapping("create")
	public String createAccount(Account account) {
		
		accountService.creat(account);
		
		return "redirect:/";
	}
	
	@RequestMapping("detail/{accid}")
	public String accDetail(Integer id,Model model) {
		
		Account account =  accountService.getAccById(id);
		model.addAttribute("account", account);
		
		return "detail";
	}
	
	@RequestMapping("updateAccount/{accId}")
	public String updateAccount(@RequestParam Integer accId,Account account) {
		
		accountService.update(account);
		
		return "redirect:detail?"+accId;
	}
	
	@RequestMapping("list")
	public String accountList(Model model) {
		List<Account> list =  accountService.getAccList();
		model.addAttribute("accList", list);
		return "list";
	}
	
	@RequestMapping("index")
	public String index() {
		return "account/index";
	}
}
