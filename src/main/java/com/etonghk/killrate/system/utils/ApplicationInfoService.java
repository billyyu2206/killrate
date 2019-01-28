package com.etonghk.killrate.system.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Ami.Tsai
 * @date 2019年1月28日
 */
@Service
public class ApplicationInfoService{

	@Autowired
	private Environment environment;
	
	private String ip;
	
	private String port;
	
	public String getIp() throws UnknownHostException {
		if(StringUtils.isEmpty(ip)) {
			InetAddress ipAddress = InetAddress.getLocalHost();			
			ip = ipAddress.getHostAddress();
		}
		return ip;
	}
	
	public String getPort() {
		if(StringUtils.isEmpty(port)) {
			port = environment.getProperty("server.port");
		}
		return port;
	}

}