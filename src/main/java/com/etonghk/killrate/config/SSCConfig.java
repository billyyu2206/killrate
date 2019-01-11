package com.etonghk.killrate.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.etonghk.killrate.killerUtils.AwardNumberGenerateUtils;


public class SSCConfig {
	public static final String DA = "5,6,7,8,9";
	public static final String SHIAU = "0,1,2,3,4";
	public static final String DAN = "1,3,5,7,9";
	public static final String SHUANG = "0,2,4,6,8";
	public static final Map<String, String> DaShiauDanShuang = new HashMap<String, String>();
	public static final Map<String, String> SSC3HGBAUTZ = new HashMap<String, String>();
	public static final Map<String, String> SSC2HGPAIR = new HashMap<String, String>();
	public static final Map<String, String> SSC3HG = new HashMap<String, String>();
	public static final Map<String, String> SSC2HG = new HashMap<String, String>();
	public static final Map<String, String> SSC3KuaDu = new HashMap<String, String>();
	public static final Map<String, String> SSC2KuaDu = new HashMap<String, String>();
	public static final Map<String, List<Integer[]>> SSCLongHuDou = new HashMap<String, List<Integer[]>>();
	public static final Map<String, List<Integer[]>> SSC5HG = new HashMap<String, List<Integer[]>>(); // 和值大小单双
	public static final List<String> allDataList = new ArrayList<String>();

