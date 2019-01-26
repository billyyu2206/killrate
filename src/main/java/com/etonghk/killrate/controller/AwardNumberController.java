package com.etonghk.killrate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.response.AwardNumberResponse;
import com.etonghk.killrate.mq.sender.ClearKillRateSender;
import com.etonghk.killrate.service.killratenumber.KillRateNumberService;
import com.etonghk.killrate.vo.ClearKillRateVo;

@RestController
@RequestMapping("awardNumber")
public class AwardNumberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KillRateNumberService killRateNumberService;
	
	@Autowired
	private ClearKillRateSender clearKillRateSender;
	
	@PostMapping("getNumber")
	public ApiResult<AwardNumberResponse> getAwardNumber(@RequestParam String lottery,@RequestParam String issue) {
		ApiResult<AwardNumberResponse> awardNumberResult = killRateNumberService.getKillRateAward(lottery, issue);
		return awardNumberResult;
	}
	
	@PostMapping("clearKillRate")
	public String clearKillRate(@RequestParam String lottery,@RequestParam String issue) {
		logger.info("get lottery = {} , issue ={} to open kill-rate-number",lottery,issue);
		ClearKillRateVo vo = new ClearKillRateVo();
		vo.setLottery(lottery);
		vo.setIssue(issue);
		clearKillRateSender.sendClearLotteryIssue(vo);
		return "success";
	}
	
}