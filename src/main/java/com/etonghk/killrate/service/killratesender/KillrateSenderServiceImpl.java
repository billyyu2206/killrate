/**
 * 
 */
package com.etonghk.killrate.service.killratesender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.mq.sender.KillRateBetSender;
import com.etonghk.killrate.mq.sender.KillRatePurseSender;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月27日
 */
@Service
public class KillrateSenderServiceImpl implements KillrateSenderService{

	
	@Autowired
	private KillRatePurseSender killRatePurseSender;
	
	@Autowired
	private KillRateBetSender killRateBetSender;
	@Override
	public void sendGameLotteryOrder(GameLotteryOrder order) {
		if(order.getType() == 0) {
			killRateBetSender.senderGameLotteryOrder(order);
		}else { // order.getType() == 1 追號
			killRatePurseSender.senderGameLotteryOrder(order);
		}
	}

}
