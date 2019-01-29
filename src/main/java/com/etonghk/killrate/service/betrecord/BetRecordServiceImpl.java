package com.etonghk.killrate.service.betrecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.dao.BetRecordDao;
import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.etonghk.killrate.mq.sender.KillRatePurseSender;
import com.etonghk.killrate.service.awardnmber.constant.KillrateConstant;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
@Service
public class BetRecordServiceImpl implements BetRecordService {

	@Autowired
	private BetRecordDao betRecordDao;
	@Autowired
	private KillRatePurseSender killRatePurseSender;
	@Autowired
	private KillRateBetSender killRateBetSender;
	
	
	@Override
	public void createPurseTable(LocalDateTime date, int afterDay) {

		for (int i = 0; i <= afterDay; i++) {
			for (String lottery : KillrateConstant.allGameMap.keySet()) {
				String dateStr = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				int exist = betRecordDao.checkTableExist(lottery, dateStr);
				if (exist == 0) {
					betRecordDao.createPurseTable(lottery, dateStr);
				}
			}
			date = date.plusDays(1);
		}
	}
	
	@Override
	public void sendGameLotteryOrder(GameLotteryOrder order) {
		if(order.getType() == 0) {
			killRateBetSender.senderGameLotteryOrder(order);
		}else { // order.getType() == 1 追號
			killRatePurseSender.senderGameLotteryOrder(order);
		}
	}

}