	public static final String[] itemSource = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	static {
		SSCConfig.DaShiauDanShuang.put("大", "5,6,7,8,9");
		SSCConfig.DaShiauDanShuang.put("小", "0,1,2,3,4");
		SSCConfig.DaShiauDanShuang.put("单", "1,3,5,7,9");
		SSCConfig.DaShiauDanShuang.put("双", "0,2,4,6,8");
		
		SSCConfig.SSC3HGBAUTZ.put("0", "000");
		SSCConfig.SSC3HGBAUTZ.put("3", "111");
		SSCConfig.SSC3HGBAUTZ.put("6", "222");
		SSCConfig.SSC3HGBAUTZ.put("9", "333");
		SSCConfig.SSC3HGBAUTZ.put("12", "444");
		SSCConfig.SSC3HGBAUTZ.put("15", "555");
		SSCConfig.SSC3HGBAUTZ.put("18", "666");
		SSCConfig.SSC3HGBAUTZ.put("21", "777");
		SSCConfig.SSC3HGBAUTZ.put("24", "888");
		SSCConfig.SSC3HGBAUTZ.put("27", "999");
		
		SSCConfig.SSC2HGPAIR.put("0", "00");
		SSCConfig.SSC2HGPAIR.put("2", "11");
		SSCConfig.SSC2HGPAIR.put("4", "22");
		SSCConfig.SSC2HGPAIR.put("6", "33");
		SSCConfig.SSC2HGPAIR.put("8", "44");
		SSCConfig.SSC2HGPAIR.put("10", "55");
		SSCConfig.SSC2HGPAIR.put("12", "66");
		SSCConfig.SSC2HGPAIR.put("14", "77");
		SSCConfig.SSC2HGPAIR.put("16", "88");
		SSCConfig.SSC2HGPAIR.put("18", "99");
		
		
		List<Integer[]> longList = new ArrayList<Integer[]>();
		List<Integer[]> huList = new ArrayList<Integer[]>();
		List<Integer[]> herList = new ArrayList<Integer[]>();
		for(int i = 0; i <= 9; i++) {
			for(int j = 0; j <= 9; j++) {
				if(i > j) {
					longList.add(new Integer[]{i,j});
				}else if(i == j) {
					herList.add(new Integer[]{i,j});
				}else { // i < j
					huList.add(new Integer[]{i,j});
				}
			}
		}
		SSCConfig.SSCLongHuDou.put("龙", longList);
		SSCConfig.SSCLongHuDou.put("虎", huList);
		SSCConfig.SSCLongHuDou.put("和", herList);
		
		List<Integer[]> daList = new ArrayList<Integer[]>();
		List<Integer[]> shiauList = new ArrayList<Integer[]>();
		List<Integer[]> danList = new ArrayList<Integer[]>();
		List<Integer[]> shuangList = new ArrayList<Integer[]>();
		int sumVal = 0;
		for (int i3 = 0; i3 <= 9; ++i3) {
			for (int j3 = i3; j3 <= 9; ++j3) {
				for (int k3 = j3; k3 <= 9; ++k3) {
					for (int l3 = k3; l3 <= 9; ++l3) {
						for (int m3 = l3; m3 <= 9; ++m3) {
							sumVal = i3 + j3 + k3 + l3 + m3;
							if(sumVal >= 23) {
								daList.add(new Integer[] {i3, j3, k3, l3, m3});
							}else { //sumVal <= 22
								shiauList.add(new Integer[] {i3, j3, k3, l3, m3});
							}
							
							if(sumVal % 2 == 1) {
								danList.add(new Integer[] {i3, j3, k3, l3, m3});
							}else { // sumVal % 2 == 0
								shuangList.add(new Integer[] {i3, j3, k3, l3, m3});
							}
							
						}
					}
				}
			}
		}
		SSCConfig.SSC5HG.put("大", daList);
		SSCConfig.SSC5HG.put("小", shiauList);
		SSCConfig.SSC5HG.put("单", danList);
		SSCConfig.SSC5HG.put("双", shuangList);
		
		for (int sum = 0; sum <= 27; ++sum) {
			for (int i = 0; i <= 9 && i <= sum; ++i) {
				for (int j = 0; j <= 9 && i + j <= sum; ++j) {
					for (int k = 0; k <= 9 && i + j + k <= sum; ++k) {
						if (i + j + k == sum) {
							if (SSCConfig.SSC3HG.containsKey(sum + "")) {
								SSCConfig.SSC3HG.put(sum + "", SSCConfig.SSC3HG.get(sum + "") + "," + i + j + k);
							} else {
								SSCConfig.SSC3HG.put(sum + "", "" + i + j + k);
							}
						}
					}
				}
			}
		}
		
		for (int sum = 0; sum <= 18; ++sum) {
			for (int i = 0; i <= 9 && i <= sum; ++i) {
				for (int j = 0; j <= 9 && i + j <= sum; ++j) {
					if (i + j == sum) {
						if (SSCConfig.SSC2HG.containsKey(sum + "")) {
							SSCConfig.SSC2HG.put(sum + "", SSCConfig.SSC2HG.get(sum + "") + "," + i + j);
						} else {
							SSCConfig.SSC2HG.put(sum + "", "" + i + j);
						}
					}
				}
			}
		}
		
		for (int diff = 0; diff <= 9; ++diff) {
			final List<String> resultList = new ArrayList<String>();
			String value = "";
			for (int min = 0; min <= 9 - diff; ++min) {
				for (int max = diff + min, l = min; l <= max; ++l) {
					resultList.add("" + min + l + max);
				}
			}
			for (int size = resultList.size(), m = 0; m < size; ++m) {
				AwardNumberGenerateUtils.getCombinationPermutation(resultList.get(m), 0, resultList.get(m).length(), "",
						resultList);
			}
			value = StringUtils.join(resultList.toArray(), ",");
			SSCConfig.SSC3KuaDu.put(diff + "", value);
		}
		
		
		for (int diff = 0; diff <= 9; ++diff) {
			final List<String> resultList = new ArrayList<String>();
			String value = "";
			for (int min = 0; min <= 9 - diff; ++min) {
				final int max = diff + min;
				resultList.add("" + min + max);
			}
			for (int size = resultList.size(), m = 0; m < size; ++m) {
				AwardNumberGenerateUtils.getCombinationPermutation(resultList.get(m), 0, resultList.get(m).length(), "",
						resultList);
			}
			value = StringUtils.join(resultList.toArray(), ",");
			SSCConfig.SSC2KuaDu.put(diff + "", value);
		}
		
		
		for (int i2 = 0; i2 <= 9; ++i2) {
			for (int j2 = 0; j2 <= 9; ++j2) {
				for (int k2 = 0; k2 <= 9; ++k2) {
					for (int l2 = 0; l2 <= 9; ++l2) {
						for (int m2 = 0; m2 <= 9; ++m2) {
							SSCConfig.allDataList.add("" + i2 + j2 + k2 + l2 + m2);
						}
					}
				}
			}
		}
	}
}