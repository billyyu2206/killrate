package com.etonghk.killrate.awardNmber;

import java.util.List;

import com.etonghk.killrate.vo.BetRecordBean;

public interface AwardNumber {

	String BetLineSplit = "[|]";
	String BetItemSplit = "[&]";
	String BetPosItem = "[√]";
	List<String> getAwardNumber(BetRecordBean betOrder);
}
