package com.etonghk.killrate.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.domain.GameIssue;

public interface GameIssueDao {
    int insert(GameIssue record);

    int batchInsert(@Param("dataList") List<GameIssue> dataList, @Param("lottery") String lottery);
    
    GameIssue selectByPrimaryKey(Integer id);
    
    List<GameIssue> selectForGenerateKillrate(KillrateSetting setting);
    
    String selectIssueByDate(@Param("lottery")String lottery, @Param("date")Date date);
}