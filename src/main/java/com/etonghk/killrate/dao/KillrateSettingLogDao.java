package com.etonghk.killrate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etonghk.killrate.controller.dto.request.KillrateSettingLogRequest;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateSettingLog;

public interface KillrateSettingLogDao {
    int insert(KillrateSettingLog record);

    KillrateSettingLog selectByPrimaryKey(Integer id);
    
    List<KillrateSettingLog> selectByCond(@Param("cond") KillrateSettingLogRequest cond, @Param("page") Page<KillrateSettingLog> page);
}