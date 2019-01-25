package com.etonghk.killrate.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.etonghk.killrate.domain.Account;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
public class RequestUtils {
	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("WL-Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getRemoteAddr();
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public static String getFisrtRemoteHost(HttpServletRequest request) {
		String ip = getRemoteHost(request);
		if (ip != null) {
			String[] array = ip.split(",");
			if (array.length > 0) {
				ip = array[0];
			}
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	public static Account getSessoinAccount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute(session.getId());
		return acc;
	}
}
