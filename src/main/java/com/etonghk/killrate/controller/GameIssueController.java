/**
 * 
 */
package com.etonghk.killrate.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.service.gameIssus.GameIssueService;

/**
 * @author Peter.Hong
 * @date 2019年1月23日
 */
@Controller
@RequestMapping("gameIssus")
public class GameIssueController {

	@Autowired
	private GameIssueService gameIssueService;
	
	@RequestMapping("/job/batchInsert")
	@ResponseBody
	public ApiResult<String> batchInsertIssueAfterDay(@RequestParam(value = "date", required=false)Date date,
			@RequestParam(value = "afterDay", defaultValue = "3")Integer afterDay) {
		
		if(date==null) {
			date = new Date();
		}
		
		gameIssueService.batchInsert(date, afterDay);
		
		return new ApiResult<String>(ApiResult.SUCCESS_CODE,ApiResult.SUCCESS_MSG,"SUCCESS");
	}
	
	
	@RequestMapping("job/selectOpenIssue")
	@ResponseBody
	public ApiResult<String> getIssueByDate(@RequestParam("lottery")String lottery,@RequestParam("date")Date date){
		
		String lotteryIssue = gameIssueService.getIssueByDate(lottery, date);
		
		return new ApiResult<String>(ApiResult.SUCCESS_CODE,ApiResult.SUCCESS_MSG,lotteryIssue);
	}
	
}
