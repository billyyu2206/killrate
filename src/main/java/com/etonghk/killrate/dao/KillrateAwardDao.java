package com.etonghk.killrate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardDao {
    int insert(KillrateAward record);
    int batchInsert(@Param("dataList") List<KillrateAward> dataList);
    KillrateAward selectByPrimaryKey(Integer id);
    int deleteForGenerateKillrate(KillrateSetting setting);
    List<KillrateAward> selectForSettingPage(KillrateAward cond);
    List<KillrateAward> selectForGenerateKillrate(KillrateSetting setting);
    
    int updateByPK(KillrateAward record);
    
    int deleteByPK(KillrateAward record);
}