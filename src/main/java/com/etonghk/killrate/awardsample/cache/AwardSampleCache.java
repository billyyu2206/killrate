package com.etonghk.killrate.awardsample.cache;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.awardsample.cache.service.AwardSampleCacheService;
import com.etonghk.killrate.domain.AwardSample;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
@Component
public class AwardSampleCache {
	
	@Autowired
	private AwardSampleCacheService awardSampleCacheService;
	
	private Map<String , AwardSample> awardSampleMap = new HashMap<String , AwardSample>();
	
	public AwardSample getAwardSampleByKey(String key) {
		if(awardSampleMap == null || awardSampleMap.size() <= 0) {
			resetCacheData();
		}
		return awardSampleMap.get(key);
	}
	
	
	@PostConstruct
	public void resetCacheData() {
		awardSampleMap = awardSampleCacheService.getResetCacheData();
	}
}
