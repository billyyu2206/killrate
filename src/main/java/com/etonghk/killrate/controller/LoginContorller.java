package com.etonghk.killrate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;
import com.etonghk.killrate.utils.RequestUtils;

@Controller
public class LoginContorller {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/loginAcc", method = RequestMethod.POST)
	public String login(Account account, Model model, HttpServletRequest request) {
		HttpSession session =  request.getSession();
		try {
			model.addAttribute("errorMsg", "");
			String ip = RequestUtils.getFisrtRemoteHost(request);
			account = accountService.login(account.getAccount(), account.getPassword(), ip);
			session.setAttribute(session.getId(), account);
		} catch (RuntimeException e) {
			model.addAttribute("errorMsg", "帐号密码错误");
			return "login";
		} catch (Exception e) {
			model.addAttribute("errorMsg", "错误");
			return "login";
		}

		return "redirect:/index";
	}
	
	@RequestMapping("logOut")
	public String logOut(HttpSession session) {
		session.removeAttribute(session.getId());
		return "redirect:/";
	}

}
