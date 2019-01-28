package com.etonghk.killrate.service.awardnmber.ssc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 时时彩工具类别
 * @author Ami
 *
 */
public class SSCAwardUtils {
	
	/**
	 * 判断 四星 三星 二星
	 * @param playId
	 * @return 0前  1中 2后
	 */
	public static Integer getFrontOrMiddleOrBack(String playId) {
		String lastChar = playId.substring(playId.length()-1, playId.length());
		if("q".equals(lastChar)) {
			return 0;
		}else if("z".equals(lastChar)) {
			return 1;			
		}else if("h".equals(lastChar)) {
			return 2;			
		}
		return -1;
	}
	
	/**
	 * 判断跨度 前 中 后
	 * @param playId
	 * @return 0前  1中 2后
	 */
	public static Integer getKDFrontOrMiddleOrBack(String playId) {
		String lastChar = playId.substring(playId.length()-2, playId.length()-1);
		if("q".equals(lastChar)) {
			return 0;
		}else if("z".equals(lastChar)) {
			return 1;			
		}else if("h".equals(lastChar)) {
			return 2;			
		}
		return -1;
	}

	/**
	 * 阵列转化ArrayList
	 * @param array
	 * @return
	 */
	public static <T>List<T> arrayToList(T[] array) {
		List<T> result = new ArrayList<T>();
		Arrays.stream(array).forEach(item->{
			result.add(item);
			}
		);
		return result;
	}
	
	/**
	 * 
	 * @param numberMap
	 * @param number
	 * @param awardMoney
	 */
	public static void addAwardMoney(Map<String, BigDecimal> numberMap, String number, BigDecimal awardMoney) {
		if (numberMap.get(number) == null) {
			numberMap.put(number, awardMoney);
		} else {
			numberMap.put(number, numberMap.get(number).add(awardMoney));
		}
	}

	
}