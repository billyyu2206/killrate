package com.etonghk.killrate.service.killrateAward;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.dao.KillrateAwardDao;
import com.etonghk.killrate.domain.KillrateAward;

@Service
public class KillrateAwardServiceImpl implements KillrateAwardService{
	
	@Autowired
	private KillrateAwardDao killrateAwardDao;
	
	@Override
	public List<KillrateAward> selectForSettingPage(Map<String, Object> cond) {
		return killrateAwardDao.selectForSettingPage(cond);
	}

	@Override
	public int insertKillrateAward(KillrateAward killrateAward) {
		return killrateAwardDao.insert(killrateAward);
	}

	@Override
	public int batchInsertKillrateAward(List<KillrateAward> killrateAward) {
		// TODO Auto-generated method stub
		return 0;
	}

}
