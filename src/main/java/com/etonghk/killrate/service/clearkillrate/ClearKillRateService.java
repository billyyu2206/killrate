package com.etonghk.killrate.service.clearkillrate;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Ami.Tsai
 * @date 2019年1月24日
 */
public interface ClearKillRateService {

	void pushClearRateToRedis(Map<String,BigDecimal> awardResult,String lotteryIssueKey);
	
	void doClearRateFinishMark(String lottery,String issue);
	
	void clearFinishCalKillNumber(String lottery,String issue);
	
}