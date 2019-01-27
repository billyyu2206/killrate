package com.etonghk.killrate.service.killratenumber;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.controller.dto.response.AwardNumberResponse;
import com.etonghk.killrate.dao.GameIssueDao;
import com.etonghk.killrate.dao.KillrateAwardDao;
import com.etonghk.killrate.domain.GameIssue;
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
	public ApiResult<AwardNumberResponse> getKillRateAward(String lottery, String issue) throws ServiceException{
		ApiResult<AwardNumberResponse> result = new ApiResult<>();
		result.setCode(ApiResult.FAILD_CODE);		
		KillrateAward killrateAward = killrateAwardDao.selectForCalNumber(lottery, issue);
		if(killrateAward==null) {
			result.setMsg("本期无杀率设定");
		}else{
			if(StringUtils.isEmpty(killrateAward.getAwardNumber())) {
				GameIssue lotteryIssue = gameIssueDao.selectIssueByLotteryAndIssue(lottery, issue);
				if(lotteryIssue.getIssueEndTime().isAfter(LocalDateTime.now())) {
					result.setMsg("奖期时间尚未截止,不可提早取号");
				}else{
					result.setMsg("奖号尚未开出");
				}
			}else {
				AwardNumberResponse response = new AwardNumberResponse();
				response.setAwardNumber(killrateAward.getAwardNumber());
				response.setIssue(issue);
				response.setLottery(lottery);
				response.setOpenTime(LocalDateTime.now());
				result.setData(response);
				result.setCode(ApiResult.SUCCESS_CODE);		
				result.setMsg(ApiResult.SUCCESS_MSG);	
			}
		}
		return result;
	}

}
