package com.etonghk.killrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/killRate")
public class KillRateController {

	@RequestMapping("/")
	public String test(Model model) {
		
		model.addAttribute("msg","安安你好");
		return "/killRate/index";
	}
}
