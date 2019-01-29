/**
 * 
 */
package com.etonghk.killrate.service.killrateaward.memory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.service.enums.MemoryEnum;
import com.etonghk.killrate.service.killrateaward.KillrateAwardService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Component
public class KillrateAwardMemory {

	Gson gson = new Gson();
	
	@Autowired
	private KillrateAwardService killrateAwardService;
	
	@Autowired
	private RedisCache redisCache;
	
	private Map<String , KillrateAward> killrateAwardMap = new HashMap<String , KillrateAward>();
	
	public KillrateAward getKillrateAwardByKey(String key) {
		if(killrateAwardMap == null) {
			resetMemoryData();
		}
		return killrateAwardMap.get(key);
	}
	
	public Map<String , KillrateAward> getAll(){
		return killrateAwardMap;
	}
	
	@PostConstruct
	public void resetMemoryData() {
		Object redisObj = redisCache.getObj(MemoryEnum.KillrateAward.getRedisKey());
		if(redisObj == null) {
			resetRedisData();
		}else {
			String dataJson = (String) redisObj;
			Type type = new TypeToken<Map<String, KillrateAward>>(){}.getType();
			killrateAwardMap = gson.fromJson(dataJson, type);
		}
	}
	
	private Map<String , KillrateAward> getDataFromDB() {
		return killrateAwardService.getRefreshMemoryData();
	}

	public void resetRedisData() {
		killrateAwardMap = getDataFromDB();
		redisCache.putObj(MemoryEnum.KillrateAward.getRedisKey(), gson.toJson(killrateAwardMap), 35, TimeUnit.MINUTES);
	}
}
