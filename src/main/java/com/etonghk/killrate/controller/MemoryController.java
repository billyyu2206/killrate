package com.etonghk.killrate.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.properties.config.IpWhiteListProperties;
import com.etonghk.killrate.service.resetmemory.ResetMemoryService;
import com.etonghk.killrate.utils.RequestUtils;
import com.etonghk.killrate.vo.MemoryRefreshVo;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
@RestController
@RequestMapping("/memory")
public class MemoryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IpWhiteListProperties ipWhiteListProperties;
	
	@Autowired
	ResetMemoryService resetMemoryService;
	
	@RequestMapping("/reset")
	public ApiResult<Void> resetMemoryData(MemoryRefreshVo memoryRefreshVo, HttpServletRequest request) {
		ApiResult<Void> result = new ApiResult<Void>();
		String ipListStr = ipWhiteListProperties.getConfigValue("ip.white.cache.reset");
		if(checkIp(request, ipListStr.split(","))) {
			logger.info("reset memory memoryName{}", memoryRefreshVo.getMemoryName());
			resetMemoryService.resetRedisMemoryData(memoryRefreshVo);
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
