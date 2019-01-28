package com.etonghk.killrate.service.awardsample.memory;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.domain.AwardSample;
import com.etonghk.killrate.service.awardsample.AwardSampleService;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
@Component
public class AwardSampleMemory {
	
	@Autowired
	private AwardSampleService awardSampleService;
	
	private Map<String , AwardSample> awardSampleMap = new HashMap<String , AwardSample>();
	
	public AwardSample getAwardSampleByKey(String key) {
		if(awardSampleMap == null || awardSampleMap.size() <= 0) {
			resetMemoryData();
		}
		return awardSampleMap.get(key);
	}
	
	
	@PostConstruct
	public void resetMemoryData() {
		awardSampleMap = awardSampleService.getResetMemoryData();
	}
}
