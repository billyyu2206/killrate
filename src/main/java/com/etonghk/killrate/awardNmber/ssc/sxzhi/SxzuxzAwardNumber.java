package com.etonghk.killrate.awardNmber.ssc.sxzhi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.anootations.AwardComponent;
import com.etonghk.killrate.awardNmber.AwardNumber;
import com.etonghk.killrate.awardNmber.CalcAwardMoney;
import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * 三星组三
 * @author Peter
 *
 */
@AwardComponent(name={"sxzuxzsh","sxzuxzsz","sxzuxzsq"})
public class SxzuxzAwardNumber extends SxzhiBase implements AwardNumber,CalcAwardMoney {

	@Override
	public List<String> getAwardNumber(BetRecordBean betOrder) {
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(items, ","));
		betDataMap.put(1, StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 1);
		dataCountMap.put(1, 1);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]); // 後三
		
		return resultList;
	}
	
	// 取代上面getAwardNumber
	public Map<String,List<String>> getAwardNumberOfType(BetRecordBean betOrder){
		String[] items = betOrder.getBetItem().split(BetItemSplit);
		Map<Integer, String> betDataMap = new HashMap<Integer, String>();
		betDataMap.put(2, StringUtils.join(items, ","));
		betDataMap.put(1, StringUtils.join(items, ","));

		Map<Integer, Integer> dataCountMap = new HashMap<Integer, Integer>();
		dataCountMap.put(2, 1);
		dataCountMap.put(1, 1);

		List<String> resultList = AwardNumberGenerateUtils.getTzuShiuanNumber(betDataMap, dataCountMap, 2);
		int[] sxzhi = getSxzhiPos(betOrder.getGamePlayId());
		resultList = AwardNumberGenerateUtils.getCompleteAwardList(resultList, sxzhi[0], sxzhi[1]); // 後三
		
		Map<String, List<String>> resultMap = new HashMap<String,List<String>>();
		resultMap.put("1",resultList);
		return resultMap;
	}
	
	@Override
	public Map<String, BigDecimal> calcAwardMoney(BetRecordBean betOrder, Map<String, List<String>> TypeByAwardNumber) {
		Map<String,BigDecimal> awardMoneyMap = new HashMap<String,BigDecimal>();
		// TODO 拿每筆一種獎號call 終獎金額API
		List<String> awardNumber = TypeByAwardNumber.get("1");
		Map<String,BigDecimal> apiResult = new HashMap<>();
		apiResult.put("1",new BigDecimal(123));

		// 把每個中獎號碼 塞錢
		for ( Map.Entry<String,List<String>>map : TypeByAwardNumber.entrySet()) {
			String key = map.getKey();
			List list = map.getValue();
			for (String number : awardNumber) {
				apiResult.put(number, apiResult.get(key));
			}
		}
		
		return awardMoneyMap;
	}

}
