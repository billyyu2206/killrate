package com.etonghk.killrate.dao;

import com.etonghk.killrate.domain.OrderDeadLetterLog;

public interface OrderDeadLetterLogDao {
    int insert(OrderDeadLetterLog record);

    OrderDeadLetterLog selectByPrimaryKey(Integer id);
}