package com.etonghk.killrate.vo;

import java.io.Serializable;

import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月30日
 */
@SuppressWarnings("serial")
public class BetOrderQueueVo implements Serializable{
	private GameLotteryOrder gameLotteryOrder;
	private String message;
	public GameLotteryOrder getGameLotteryOrder() {
		return gameLotteryOrder;
	}
	public void setGameLotteryOrder(GameLotteryOrder gameLotteryOrder) {
		this.gameLotteryOrder = gameLotteryOrder;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
