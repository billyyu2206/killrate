package com.etonghk.killrate.service.killrateAward;

import java.util.List;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardService {
	
	public List<KillrateAward> selectForSettingPage(KillrateAward cond);
	
	public int generateKillrateAward(KillrateSetting setting);
	
	public int updateKillrateAward(KillrateAward record);
	
	public int deleteKillrateAward(KillrateAward record);
}
