package com.etonghk.killrate.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonUtils {
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueAsc(Map<K, V> map) {
		return map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
		return map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	public static <T>String[] arrayToStringArray(T[] data) {
		if(data == null || data.length == 0) {
			return null;
		}
		String[] result = new String[data.length];
		for(int i = 0; i < result.length; i ++) {
			result[i] = data[i].toString();
		}
		return result;
	}
	
	public static boolean isRepeat(String[] a) {
		if (a == null) {
			return false;
		}
		Set<String> set = new HashSet<String>();
		for (String str : a) {
			set.add(str);
		}
		if (set.size() != a.length) {
			return true;
		}
		return false;
	}
}