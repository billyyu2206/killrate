package com.etonghk.killrate.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.service.betrecord.BetRecordService;
import com.jack.entity.GameLotteryOrder;

@RestController
@RequestMapping("/betRecord")
public class BetRecordController {
	
	@Autowired
	private BetRecordService betRecordService;
	
	@RequestMapping("/send")
	public ApiResult<Void> betReceive(@RequestBody List<GameLotteryOrder> orders) {
		ApiResult<Void> result = new ApiResult<Void>();

		orders.forEach(order->{
			betRecordService.sendGameLotteryOrder(order);
		});
		
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg(ApiResult.SUCCESS_MSG);
		return result;
	}
	
	@RequestMapping("/createPurseTable")
	public ApiResult<Void> createPurseTable(@RequestParam(value = "date", required=false)LocalDateTime date,
			@RequestParam(value = "afterDay", defaultValue = "3")Integer afterDay) {
		ApiResult<Void> result = new ApiResult<Void>();
		if(date==null) {
			date = LocalDateTime.now();
		}
		
		betRecordService.createPurseTable(date, afterDay);
		
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg(ApiResult.SUCCESS_MSG);
		return result;
	}
}
