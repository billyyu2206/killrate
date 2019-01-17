package com.etonghk.killrate.awardNmber.convert;

import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;
import com.etonghk.killrate.vo.BetRecordBean;

public class BetConvertImpl implements BetDataConvert<GameLotteryOrder> {

	@Override
	public BetRecordBean convertBetRecord(GameLotteryOrder gameLotterOrder) {
		
		BetRecordBean bean = new BetRecordBean();
		bean.setGameId(gameLotterOrder.getLottery()); // 採種
		bean.setGamePlayId(gameLotterOrder.getMethod()); // 玩法
		bean.setBetItem(gameLotterOrder.getContent()); // 投注內容
//		bean.setAmode(gameLotterOrder.getModel()); // 元角分
		//bean.setIssue(gameLotterOrder.getIssue()); // 獎期
		bean.setBetMultiplier(gameLotterOrder.getMultiple());
		return bean;
	}

}
