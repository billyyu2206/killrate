package com.etonghk.killrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.jack.entity.GameLotteryOrder;

@RestController
@RequestMapping("/betRecord")
public class BetRecordReceiveController {
	
	@Autowired
	private KillRateBetSender killRateBetSender;
	
	@RequestMapping("/send")
	public ApiResult<Void> betReceive(@RequestBody List<GameLotteryOrder> orders) {
		ApiResult<Void> result = new ApiResult<Void>();

		orders.forEach(order->{
			killRateBetSender.senderGameLotteryOrder(order);
		});
		
		result.setCode(ApiResult.SUCCESS_CODE);
		result.setMsg("success");
		return result;
	}
}
