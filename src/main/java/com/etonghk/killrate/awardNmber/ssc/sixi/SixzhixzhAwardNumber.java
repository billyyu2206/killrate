package com.etonghk.killrate.awardNmber.ssc.sixi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.ssc.SSCAwardUtils;
import com.etonghk.killrate.config.SSCConfig;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 四星直選組合
 * @author Ami
 *
 */
@AwardComponent(name= {"sixzhixzhh","sixzhixzhq"})
public class SixzhixzhAwardNumber extends SixiBase implements AwardNumber{

	private String[] allBallNumbers= SSCConfig.sscItemSource.clone();
	
	@Override
	public Map<String, List<String>> getAwardNumberOfType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int typeIndex = TypeStartIndex;
		String[][] rowcols = getBetItemsRows(betOrder);
		List<String> itemlist = new ArrayList<String>();
		String[] reverseBallNumber = null;
		
		//計算四星獎號
		AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
		int[] pos = getSixiPos(betOrder.getGamePlayId());
		itemlist = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, pos[0], pos[1]);		
		result.put(typeIndex + "", itemlist);
		typeIndex++;
		
		//計算后三星獎號
		itemlist = new ArrayList<String>();
		//若五星號碼全包,則不需要計算後四,因為后四獎金會包含在五星內
		if(rowcols[0].length != 10) {
			reverseBallNumber = getReverseBallNumberStringArray(rowcols[0]);
			rowcols[0] = reverseBallNumber;
			AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
			itemlist = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, pos[0], pos[1]);		
		}
		result.put(typeIndex + "", itemlist);
		typeIndex++;
		
		//計算后二星號碼
		//同后四
		itemlist = new ArrayList<String>();
		if(rowcols[1].length != 10) {
			reverseBallNumber = getReverseBallNumberStringArray(rowcols[1]);
			rowcols[0] = allBallNumbers;
			rowcols[1] = reverseBallNumber;
			AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
			itemlist = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, pos[0], pos[1]);	
		}
		result.put(typeIndex + "", itemlist);
		typeIndex++;
		
		//計算后一號碼
		//同后四
		itemlist = new ArrayList<String>();
		if(rowcols[2].length != 10) {
			//計算后二號碼
			reverseBallNumber = getReverseBallNumberStringArray(rowcols[2]);
			rowcols[0] = allBallNumbers;
			rowcols[1] = allBallNumbers;
			rowcols[2] = reverseBallNumber;
			AwardNumberGenerateUtils.betItemPermutation(rowcols, 0, "", itemlist);
			itemlist = AwardNumberGenerateUtils.getCompleteAwardList(itemlist, pos[0], pos[1]);	
		}
		result.put(typeIndex + "", itemlist);
		return result;
	}
	
	private String[] getReverseBallNumberStringArray(String[] ballArray) {
		List<String> allBallNumberList = SSCAwardUtils.arrayToList(allBallNumbers);
		for(String ball:ballArray) {
			allBallNumberList.remove(ball);
		}
		return allBallNumberList.toArray(new String[0]);
	}
	
}