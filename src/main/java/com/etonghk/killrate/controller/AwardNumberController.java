package com.etonghk.killrate.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.etonghk.killrate.vo.ClearKillRateVo;

@RestController
@RequestMapping("awardNumber")
public class AwardNumberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClearKillRateSender clearKillRateSender;
	
	@PostMapping
	public ApiResult<AwardNumberResponse> getAwardNumber(@RequestParam String gameId,@RequestParam String issue) {
		
		/* 檢查 awardNumber 是否有期號獎號
		 * 沒有期號:殺率沒有開放 返回
		 * 有期號無獎號 :系統計算獎號 >update Db 判斷是否有成功 返回獎號
		*/
		ApiResult<AwardNumberResponse> result = new ApiResult<AwardNumberResponse>();
		AwardNumberResponse awardResult = new AwardNumberResponse();
		awardResult.setAwardNumber("1,2,3,4,5");
		awardResult.setGameId(gameId);
		awardResult.setIssue(issue);
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");  
		awardResult.setTimeStamp(date.getTime());
		awardResult.setTime(sdf.format(date));
		
		result.setData(awardResult);
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("SUCCESS");
		return result;
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