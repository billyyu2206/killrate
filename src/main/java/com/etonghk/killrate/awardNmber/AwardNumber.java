package com.etonghk.killrate.awardNmber;

import java.util.List;

import com.etonghk.killrate.vo.BetRecordBean;

public interface AwardNumber {
	/**
	 * 	星號符號
	 */
	String BetLineSplit = "[,]";
	/**
	 * 	選號符號
	 */
	String BetItemSplit = "[]";
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
	 * 直選單式
	 */
	String BetZhSplit="[,]";
	
	List<String> getAwardNumber(BetRecordBean betOrder);
}
