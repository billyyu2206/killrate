/**
 * 
 */
package com.etonghk.killrate.service.killrateaward.memory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.service.killrateaward.KillrateAwardService;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Component
public class KillrateAwardMomery {

	@Autowired
	private KillrateAwardService killrateAwardService;
	
	private LocalDateTime lastUpdateTime = null;
	
	private Map<String , KillrateAward> killrateAwardMap = new HashMap<String , KillrateAward>();
	
	public KillrateAward getKillrateAwardByKey(String key) {
		if(lastUpdateTime == null || lastUpdateTime.isBefore(LocalDateTime.now().minusMinutes(30))) {
			resetMemoryData();
		}
		return killrateAwardMap.get(key);
	}
	
	
	@PostConstruct
	public void resetMemoryData() {
		killrateAwardMap = killrateAwardService.getRefreshMemoryData();
		lastUpdateTime = LocalDateTime.now();
	}
}
