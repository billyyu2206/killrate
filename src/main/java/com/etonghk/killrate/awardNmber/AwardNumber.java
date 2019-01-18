package com.etonghk.killrate.awardNmber;

import java.util.List;
import java.util.Map;

import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

public interface AwardNumber {
	/**
	 * 	星號符號
	 */
	String BetLineSplit = "[,]";
	/**
	 * 	選號符號
	 */
	String BetItemSplit = "";
	/**
	 * 	選位數符號
	 */
	String BetPosItem = "[√]";
	/**
	 * 	龍虎鬥下注項目切分符號
	 */
	String BetLongHuSplit = "[|]";
	
	/**
	 * 
	 *	 直選單式
	 */
	String BetZhSplit="[,]";
	
	/**
	 * 
	 *	 類型開始Index
	 */
	int TypeStartIndex = 1;
	
	/**
	 * 依據類型 區分中獎號碼
	 * @param betOrder
	 * @return
	 */
	Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order);
}
