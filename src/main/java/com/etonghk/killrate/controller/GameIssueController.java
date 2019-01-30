/**
 * 
 */
package com.etonghk.killrate.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.service.gameIssus.GameIssueService;

/**
 * @author Peter.Hong
 * @date 2019年1月23日
 */
@RestController
@RequestMapping("gameIssus")
public class GameIssueController {

	@Autowired
	private GameIssueService gameIssueService;
	
	@PostMapping("batchInsert")
	public ApiResult<String> batchInsertIssueAfterDay(@RequestParam(value = "date", required=false)LocalDateTime date,
			@RequestParam(value = "afterDay", defaultValue = "3")Integer afterDay) {
		
		if(date==null) {
			date = LocalDateTime.now();
		}
		
		gameIssueService.batchInsert(date, afterDay);
		
		return new ApiResult<String>(ApiResult.SUCCESS_CODE,ApiResult.SUCCESS_MSG,"SUCCESS");
	}
	
	
	@PostMapping("selectOpenIssue")
	public ApiResult<List<String>> getIssueByDate(@RequestParam("lottery")String lottery,@RequestParam("date")LocalDateTime date){
		
		List<String> lotteryIssue = gameIssueService.getIssueByDate(lottery, date);
		
		return new ApiResult<List<String>>(ApiResult.SUCCESS_CODE,ApiResult.SUCCESS_MSG,lotteryIssue);
	}
	
}
