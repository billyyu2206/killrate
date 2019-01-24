package com.etonghk.killrate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etonghk.killrate.constant.KillrateConstant;
import com.etonghk.killrate.controller.dto.request.KillrateSettingLogRequest;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateSettingLog;
import com.etonghk.killrate.service.killrateSettingLog.KillrateSettingLogService;

@Controller
@RequestMapping("/killrateSettingLog")
public class KillrateSettingLogController {

	@Autowired
	private KillrateSettingLogService killrateSettingLogService;
	
	@RequestMapping("/index")
	public String index(KillrateSettingLogRequest cond, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize,
			Model model) {
		
		Page<KillrateSettingLog> page = new Page<KillrateSettingLog>();
		page.setPage(pageNo);
		page.setPageSize(pageSize);
		page = killrateSettingLogService.selectForPage(cond, page);
		
		
		model.addAttribute("list", page.getRecords());
		model.addAttribute("allGameData", KillrateConstant.allGameMap);
		model.addAttribute("page", page);
		model.addAttribute("cond", cond);
		return "/killrate/killrateSettingLog/index";
	}
	
}
