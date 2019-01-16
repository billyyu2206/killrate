package com.etonghk.killrate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

@RestController
@RequestMapping("/betRecord")
public class BetRecordReceiveController {
	
	@RequestMapping("/send")
	public ApiResult betReceive(@RequestBody List<GameLotteryOrder> betRecords) {
		ApiResult result = new ApiResult();
		
		// TODO send MQ
		
		result.setResultCode("0000");
		result.setResultMsg("success");
		return result;
	}
}
