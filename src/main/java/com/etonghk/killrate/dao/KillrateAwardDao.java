package com.etonghk.killrate.dao;

import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardDao {
    int insert(KillrateAward record);

    KillrateAward selectByPrimaryKey(Integer id);
}