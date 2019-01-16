package com.etonghk.killrate.dao;

import java.util.List;
import java.util.Map;

import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardDao {
    int insert(KillrateAward record);

    KillrateAward selectByPrimaryKey(Integer id);
    
    List<KillrateAward> selectForSettingPage(Map<String, Object> cond);
}