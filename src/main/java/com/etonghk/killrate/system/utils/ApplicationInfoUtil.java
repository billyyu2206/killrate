package com.etonghk.killrate.system.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Ami.Tsai
 * @date 2019年1月28日
 */
@Component
public class ApplicationInfoUtil {
	
	public static Environment environment; 

	private static String ip;
	
	private static String port;
	
	public static String getIp() throws UnknownHostException {
		if(StringUtils.isEmpty(ip)) {
			InetAddress ipAddress = InetAddress.getLocalHost();			
			ip = ipAddress.getHostAddress();
		}
		return ip;
	}
	
	public static String getPort() {
		if(StringUtils.isEmpty(port)) {
			port = environment.getProperty("server.port");
		}
		return port;
	}

	@Autowired
	public void setEnvironment(Environment environment) {
		ApplicationInfoUtil.environment = environment;
	}
	
}