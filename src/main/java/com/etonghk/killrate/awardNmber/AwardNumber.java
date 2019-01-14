package com.etonghk.killrate.awardNmber;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.vo.BetRecordBean;

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
	
	Map<String,List<String>> getAwardNumberWithType(BetRecordBean betOrder);

	Map<String,BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,Map<String,List<String>> typeByAwardNumber);
}
