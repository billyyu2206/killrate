package com.etonghk.killrate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etonghk.killrate.constant.KillrateConstant;
import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.request.KillrateSetting;
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
		KillrateAward cond = new KillrateAward();
		cond.setGameId(gameId);
		cond.setIssueEndTime(new Date());
		
		//TODO 分頁
		List<KillrateAward> list = killrateAwardService.selectForSettingPage(cond);
		
		
		model.addAttribute("list", list);
		model.addAttribute("gameId", gameId);
		model.addAttribute("allGameData", KillrateConstant.allGameMap);
		return "/killrate/killrateSetting/index";
	}
	
	@ResponseBody
	@RequestMapping("/generate")
	public ApiResult<Void> generate(KillrateSetting setting, Model model) {
		ApiResult<Void> result = new ApiResult<Void>();
		killrateAwardService.generateKillrateAward(setting);
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("生成成功");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public ApiResult<Void> update(KillrateAward record, Model model) {
		ApiResult<Void> result = new ApiResult<Void>();
		killrateAwardService.updateKillrateAward(record);
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("编辑成功");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public ApiResult<Void> delete(KillrateAward record, Model model) {
		ApiResult<Void> result = new ApiResult<Void>();
		killrateAwardService.deleteKillrateAward(record);
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("删除成功");
		return result;
	}
}
