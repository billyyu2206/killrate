package com.etonghk.killrate.dao;

import com.etonghk.killrate.domain.KillrateSettingLog;

public interface KillrateSettingLogDao {
    int insert(KillrateSettingLog record);

    KillrateSettingLog selectByPrimaryKey(Integer id);
}