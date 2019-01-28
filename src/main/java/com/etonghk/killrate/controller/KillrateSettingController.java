package com.etonghk.killrate.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etonghk.killrate.awardnmber.constant.KillrateConstant;
import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.service.killrateaward.KillrateAwardService;
import com.etonghk.killrate.utils.RequestUtils;

@Controller
@RequestMapping("/killrateSetting")
public class KillrateSettingController {

	@Autowired
	private KillrateAwardService killrateAwardService;
	
	@Autowired
	private RedisCache redisCache;
	
	private static final String SWITCH_KEY = "killrateSwitch";
	
	@RequestMapping("/index/{lottery}")
	public String index(@PathVariable String lottery, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			Model model) {
		KillrateAward cond = new KillrateAward();
		cond.setLottery(lottery);
		cond.setIssueEndTime(LocalDateTime.now());
		
		Page<KillrateAward> page=new Page<KillrateAward>();
		page.setPage(pageNo);
		page.setPageSize(100);
		page = killrateAwardService.selectForSettingPage(cond,page);
		
		
		model.addAttribute("list", page.getRecords());
		model.addAttribute("lottery", lottery);
		model.addAttribute("allGameData", KillrateConstant.allGameMap);
		model.addAttribute("page", page);
		return "/killrate/killrateSetting/index";
	}
	
	@ResponseBody
	@RequestMapping("/generate")
	public ApiResult<Void> generate(KillrateSetting setting, HttpServletRequest req) {
		ApiResult<Void> result = new ApiResult<Void>();
		killrateAwardService.generateKillrateAward(setting, RequestUtils.getSessoinAccount(req));
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("生成成功");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public ApiResult<Void> update(KillrateAward record, HttpServletRequest req) {
		ApiResult<Void> result = new ApiResult<Void>();
		String code = ApiResult.SUCCESS_CODE;
		String msg = "修改成功";
		int count = killrateAwardService.updateKillrateAward(record, RequestUtils.getSessoinAccount(req));
		if(count <= 0) {
			code = "201";
			msg = "修改失败，奖期时间已结束";
		}
		
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public ApiResult<Void> delete(KillrateAward record, HttpServletRequest req) {
		ApiResult<Void> result = new ApiResult<Void>();
		String code = ApiResult.SUCCESS_CODE;
		String msg = "删除成功";
		int count = killrateAwardService.deleteKillrateAward(record, RequestUtils.getSessoinAccount(req));
		if(count <= 0) {
			code = "201";
			msg = "删除失败，奖期时间已结束";
		}
		
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	@RequestMapping("/switch")
	public String switchPage(Model model) {
		String switchValue = (String) redisCache.getObj(SWITCH_KEY);
		if(StringUtils.isBlank(switchValue)) {
			switchValue = "0";
		}
		model.addAttribute("switchValue", switchValue);
		return "/killrate/killrateSetting/switch";
	}
	
	@ResponseBody
	@RequestMapping("/changeSwitch")
	public ApiResult<Void> delete(String switchValue) {
		ApiResult<Void> result = new ApiResult<Void>();
		redisCache.putObj(SWITCH_KEY, switchValue);
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg(ApiResult.SUCCESS_MSG);
		return result;
	}
}
