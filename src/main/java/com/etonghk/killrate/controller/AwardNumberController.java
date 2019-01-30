package com.etonghk.killrate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.request.LotteryIssue;
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
		logger.info("getAwardNumber lottery : {} ,"	+ "issue : {}",lottery,issue);
		ApiResult<AwardNumberResponse> awardNumberResult = killRateNumberService.getKillRateAward(lottery, issue);
		return awardNumberResult;
	}
	
	@PostMapping("clearKillRate")
	public String clearKillRate(@RequestBody LotteryIssue lotteryIssue) {
		ClearKillRateVo vo = null;
		for (String issue : lotteryIssue.getIssueList()) {
			vo = new ClearKillRateVo();
			vo.setLottery(lotteryIssue.getLottery());
			vo.setIssue(issue);
			clearKillRateSender.sendClearLotteryIssue(vo);
		}
		return "success";
	}
	
}