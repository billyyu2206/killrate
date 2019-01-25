package com.etonghk.killrate.service.orderdeadletterlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.dao.OrderDeadLetterLogDao;
import com.etonghk.killrate.domain.OrderDeadLetterLog;
import com.jack.entity.GameLotteryOrder;

/**
 * @author Billy.Yu
 * @date 2019年1月25日
 */
@Service
public class OrderDeadLetterLogServiceImpl implements OrderDeadLetterLogService{

	@Autowired
	private OrderDeadLetterLogDao orderDeadLetterLogDao;
	
	
	@Override
	public void insertOrder(GameLotteryOrder order) {
		OrderDeadLetterLog orderDeadLetterLog = new OrderDeadLetterLog();
		orderDeadLetterLog.setLottery(order.getLottery());
		orderDeadLetterLog.setBillNo(order.getBillno());
		orderDeadLetterLog.setIssue(order.getIssue());
		orderDeadLetterLog.setMethod(order.getMethod());
		orderDeadLetterLog.setContent(order.getContent());
		orderDeadLetterLogDao.insert(orderDeadLetterLog);
	}

}
