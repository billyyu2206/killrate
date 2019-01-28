package com.etonghk.killrate.awardsample;

import java.util.Map;

import com.etonghk.killrate.domain.AwardSample;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public interface AwardSampleCacheService {
	public Map<String , AwardSample> getResetCacheData();
}
