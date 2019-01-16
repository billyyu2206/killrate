package com.etonghk.killrate.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etonghk.killrate.constant.KillrateConstant;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.service.killrateAward.KillrateAwardService;

@Controller
@RequestMapping("/killrateSetting")
public class KillrateSettingController {

	@Autowired
	private KillrateAwardService killrateAwardService;
	
	@RequestMapping("/index/{gameId}")
	public String index(@PathVariable String gameId, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize,
			Model model) {
		Map<String, Object> cond = new HashMap<String, Object>();
		cond.put("gameId", gameId);
		cond.put("issueEndTime", new Date());
		
		//TODO 分頁
		List<KillrateAward> list = killrateAwardService.selectForSettingPage(cond);
		
		
		model.addAttribute("list", list);
		model.addAttribute("gameId", gameId);
		model.addAttribute("allGameData", KillrateConstant.allGameMap);
		return "/killrate/killrateSetting/index";
	}
	
	@ResponseBody
	@RequestMapping("/generate/{gameId}")
	public String generate(@PathVariable String gameId, Model model) {
		return "/killrate/killrateSetting/index";
	}
}
