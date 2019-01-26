package com.etonghk.killrate.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.awardsample.cache.AwardSampleCache;
import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.properties.config.IpWhiteListProperties;
import com.etonghk.killrate.utils.RequestUtils;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
	
	@Autowired
	IpWhiteListProperties ipWhiteListProperties;
	
	@Autowired
	AwardSampleCache awardSampleCache;
	
	@RequestMapping("/reset")
	@ResponseBody
	public ApiResult<Void> resetCacheData(HttpServletRequest request) {
		ApiResult<Void> result = new ApiResult<Void>();
		String ipListStr = ipWhiteListProperties.getConfigValue("ip.white.cache.reset");
		if(checkIp(request, ipListStr.split(","))) {
			awardSampleCache.resetCacheData();
			result.setMsg("success");
			result.setCode(ApiResult.SUCCESS_CODE);
		}else {
			result.setMsg("fail");
			result.setCode(ApiResult.FAILD_CODE);
		}
		return result;
	}
	
	private boolean checkIp(HttpServletRequest request, String[] acceptList) {
		boolean result = false;
		String ip = RequestUtils.getRemoteHost(request);
		if(Arrays.asList(acceptList).contains(ip)) {
			result = true;
		}
		return result;
	}
	
}
