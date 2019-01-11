package com.etonghk.killrate.awardNmber;

import java.util.List;

import com.etonghk.killrate.vo.BetRecordBean;

public interface AwardNumber {
	/**
	 * 星號符號
	 */
	String BetLineSplit = "[,]";
	/**
	 * 選號符號
	 */
	String BetItemSplit = "&";
	String BetPosItem = "[√]";
	List<String> getAwardNumber(BetRecordBean betOrder);
}
