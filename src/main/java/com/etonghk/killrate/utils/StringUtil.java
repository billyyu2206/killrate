package com.etonghk.killrate.utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	public static String padLeft(String source, final String flag, final int length) {
		if (source == null || flag == null || flag.equals("") || length <= source.length()) {
			return source;
		}
		for (int i = 0; i <= length - source.length(); source = flag.substring(0, 1) + source, ++i) {
		}
		return source;
	}
	
	public static String join(String str,String separator) {
		return str = StringUtils.join(str.split(""),separator);
	}
}
