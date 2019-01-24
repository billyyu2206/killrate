package com.etonghk.killrate.service.killrateaward;

import java.util.Date;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardService {
	
	public Page<KillrateAward> selectForSettingPage(KillrateAward cond,Page<KillrateAward> page);
	
	public int generateKillrateAward(KillrateSetting setting);
	
	public int updateKillrateAward(KillrateAward record);
	
	public int deleteKillrateAward(KillrateAward record);

	public Page<KillrateAward> selectForRecord(String lottery, Date issueDate, Boolean isPush, Page<KillrateAward> page);
	
	public KillrateAward calAwardNumber(String lottery, String issue, Boolean isTask);
}
