package com.etonghk.killrate.mq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.CacheRefreshMqConfig;
import com.etonghk.killrate.vo.CacheRefreshVo;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Component
public class CacheRefreshSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 發送緩存刷新訊息
     * @param CacheRefreshVo
     */
    public void sendCacheRefresh(CacheRefreshVo cacheRefreshVo) {
    	logger.info("cache refresh send cacheName={} => ",cacheRefreshVo.getCacheName());
    	rabbitTemplate.convertAndSend(CacheRefreshMqConfig.CACHE_REFRESH_EXCHANGE, "", cacheRefreshVo);
    }
	
}
