package com.etonghk.killrate.service.killrateAward;

import java.util.List;
import java.util.Map;

import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardService {
	
	public List<KillrateAward> selectForSettingPage(Map<String, Object> cond);
	public int insertKillrateAward(KillrateAward killrateAward);
	public int batchInsertKillrateAward(List<KillrateAward> killrateAward);
}
