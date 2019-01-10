package com.etonghk.killrate.killerUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.config.SSCConfig;

public class AwardNumberGenerateUtils {
	public static void betItemPermutation(String[][] arr, int pos, String prefix, List<String> resultList) {
		if (pos < arr.length) {
			for (int i = 0; i < arr[pos].length; i++) {
				betItemPermutation(arr, pos + 1, prefix + arr[pos][i] + "", resultList);
			}
		} else {
			resultList.add(prefix);
		}
	}

	public static void combination(String[] arr, int pos, int max, String prefix, List<String> resultarr) {
		if (prefix.length() == max) {
			resultarr.add(prefix);
		} else {
			for (int i = pos; i < arr.length; i++) {
				combination(arr, i + 1, max, prefix + arr[i], resultarr);
			}
		}
	}

	public static void combination(String[] is, int pos, List<String> iL, int m, List<String[]> result) {
		if (iL.size() == m) {
			result.add(iL.toArray(new String[m]));
			return;
		}
		for (int i = pos; i < is.length; i++) {
			List<String> iL2 = new ArrayList<String>();
			iL2.addAll(iL);
			if (!iL.contains(is[i])) {
				iL2.add(is[i]);
				combination(is, i + 1, iL2, m, result);
			}
		}
	}

	public static List<String> getCompleteAwardList(String[] itemArray, int preLength, int afterLength) {
		List<String> itemList = Arrays.asList(itemArray);
		return getCompleteAwardList(itemList, preLength, afterLength);
	}

	public static List<String> getCompleteAwardList(List<String> itemList, int preLength, int afterLength) {
		List<String> resultList = new ArrayList<String>();
		if (preLength == 0 && afterLength == 0) {
			resultList = itemList;
		} else {
			for (String item : itemList) {
				addPreAndAfter(item, preLength, afterLength, resultList);
			}
		}
		return resultList;
	}

	public static void addPreAndAfter(String item, int preLength, int afterLength, List<String> resultList) {
		if (preLength > 0) {
			for (int i = 0; i < 10; i++) {
				addPreAndAfter(i + item, preLength - 1, afterLength, resultList);
			}
		} else if (afterLength > 0) {
			for (int i = 0; i < 10; i++) {
				addPreAndAfter(item + i, preLength, afterLength - 1, resultList);
			}
		} else {
			resultList.add(item);
		}
	}
	
	public static void addPreAndAfterForLongHuDou(String item, String huItem, int leftLength, int midLength, int rightLength, List<String> resultList) {
		if (leftLength > 0) {
			for (int i = 0; i < 10; i++) {
				addPreAndAfterForLongHuDou(i + item, huItem, leftLength - 1, midLength, rightLength, resultList);
			}
		} else if (midLength > 0) {
			for (int i = 0; i < 10; i++) {
				addPreAndAfterForLongHuDou(item + i, huItem, leftLength, midLength - 1, rightLength, resultList);
			}
		} else {
			addPreAndAfter(item + huItem, 0, rightLength, resultList);
		}
	}
	

	public static List<String> getTzuShiuanNumber(Map<Integer, String> betDataMap, Map<Integer, Integer> dataCountMap,
			int totalCount) {
		List<String> itemList = new ArrayList<String>();
		String[][] rowCols = new String[totalCount][];
		int index = 0;
		int totalLength = 0;
		for (Integer key : betDataMap.keySet()) {
			int count = dataCountMap.get(key).intValue();
			totalLength += count;
			for (int i = 0; i < count; i++) {
				rowCols[index] = betDataMap.get(key).split(",");
				for (int j = 0; j < rowCols[index].length; j++) {
					for (int k = 1; k < key.intValue(); k++) {
						int tmp150_148 = j;
						String[] tmp150_147 = rowCols[index];
						tmp150_147[tmp150_148] = (tmp150_147[tmp150_148]
								+ ((String) betDataMap.get(key)).split(",")[j]);
					}
				}
				index++;
			}
		}
		getCombinationNumber(rowCols, 0, totalLength, "", itemList);

		itemList = trimRepeatItem(itemList);

		List<String> resultList = new ArrayList<String>();
		for (String item : itemList) {
			resultList.addAll(getCombinationPermutation(item.split("")));
		}
		return resultList;
	}

	public static void getCombinationPermutation(String source, int pos, int maxPos, String result,
			List<String> itemList) {
		if (pos < maxPos) {
			for (int i = 0; i < source.length(); i++) {
				if (i == source.length() - 1) {
					getCombinationPermutation(source.substring(0, i), pos + 1, maxPos,
							result + source.substring(i) + "", itemList);
				} else {
					getCombinationPermutation(source.substring(0, i) + source.substring(i + 1), pos + 1, maxPos,
							result + source.substring(i, i + 1) + "", itemList);
				}
			}
		} else if (!itemList.contains(result)) {
			itemList.add(result);
		}
	}

