package com.etonghk.killrate.mq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.mq.config.MemoryRefreshMqConfig;
import com.etonghk.killrate.vo.MemoryRefreshVo;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Component
public class MemoryRefreshSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 發送緩存刷新訊息
     * @param MemoryRefreshVo
     */
    public void sendMemoryRefresh(MemoryRefreshVo memoryRefreshVo) {
    	logger.info("memory refresh send memoryName={} => ", memoryRefreshVo.getMemoryName());
    	rabbitTemplate.convertAndSend(MemoryRefreshMqConfig.MEMORY_REFRESH_EXCHANGE, "", memoryRefreshVo);
    }
	
}
