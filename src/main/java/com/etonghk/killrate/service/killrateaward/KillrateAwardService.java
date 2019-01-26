package com.etonghk.killrate.service.killrateaward;

import java.time.LocalDateTime;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardService {
	
	public Page<KillrateAward> selectForSettingPage(KillrateAward cond,Page<KillrateAward> page);
	
	public int generateKillrateAward(KillrateSetting setting, Account account);
	
	public int updateKillrateAward(KillrateAward record, Account account);
	
	public int deleteKillrateAward(KillrateAward record, Account account);

	public Page<KillrateAward> selectForRecord(String lottery, LocalDateTime issueDate, Boolean isPush, Page<KillrateAward> page);
	
	public KillrateAward calAwardNumber(String lottery, String issue, Boolean isTask);
}
