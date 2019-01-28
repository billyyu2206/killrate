package com.etonghk.killrate.system;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.cache.key.RedisHashField;
import com.etonghk.killrate.cache.key.RedisKey;

/**
 * @author Ami.Tsai
 * @date 2019年1月28日
 */
@Configuration
public class ServerStartInitialize {

	@Autowired
	private RedisCache cache;
	
	//註冊服務
	@PostConstruct
	public void initServerSize() throws UnknownHostException {
		cache.hset(RedisKey.getServerCount(), RedisHashField.getServerIpPortField(), 1);
	}
}
