/**
 * 
 */
package com.etonghk.killrate.service.gameIssus.memory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.service.enums.MemoryEnum;
import com.etonghk.killrate.service.gameIssus.GameIssueService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Billy.Yu
 * @date 2019年1月29日
 */
@Component
public class GameIssueMemory {

	Gson gson = new Gson();
	
	@Autowired
	private GameIssueService gameIssueService;
	
	@Autowired
	private RedisCache redisCache;
	
	private Map<String , GameIssue> gameIssueMap = new HashMap<String , GameIssue>();
	
	public GameIssue getGameIssueByKey(String key) {
		if(gameIssueMap == null) {
			resetMemoryData();
		}
		return gameIssueMap.get(key);
	}
	
	public Map<String , GameIssue> getAll(){
		return gameIssueMap;
	}
	
	@PostConstruct
	public void resetMemoryData() {
		Object redisObj = redisCache.getObj(MemoryEnum.GameIssue.getRedisKey());
		if(redisObj == null) {
			resetRedisData();
		}else {
			String dataJson = (String) redisObj;
			Type type = new TypeToken<Map<String, GameIssue>>(){}.getType();
			gameIssueMap = gson.fromJson(dataJson, type);
		}
	}
	
	private Map<String , GameIssue> getDataFromDB() {
		return gameIssueService.getRefreshMemoryData();
	}

	public void resetRedisData() {
		gameIssueMap = getDataFromDB();
		redisCache.putObj(MemoryEnum.GameIssue.getRedisKey(), gson.toJson(gameIssueMap), 35, TimeUnit.HOURS);
	}
}
