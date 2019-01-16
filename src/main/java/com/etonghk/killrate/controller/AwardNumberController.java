package com.etonghk.killrate.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.AwardNumberBean;

@RestController
@RequestMapping("awardNumber")
public class AwardNumberController {

	@PostMapping("gameId/{gameId}/issue/{issue}")
	public AwardNumberBean getAwardNumber(@PathVariable String gameId,@PathVariable String issue) {
		
		/* 檢查 awardNumber 是否有期號獎號
		 * 沒有期號:殺率沒有開放 返回
		 * 有期號無獎號 :系統計算獎號 >update Db 判斷是否有成功 返回獎號
		*/
		
		AwardNumberBean result = new AwardNumberBean();
		result.setAwardNumber("1,2,3,4,5");
		result.setGameId(gameId);
		result.setIssue(issue);
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");  
		result.setTimeStamp(date.getTime());
		result.setTime(sdf.format(date));
		result.setStatCode("0000");
		result.setStatMsg("success");
		
		return result;
	}
	
	@PostMapping("job/gameId/{gameId}/issue/{issue}")
	public String getAwardNumberByJob(@PathVariable String gameId,@PathVariable String issue) {
		
		return "success";
	}
	
	
}
