package com.etonghk.killrate.service.killrateSettingLog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.controller.dto.request.KillrateSettingLogRequest;
import com.etonghk.killrate.dao.KillrateSettingLogDao;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateSettingLog;

/**
 * @author Billy.Yu
 * @date 2019年1月23日
 */
@Service
public class KillrateSettingLogServiceImpl implements KillrateSettingLogService{

	@Autowired
	private KillrateSettingLogDao killrateSettingLogDao;
	
	@Override
	public Page<KillrateSettingLog> selectForPage(KillrateSettingLogRequest cond, Page<KillrateSettingLog> page) {
		List<KillrateSettingLog> result = killrateSettingLogDao.selectByCond(cond, page);
		page.setRecords(result);
		return page;
	}

}
