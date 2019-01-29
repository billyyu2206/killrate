package com.etonghk.killrate.service.awardsample.memory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.domain.AwardSample;
import com.etonghk.killrate.service.awardsample.AwardSampleService;
import com.etonghk.killrate.service.enums.MemoryEnum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
@Component
public class AwardSampleMemory {
	
	Gson gson = new Gson();
	
	@Autowired
	private AwardSampleService awardSampleService;
	
	@Autowired
	private RedisCache redisCache;
	
	private Map<String , AwardSample> awardSampleMap = new HashMap<String , AwardSample>();
	
	public AwardSample getAwardSampleByKey(String key) {
		if(awardSampleMap == null || awardSampleMap.size() <= 0) {
			resetMemoryData();
		}
		return awardSampleMap.get(key);
	}
	
	public Map<String , AwardSample> getAll(){
		return awardSampleMap;
	}
	
	@PostConstruct
	public void resetMemoryData() {
		Object redisObj = redisCache.getObj(MemoryEnum.AwardSample.getRedisKey());
		if(redisObj == null) {
			resetRedisData();
		}else {
			String dataJson = (String) redisObj;
			Type type = new TypeToken<Map<String, AwardSample>>(){}.getType();
			awardSampleMap = gson.fromJson(dataJson, type);
		}
	}
	
	private Map<String , AwardSample> getDataFromDB() {
		return awardSampleService.getResetMemoryData();
	}

	public void resetRedisData() {
		awardSampleMap = getDataFromDB();
		redisCache.putObj(MemoryEnum.AwardSample.getRedisKey(), gson.toJson(awardSampleMap), 35, TimeUnit.MINUTES);
	}
}
