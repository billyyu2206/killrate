/**
 * 
 */
package com.etonghk.killrate.service.resetmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.mq.sender.MemoryRefreshSender;
import com.etonghk.killrate.service.awardsample.memory.AwardSampleMemory;
import com.etonghk.killrate.service.enums.MemoryEnum;
import com.etonghk.killrate.service.gameIssus.memory.GameIssueMemory;
import com.etonghk.killrate.service.killrateaward.memory.KillrateAwardMemory;
import com.etonghk.killrate.vo.MemoryRefreshVo;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Service
public class ResetMemoryServiceImpl implements ResetMemoryService{

	@Autowired
	private KillrateAwardMemory killrateAwardMomery;
	
	@Autowired
	private AwardSampleMemory awardSampleMemory;
	
	@Autowired
	private GameIssueMemory gameIssueMemory;
	
	@Autowired
	private MemoryRefreshSender memoryRefreshSender;
	
	@Override
	public void resetMemory(MemoryRefreshVo memoryRefreshVo) {
		String memoryName = memoryRefreshVo.getMemoryName();
		if(MemoryEnum.KillrateAward.getMemoryName().contentEquals(memoryName)) {
			killrateAwardMomery.resetMemoryData();
		}else if(MemoryEnum.AwardSample.getMemoryName().contentEquals(memoryName)) {
			awardSampleMemory.resetMemoryData();
		}else if(MemoryEnum.GameIssue.getMemoryName().contentEquals(memoryName)) {
			gameIssueMemory.resetMemoryData();
		}
	}

	@Override
	public void resetRedisMemoryData(MemoryRefreshVo memoryRefreshVo) {
		String memoryName = memoryRefreshVo.getMemoryName();
		if(MemoryEnum.KillrateAward.getMemoryName().contentEquals(memoryName)) {
			killrateAwardMomery.resetRedisData();
		}else if(MemoryEnum.AwardSample.getMemoryName().contentEquals(memoryName)) {
			awardSampleMemory.resetRedisData();
		}else if(MemoryEnum.GameIssue.getMemoryName().contentEquals(memoryName)) {
			gameIssueMemory.resetRedisData();
		}
		memoryRefreshSender.sendMemoryRefresh(memoryRefreshVo);
	}
	

}
