package com.etonghk.killrate.service.awardnmber.ssc.sixi;

import java.util.List;

import com.etonghk.killrate.service.awardnmber.AwardNumber;
import com.etonghk.killrate.service.awardnmber.ssc.SSCAwardUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 四星基础类别
 * @author Peter
 *
 */
public abstract class SixiBase{
	
	/**
	 * 组成四星直选号码球
	 * @param betOrder
	 * @return
	 */
	protected String[][] getBetItemsRows(GameLotteryOrder order){
		String[][] rowcols = new String[4][];
		List<String> rowList = SSCAwardUtils.arrayToList(order.getContent().split(AwardNumber.BetLineSplit));
		//取得前四后四要忽视的球位
		int ignoreBallPos = getIgnoreBallPos(order.getMethod());
		rowList.remove(ignoreBallPos);
		String[] rows = rowList.toArray(new String[0]);
		for (int i = 0; i < rows.length; i++) {
			rowcols[i] = rows[i].split(AwardNumber.BetItemSplit);
		}
		return rowcols;
	}
	
	/**
	 * 取得前四后四不看的球位
	 * @param playId
	 * @return 前四 4  后四0
	 */
	protected int getIgnoreBallPos(String playId) {
		int pos = SSCAwardUtils.getFrontOrMiddleOrBack(playId);
		if(pos==0) {
			return 4;
		}else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @param pos 0前 1中 2后
	 * @return [0]:pre [1]:suf
	 */
	protected int[] getSixiPos(String playId) {
		int pos = SSCAwardUtils.getFrontOrMiddleOrBack(playId);
		int[] result = new int[2];
		if(pos==0) {
			result[0] = 0;
			result[1] = 1;
		}else {
			result[0] = 1;
			result[1] = 0;			
		}
		return result;
	}
}
