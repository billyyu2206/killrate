package com.etonghk.killrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginContorller {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