	public static void getCombinationNumber(String[][] arr, int pos, int totalLength, String result,
			List<String> itemList) {
		if (pos < totalLength) {
			for (int i = 0; i < arr[pos].length; i++) {
				if (pos == 0) {
					getCombinationNumber(arr, pos + 1, totalLength, result + arr[pos][i], itemList);
				} else if (result.indexOf(arr[pos][i].split("")[0]) == -1) {
					getCombinationNumber(arr, pos + 1, totalLength, result + arr[pos][i], itemList);
				}
			}
		} else {
			itemList.add(result);
		}
	}

	public static List<String> getTsuShiuanBauDanNumber(String betNum, int digit) {
		List<String> tempList = new ArrayList<String>();
		addPreAndAfter(betNum, 0, digit - 1, tempList);
		tempList = trimRepeatItem(tempList);

		String removeStr = "";
		for (int i = 0; i < digit; i++) {
			removeStr = removeStr + betNum;
		}
		tempList.remove(removeStr);
		List<String> resultList = new ArrayList<String>();
		for (String tempItem : tempList) {
			resultList.addAll(getCombinationPermutation(tempItem.split("")));
		}
		return resultList;
	}

	public static List<String> getBuDingWeiPermutation(String[] rows, int digit, int starDigit) {
		List<String> resultList = new ArrayList<String>();
		List<String> betItemCombination = new ArrayList<String>();
		String[][] cols = new String[digit][];
		for (int i = 0; i < digit; i++) {
			cols[i] = rows.clone();
		}
		getCombinationNumber(cols, 0, digit, "", betItemCombination);
		betItemCombination = trimRepeatItem(betItemCombination);
		for (String item : betItemCombination) {
			List<String> tempList = new ArrayList<String>();
			addPreAndAfter(item, 0, starDigit - digit, tempList);
			tempList = trimRepeatItem(tempList);
			for (String tempItem : tempList) {
				resultList.addAll(getCombinationPermutation(tempItem.split("")));
			}
		}
		return resultList;
	}

	public static List<String> getDaShiauDanShuang(String[][] rowcols) {
		List<String> resultList = new ArrayList<String>();
		List<String> betItemList = new ArrayList<String>();
		betItemPermutation(rowcols, 0, "", betItemList);
		for (String betItem : betItemList) {
			List<String> tempList = new ArrayList<String>();
			String[][] numArrays = new String[rowcols.length][];
			String[] itemArray = betItem.split("");
			for (int i = 0; i < itemArray.length; i++) {
				numArrays[i] = ((String) SSCConfig.DaShiauDanShuang.get(itemArray[i])).split(",");
			}
			betItemPermutation(numArrays, 0, "", tempList);
			resultList.addAll(tempList);
		}
		return resultList;
	}

	public static List<String> getChiuWei(String[] arr, int count, int starCount) {
		List<String> resultList = new ArrayList<String>();
		int j;
		for (int i = 0; i < arr.length; i++) {
			List<String> tempList = new ArrayList<String>();
			String item = "";
			for (j = 0; j < count; j++) {
				item = item + arr[i];
			}
			addPreAndAfter(item, 0, starCount - count, tempList);
			tempList = trimRepeatItem(tempList);
			for (String tempItem : tempList) {
				resultList.addAll(getCombinationPermutation(tempItem.split("")));
			}
		}
		return resultList;
	}
	
	/**
	 * longPos	龙位数 
	 * nuPos	虎位数
	 * 万: 1, 千: 2, 百: 3, 十: 4, 个: 5
	 */
	public static List<String> getLongHuDou(String betItem, int longPos, int huPos) {
		List<String> resultList = new ArrayList<String>();
		List<Integer[]> numbersList = SSCConfig.SSCLongHuDou.get(betItem);
		int digitLeft = longPos - 1; // 龙左边的位数
		int digitRight = 5 - huPos; // 虎右边的位数
		int midDigit = 3 - (digitLeft + digitRight); // 龙虎中间夹的位数
		
		for(Integer[] longHuNumbers : numbersList) {
			addPreAndAfterForLongHuDou(longHuNumbers[0].toString(), longHuNumbers[1].toString(), digitLeft, midDigit, digitRight, resultList);
		}
		return resultList;
	}

