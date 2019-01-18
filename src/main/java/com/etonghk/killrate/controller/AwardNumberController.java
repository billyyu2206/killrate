package com.etonghk.killrate.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.response.AwardNumberResponse;
import com.etonghk.killrate.service.killrateAward.KillrateAwardService;

@RestController
@RequestMapping("awardNumber")
public class AwardNumberController {

	@Autowired
	private KillrateAwardService killrateAwardService;
	
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
	
	@PostMapping("job")
	public String getAwardNumberByJob(@RequestParam String gameId,@RequestParam String issue) {
		killrateAwardService.calAwardNumber(gameId, issue, true);
		return "success";
	}
	
	
}
