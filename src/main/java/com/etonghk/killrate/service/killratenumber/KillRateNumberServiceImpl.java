package com.etonghk.killrate.service.killratenumber;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.controller.dto.response.AwardNumberResponse;
import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.dao.KillrateAwardDao;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.exception.ServiceException;

/**
 * @author Ami.Tsai
 * @date 2019年1月25日
 */
@Service
public class KillRateNumberServiceImpl implements KillRateNumberService {

	@Autowired
	private KillrateAwardDao killrateAwardDao;
	
	@Autowired
	private GameIssueDao gameIssueDao;
	
	/* (non-Javadoc)
	 * @see com.etonghk.killrate.service.killratenumber.KillRateNumberService#getKillRateAward(java.lang.String, java.lang.String)
	 */
	@Override
	public AwardNumberResponse getKillRateAward(String lottery, String issue) throws ServiceException{
		
		AwardNumberResponse response = new AwardNumberResponse();
		KillrateAward killrateAward = killrateAwardDao.selectForCalNumber(lottery, issue);
		
		if(killrateAward==null) {
			
		}else{
			response.setAwardNumber(killrateAward.getAwardNumber());
			response.setIssue(issue);
			response.setLottery(lottery);
			response.setOpenTime(new Date());
		}
		
		return response;
	}

}
