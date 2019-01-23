package com.etonghk.killrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("createAccount")
	public String createAccountIndex(Account account) {
		
		return "/account/createAcc";
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public ApiResult<Void> createAccount(Account account) {
		ApiResult<Void> result = new ApiResult<Void>();
		accountService.creat(account);
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("帐号建立成功");
		return result;
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
	
	@RequestMapping("/index")
	public String index(Account account, Model model) {
		List<Account> list =  accountService.getAccList(account);
		model.addAttribute("accList", list);
		return "/account/index";
	}
}
