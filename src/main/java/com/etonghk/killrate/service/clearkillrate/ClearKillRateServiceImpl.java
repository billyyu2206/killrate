package com.etonghk.killrate.service.clearkillrate;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.cache.key.RedisKey;
import com.etonghk.killrate.service.killrateaward.KillrateAwardService;

/**
 * @author Ami.Tsai
 * @date 2019年1月24日
 */
@Service
public class ClearKillRateServiceImpl implements ClearKillRateService{

	@Autowired
	private KillrateAwardService killrateAwardService;
	
	@Autowired
	private RedisCache cache;
	
	@SuppressWarnings("unchecked")
	@Override
	public void pushClearRateToRedis(Map<String,BigDecimal> awardResult,String lotteryIssueKey) {
		if(awardResult==null) {
			return;
		}else {
			//取出key序列化元件
			RedisSerializer<String> keySerializer = (RedisSerializer<String>) cache.getRedisTemplate().getKeySerializer();
			RedisSerializer<Object> hkeySerializer  =(RedisSerializer<Object>) cache.getRedisTemplate().getHashKeySerializer();
			//要處理的key
			byte[] key = keySerializer.serialize(lotteryIssueKey);
			RedisCallback<Void> pipelineCallback = new RedisCallback<Void>() {
				//每一個pipeline需要實作自己準備批量放入的方式
				@Override
				public Void doInRedis(RedisConnection connection) throws DataAccessException {
					//迴圈裝入物件
					awardResult.entrySet().forEach(entry->{
						byte[] field = hkeySerializer.serialize(entry.getKey());
						connection.hIncrBy(key, field, entry.getValue().doubleValue());
					});
					return null;
				}
			};
			cache.excutePipeline(pipelineCallback);
		}
	}

	
	/* (non-Javadoc)
	 * @see com.etonghk.killrate.service.clearkillrate.ClearKillRateService#doClearRateFinishMark(java.lang.String, java.lang.String)
	 */
	@Override
	public void doClearRateFinishMark(String lottery, String issue) {
		String clearFinishKey = RedisKey.getLotteryIssueClearFinishKey(lottery, issue);
		//在redis註冊執行完成數量
		cache.incr(clearFinishKey);
	}


	@Override
	public void clearFinishCalKillNumber(String lottery, String issue) {
		String clearFinishNumKey = RedisKey.getLotteryIssueClearFinishKey(lottery, issue);
		String serverCountKey = RedisKey.getServerCount();
		Integer serverCount = (Integer) cache.getObj(serverCountKey);
		Integer lotteryIssueClearCount = (Integer) cache.getObj(clearFinishNumKey);
		if(lotteryIssueClearCount>=serverCount) {
			String lockKey = RedisKey.getLotteryIssueLockKey(lottery, issue);
			Boolean isLock= cache.setLock(lockKey, "0");
			//因為殺率是多台計算,設計分布式鎖,統一由一台進行開獎
			if(isLock) {
				killrateAwardService.calAwardNumber(lottery, issue);
			}
			cache.del(lockKey);
			cache.del(clearFinishNumKey);
		}
	}
}