/**
 * 
 */
package com.etonghk.killrate.service.resetmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.service.killrateaward.memory.KillrateAwardMomery;
import com.etonghk.killrate.vo.MemoryRefreshVo;

/**
 * @author Billy.Yu
 * @date 2019年1月28日
 */
@Service
public class ResetMemoryServiceImpl implements ResetMemoryService{

	@Autowired
	private KillrateAwardMomery killrateAwardMomery;
	
	@Override
	public void resetMemory(MemoryRefreshVo memoryRefreshVo) {
		String memoryName = memoryRefreshVo.getMemoryName();
		switch (memoryName) {
		case "killrate_award":
			killrateAwardMomery.resetMemoryData();
			break;
		default:
			break;
		}
	}

}
