package com.etonghk.killrate.mq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.cache.key.RedisKey;
import com.etonghk.killrate.mq.config.ClearRateMqConfig;
import com.etonghk.killrate.vo.ClearKillRateVo;

/**
 * @author Ami.Tsai
 * @date 2019年1月23日
 */
@Component
public class ClearKillRateSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
    
	@Autowired
	private RedisCache cache;
	
    /**
            * 寄送Order訂單
     * @param order
     */
    public void sendClearLotteryIssue(ClearKillRateVo clearKillRateVo) {
    	logger.info("clear lottery={},issue={} => ",clearKillRateVo.getLottery(),clearKillRateVo.getIssue());
    	String clearKey = RedisKey.getLotteryIssueClearKey(clearKillRateVo.getLottery(), clearKillRateVo.getIssue());
    	if(cache.getObj(clearKey)==null) {
    		rabbitTemplate.convertAndSend(ClearRateMqConfig.CLEAR_RATE_EXCHANGE,"", clearKillRateVo);
    		cache.putObj(clearKey, "1");
    	}else {
    		return;
    	}
    }
	
}
