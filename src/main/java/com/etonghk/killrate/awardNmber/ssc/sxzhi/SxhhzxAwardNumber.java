package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.controller.dto.request.GameLotteryOrder;

/**
 * 三星混合组选
 * @author Peter
 *
 */
@AwardComponent(name={"sxhhzxh","sxhhzxz","sxhhzxq"})
public class SxhhzxAwardNumber extends SxzhiBase implements AwardNumber{

	@Override
	public Map<String,List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		// FIXME
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		
		String[] items = order.getContent().split(BetLineSplit); // 001,012
		Map<String,List<String>> awardNumMap = arrayToListMap(items);

		int[] sxzhi = getSxzhiPos(order.getMethod());

		for (Map.Entry<String,List<String>> mapEntry : awardNumMap.entrySet()) {
			awardNumMap.put(mapEntry.getKey(), getAwardNumber(mapEntry.getValue(),sxzhi));
		}
		
		return result;
	}
	
	private Map<String, List<String>> arrayToListMap(String[] items) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		List<String> type1list = new ArrayList<String>(); // 組三
		List<String> type2list = new ArrayList<String>(); // 組六
		int typeKey = TypeStartIndex;
		
		for (String str : items) {
			if(isRepeat(str)) {
				typeKey = 1;
				type1list.add(str);
				result.put(typeKey+"",type1list);
			}else {
				typeKey = 2;
				type2list.add(str);
				result.put(typeKey+"",type2list);
			}
		}
		return result;
	}

	private List<String> getAwardNumber(List<String> resultList, int[] sxzhi) {
		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			AwardNumberGenerateUtils.getCombinationPermutation(resultList.get(i), 0, resultList.get(i).length(), "",
					resultList);
		}
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]);
		return resultList;
	}
	
	private boolean isRepeat(String a) {
		if (a == null) {
			return false;
		}
		Set<String> set = new HashSet<String>();
		String[] strArray = a.split("");
		for (String str : strArray) {
			set.add(str);
		}
		if (set.size() != strArray.length) {
			return true;
		}
		return false;
	}
}