	/**
	 *	任選直選系列
	 * 	betItems 	投注內容
	 * 	digit		任選位數
	 * 	nuPos		虎位数
	 */
	public static List<String> getRenXuanZhiXuan(String[][] betItems, int digit){
		List<String> result = new ArrayList<String>();
		
		// 整理那些位數有被投注
		String betPos = ""; 
		for(int i = 1; i <= 5; i++) {
			if(!"-".equals(betItems[i - 1][0])) { // FIXME 暫時先假定未投注的位數會傳"-"過來
				betPos += i;
			}
		}
		String[] betPosArray = betPos.split("");
		List<String> temp = new ArrayList<String>();
		List<String[]> posConbineResult = new ArrayList<String[]>();
		
		// 取得下注位數的組合
		AwardNumberGenerateUtils.combination(betPosArray, 0, temp, digit, posConbineResult);
		
		String source = "0123456789";
		String[][] betData = new String[5][];
		for(String[] posCombine : posConbineResult) {
			for(int i = 0; i <= 4; i++) {
				if(Arrays.asList(posCombine).contains(i + 1 + "")) {
					betData[i] = betItems[i];
				}else {
					betData[i] = source.split("");
				}
			}
			AwardNumberGenerateUtils.betItemPermutation(betData, 0, "", result);
		}
		
		return result;
	}
	
	
	public static List<String> getCombinationPermutation(String[] data) {
		return getCombinationPermutation(data, "");
	}

	public static List<String> getCombinationPermutation(String[] data, String joinPattern) {
		List<String> resultList = new ArrayList<String>();
		do {
			resultList.add(StringUtils.join(data, joinPattern));
		} while (permuteLexically(data));
		return resultList;
	}

	public static boolean permuteLexically(String[] data) {
		int k = data.length - 2;
		while (data[k].compareTo(data[(k + 1)]) >= 0) {
			k--;
			if (k < 0) {
				return false;
			}
		}
		int l = data.length - 1;
		while (data[k].compareTo(data[l]) >= 0) {
			l--;
		}
		swap(data, k, l);
		int length = data.length - (k + 1);
		for (int i = 0; i < length / 2; i++) {
			swap(data, k + 1 + i, data.length - i - 1);
		}
		return true;
	}

	public static void swap(String[] dataArray, int left, int right) {
		String temp = dataArray[left];
		dataArray[left] = dataArray[right];
		dataArray[right] = temp;
	}

	public static List<String> getCombinationPermutation(Integer[] data) {
		return getCombinationPermutation(data, "");
	}

	public static List<String> getCombinationPermutation(Integer[] data, String joinPattern) {
		List<String> resultList = new ArrayList<String>();
		do {
			resultList.add(StringUtils.join(data, joinPattern));
		} while (permuteLexically(data));
		return resultList;
	}

	public static boolean permuteLexically(Integer[] data) {
		int k = data.length - 2;
		while (data[k].compareTo(data[(k + 1)]) >= 0) {
			k--;
			if (k < 0) {
				return false;
			}
		}
		int l = data.length - 1;
		while (data[k].compareTo(data[l]) >= 0) {
			l--;
		}
		swap(data, k, l);
		int length = data.length - (k + 1);
		for (int i = 0; i < length / 2; i++) {
			swap(data, k + 1 + i, data.length - i - 1);
		}
		return true;
	}

	public static void swap(Integer[] dataArray, int left, int right) {
		Integer temp = dataArray[left];
		dataArray[left] = dataArray[right];
		dataArray[right] = temp;
	}

	public static List<String> trimRepeatItem(List<String> itemList) {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < itemList.size(); i++) {
			String[] tempArray = ((String) itemList.get(i)).split("");
			Arrays.sort(tempArray);
			String item = StringUtils.join(tempArray);
			if (!tempList.contains(item)) {
				tempList.add(item);
			}
		}
		return tempList;
	}

	public static void Combination(String[] arr, int pos, int max, String prefix, String split,
			List<String> resultarr) {
		if (prefix.length() == max) {
			resultarr.add(prefix);
		} else {
			for (int i = pos; i < arr.length; i++) {
				Combination(arr, i + 1, max, prefix + (prefix.length() <= 0 ? "" : split) + arr[i], split, resultarr);
			}
		}
	}

	public static int getCombinationCount(int source, int get) {
		int result = 0;
		BigDecimal numerator = new BigDecimal(1);
		BigDecimal divisor = new BigDecimal(1);
		for (int i = 0; i < get; i++) {
			numerator = numerator.multiply(new BigDecimal(source - i));
			divisor = divisor.multiply(new BigDecimal(i + 1));
		}
		result = numerator.divide(divisor).intValue();
		return result;
	}

	public static int getFactorial(int factorialNum) {
		int result = 1;
		for (int i = factorialNum; i > 0; i--) {
			result *= i;
		}
		return result;
	}
}
