package com.etonghk.killrate.awardNmber.ssc.rx;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.utils.CommonUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 	任选_混合
 * @author Billy
 *
 */
@AwardComponent(name={"rx3hh"})
public class RxhhAwardNumber extends RxBase implements AwardNumber {

	@Override
	public Map<String, List<String>> getAwardNumberWithType(BetRecordBean betOrder) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		int rxNum = getRxNum(betOrder.getGamePlayId());
		String[] betDatas = betOrder.getBetItem().split("]");
		String[] numsDataTemp = betDatas[1].split(",");
		List<String> type1List = new ArrayList<String>(); // 組三下注項清單
		List<String> type2List = new ArrayList<String>(); // 組六下注項清單
		for(String betNum : numsDataTemp) {
			if(CommonUtils.isRepeat(betNum.split(""))) {// 組三會有重複項
				type1List.add(betNum);
			}else {
				type2List.add(betNum);
			}
		}
		String[] pos = getBetPos(betOrder.getBetItem());
		result.put("1", getNumberExpress(type1List, pos, rxNum));
		result.put("2", getNumberExpress(type2List, pos, rxNum));
		return result;
	}

	@Override
	public Map<String, BigDecimal> getCalcAwardMoney(BetRecordBean betOrder,
			Map<String, List<String>> typeByAwardNumber) {
		// TODO Auto-generated method stub
		return null;
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
