package com.etonghk.killrate.service.awardnmber.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.etonghk.killrate.domain.AwardSample;
import com.etonghk.killrate.service.awardnmber.constant.KillrateConstant;
import com.etonghk.killrate.service.awardnmber.ssc.SSCAwardUtils;
import com.etonghk.killrate.service.awardsample.memory.AwardSampleMemory;
import com.jack.entity.GameLotteryOrder;
import com.jack.pool.DataFactory;

import lottery.utils.prize.cacluate.LotteryResult;

public class AwardNumberUtil {

	Map<String, Map<String, String>> playNumberMap;

	
	/**
	 * 依類型 計算號碼中獎金額
	 * @param betOrder
	 * @param typeByAwardNumber
	 * @return
	 */
	public static Map<String, BigDecimal> getCalcAwardMoney(GameLotteryOrder order,
			Map<String, List<String>> typeByAwardNumber, AwardSampleMemory memory, DataFactory dataFactory) {
		// TODO 需call jar拿取中獎金額 下面寫死供測試用
		Map<String, BigDecimal> result = new HashMap<>();

		for (Entry<String, List<String>> map : typeByAwardNumber.entrySet()) {

			// 從cache中拿取 每一種玩法最小中獎投注方式
			AwardSample sample = memory.getAwardSampleByKey(KillrateConstant.allGameTypeMap.get(order.getLottery()) + ":" + order.getMethod() + ":" + map.getKey());
			// 拿投注項目 中獎號碼
			String awardNumber = sample.getAwardNumber();
			String betNumber = sample.getBetNumber();
			
			// FIXME 中獎金額 
			order.setContent(betNumber);
			order.setOpenCode(awardNumber);
			LotteryResult ltResult = dataFactory.doCacluate(order);
			BigDecimal awardMoney = getAwardMoney(order);//ltResult.getWinMoney()
			
			// FIXME 目前暫時假定以money的正負來判斷
			// 撤單類 money 為負項
			if(order.getMoney() < 0) {
				awardMoney = BigDecimal.ZERO.subtract(awardMoney);
			}
			
			List<String> numberList = map.getValue();
			for (String number : numberList) {
				SSCAwardUtils.addAwardMoney(result, number, awardMoney);
			}
		}
		
		// FIXME 需對撤單做判斷
		SSCAwardUtils.addAwardMoney(result, KillrateConstant.TOTAL_BET, new BigDecimal(order.getMoney()));
		return result;
	}
	
	// 假的回傳金額
	private static BigDecimal getAwardMoney(GameLotteryOrder order) {
		BigDecimal result;
		result = new BigDecimal(order.getMultiple() * 100);

		return result;
	}
	
}
