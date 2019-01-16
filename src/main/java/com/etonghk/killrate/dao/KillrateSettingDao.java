package com.etonghk.killrate.dao;

import com.etonghk.killrate.domain.KillrateSetting;

public interface KillrateSettingDao {
    int insert(KillrateSetting record);

    KillrateSetting selectByPrimaryKey(Integer id);
}