package com.etonghk.killrate.service.killratesettinglog;

import com.etonghk.killrate.controller.dto.request.KillrateSettingLogRequest;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateSettingLog;

/**
 * @author Billy.Yu
 * @date 2019年1月23日
 */
public interface KillrateSettingLogService {
	public Page<KillrateSettingLog> selectForPage(KillrateSettingLogRequest cond, Page<KillrateSettingLog> page);
}
