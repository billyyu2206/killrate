package com.etonghk.killrate.awardnmber.ssc.rx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.awardnmber.anootations.AwardComponent;
import com.etonghk.killrate.awardnmber.AwardNumber;
import com.etonghk.killrate.awardnmber.utils.AwardNumberGenerateUtils;
import com.etonghk.killrate.utils.CommonUtils;
import com.jack.entity.GameLotteryOrder;

/**
 * 	任选_混合
 * @author Billy
 *
 */
@AwardComponent(name={"rx3hh"})
public class RxhhAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(GameLotteryOrder order) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int rxNum = getRxNum(order.getMethod());
		String[] betDatas = order.getContent().split("]");
		String[] numsDataTemp = betDatas[1].split(BetDsSplit);
		List<String> type1List = new ArrayList<String>(); // 組三下注項清單
		List<String> type2List = new ArrayList<String>(); // 組六下注項清單
		for(String betNum : numsDataTemp) {
			if(CommonUtils.isRepeat(betNum.split(""))) {// 組三會有重複項
				type1List.add(betNum);
			}else {
				type2List.add(betNum);
			}
		}
		String[] pos = getBetPos(order.getContent());
		result.put("1", getNumberExpress(type1List, pos, rxNum));
		result.put("2", getNumberExpress(type2List, pos, rxNum));
		return result;
	}

	private List<String> getNumberExpress(List<String> datas, String[] pos, int rxNum){
		List<String[]> betPermutations = new ArrayList<String[]>();
		for (int i = 0; i < datas.size(); i++) {
			betPermutations.addAll(AwardNumberGenerateUtils.getArrayCombinationPermutation(datas.get(i).split("")));
		}
		
		List<String> resultList = AwardNumberGenerateUtils.getRenXuanTzuShiuanResult(pos, rxNum, 5, betPermutations);
		return resultList;
	}
}
