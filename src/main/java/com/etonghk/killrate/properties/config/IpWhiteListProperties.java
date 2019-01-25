package com.etonghk.killrate.properties.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
@Component
@PropertySource("classpath:ipwhitelist.properties")
public class IpWhiteListProperties {
	@Autowired
    private Environment env;

    public String getConfigValue(String configKey){
        return env.getProperty(configKey);
    }
}
