package com.etonghk.killrate.controller.convert;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**字串轉換日期
 * @author Ami.Tsai
 * @date 2019年1月17日
 */
public class StringToDateConverter implements Converter<String, LocalDateTime> {

	private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
	private static final String shortDateFormat = "yyyy-MM-dd";
	private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
	private static final String shortDateFormat2 = "yyyy/MM/dd";

	@Override
	public LocalDateTime convert(String source) {
		if (StringUtils.isBlank(source)) {
			return null;
		}
		source = source.trim();
		try {
			Date dtDate = null;
			SimpleDateFormat formatter;
			if (source.contains("-")) {
				if (source.contains(":")) {
					formatter = new SimpleDateFormat(dateFormat);
				} else {
					formatter = new SimpleDateFormat(shortDateFormat);
				}
				dtDate = formatter.parse(source);
			} else if (source.contains("/")) {
				if (source.contains(":")) {
					formatter = new SimpleDateFormat(dateFormat2);
				} else {
					formatter = new SimpleDateFormat(shortDateFormat2);
				}
				dtDate = formatter.parse(source);
			}
			return dtDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			
		} catch (Exception e) {
			throw new RuntimeException(String.format("parser %s to Date fail", source));
		}
	}
}
