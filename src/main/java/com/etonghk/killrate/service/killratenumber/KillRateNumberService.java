package com.etonghk.killrate.service.killratenumber;

import com.etonghk.killrate.controller.dto.response.AwardNumberResponse;
import com.etonghk.killrate.exception.ServiceException;

/**
 * @author Ami.Tsai
 * @date 2019年1月25日
 */
public interface KillRateNumberService {
	
	AwardNumberResponse getKillRateAward(String lottery,String issue) throws ServiceException;
}
