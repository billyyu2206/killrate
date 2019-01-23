package com.etonghk.killrate.awardNmber;

import java.util.List;
import java.util.Map;

import com.jack.entity.GameLotteryOrder;


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
	String BetPosItem = "√";
	/**
	 * 	龍虎鬥下注項目切分符號
	 */
	String BetLongHuSplit = "[|]";
	
	/**
	 * 
	 *	 單式切分符號
	 */
	String BetDsSplit="[ ]";
	
	/**
	 * 
	 *	 不定位
	 */
	String BetBdwSplit="[,]";
	/**
	 * 
	 *	沒選號碼的符號
	 */
	String BetNoPickItem="-";
	
	/**
	 * 
	 *	和值切分符號
	 */
	String BetHgSplit = "[,]";
	/**
	 * 
	 *	組選切分符號
	 */
	String BetZxSplit = "[,]";
	/**
	 * 
	 *	跨度切分符號
	 */
	String BetKdSplit = "[,]";
	/**
	 * 
	 *	和值大小單雙切分符號
	 */
	String BetHgdxdsSplit = "[|]";
	
	/**
	 * 
	 *	趣味切分符號
	 */
	String BetQwSplit = "[,]";
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
