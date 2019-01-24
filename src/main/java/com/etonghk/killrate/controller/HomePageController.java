package com.etonghk.killrate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etonghk.killrate.domain.Account;

@Controller
public class HomePageController {

	@RequestMapping("/")
	public String index(Account account,HttpSession session) {
		if(session.getAttribute(session.getId())!=null) {
			return "redirect:/index";
		}
		return "login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
}
