package com.etonghk.killrate.awardSample.cache.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.awardSample.cache.AwardSampleCache;
import com.etonghk.killrate.dao.AwardSampleDao;
import com.etonghk.killrate.domain.AwardSample;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
@Service
public class AwardSampleCacheServiceImpl implements AwardSampleCacheService{
	
	@Autowired
	private AwardSampleDao awardSampleDao;
	
	
	/**
	 * 	抓取塞進cache資料
	 */
	@Override
	public Map<String, AwardSample> getResetCacheData() {
		List<AwardSample> datas = awardSampleDao.selectAll();
		Map<String, AwardSample> result = new HashMap<String, AwardSample>();
		for(AwardSample data : datas) {
			String key = data.getGameType() + ":" + data.getGamePlayId() + ":" + data.getType();
			result.put(key, data);
		}
		return result;
	}
	
}