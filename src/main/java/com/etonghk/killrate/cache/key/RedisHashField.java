package com.etonghk.killrate.cache.key;

import java.net.UnknownHostException;

import org.springframework.stereotype.Component;

import com.etonghk.killrate.system.utils.ApplicationInfoUtil;

/**
 * @author Ami.Tsai
 * @date 2019年1月28日
 */
@Component
public class RedisHashField {
	
	/**
	 * server info
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getServerIpPortField() throws UnknownHostException {
		return ApplicationInfoUtil.getIp()+"-"+ApplicationInfoUtil.getPort();
	}
}
