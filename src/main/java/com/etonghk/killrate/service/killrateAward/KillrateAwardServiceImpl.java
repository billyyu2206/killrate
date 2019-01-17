package com.etonghk.killrate.service.killrateAward;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.dao.KillrateAwardDao;
import com.etonghk.killrate.domain.GameIssue;
import com.etonghk.killrate.domain.KillrateAward;

@Service
public class KillrateAwardServiceImpl implements KillrateAwardService{
	
	@Autowired
	private KillrateAwardDao killrateAwardDao;
	
	@Autowired
	private GameIssueDao gameIssueDao;
	
	/**
	 * 	取得殺率設定獎期
	 * 	@param KillrateAward.gameId
	 * 	@param KillrateAward.issueEndDate
	 */
	@Override
	public List<KillrateAward> selectForSettingPage(KillrateAward cond) {
		return killrateAwardDao.selectForSettingPage(cond);
	}
	
	/**
	 * 	生成殺率設定獎期
	 * 	@param KillrateAward.gameId
	 * 	@param KillrateAward.issueEndDate
	 */
	@Override
	public int generateKillrateAward(KillrateSetting setting) {
		//FIXME issue 跟 startTime endTime判斷
		List<GameIssue> matchGameIssues = gameIssueDao.selectForGenerateKillrate(setting);
		if(matchGameIssues == null || matchGameIssues.size() == 0){
			return 0;
		}
		
		List<KillrateAward> existKillrateAward = killrateAwardDao.selectForGenerateKillrate(setting);
		List<String> existsIssueList = existKillrateAward.stream()
										.map(KillrateAward::getIssue)
										.collect(Collectors.toList());
		
		
		
		List<KillrateAward> insertList = new ArrayList<KillrateAward>();
		KillrateAward insertData = new KillrateAward();
		// 整理需要新增的清單
		for(GameIssue issueData : matchGameIssues) {
			if(!existsIssueList.contains(issueData.getFullIssue())) {
				insertData = new KillrateAward();
				insertData.setAwardNumber("");
				insertData.setGameId(setting.getGameId());
				insertData.setIssue(issueData.getFullIssue());
				insertData.setIssueEndTime(issueData.getIssueEndTime());
				insertData.setKillrate(setting.getKillrate());
				insertData.setIsPush(0);
				insertList.add(insertData);
			}
		}
		
		if(insertList != null || insertList.size() > 0) {
			killrateAwardDao.batchInsert(insertList);
		}
		return 0;
	}

	

}
