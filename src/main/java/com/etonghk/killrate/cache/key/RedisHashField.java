package com.etonghk.killrate.cache.key;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.system.utils.ApplicationInfoService;

/**
 * @author Ami.Tsai
 * @date 2019年1月28日
 */
@Component
public class RedisHashField {
	
	@Autowired
	private ApplicationInfoService applicationInfoService;
	
	/**
	 * server info
	 * @return
	 * @throws UnknownHostException
	 */
	public String getServerIpPortField() throws UnknownHostException {
		return applicationInfoService.getIp()+"-"+applicationInfoService.getPort();
	}
}
