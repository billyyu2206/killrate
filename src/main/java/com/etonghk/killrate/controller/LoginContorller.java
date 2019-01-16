package com.etonghk.killrate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;

@Controller
public class LoginContorller {

	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String index(Account account) {

		return "login";
	}

	@PostMapping("/loginAcc")
	public String login(Account account, Model model,HttpSession session) {
		
		try {
			model.addAttribute("errorMsg", null);
			account = accountService.login(account.getAccount(), account.getPassword());
			session.setAttribute(session.getId(), account);
		} catch (RuntimeException e) {
			model.addAttribute("errorMsg", "帳號密碼錯誤");
			return "login";
		} catch (Exception e) {
			model.addAttribute("errorMsg", "錯誤");
			return "login";
		}

		return "redirect:/killRate";
	}

}
