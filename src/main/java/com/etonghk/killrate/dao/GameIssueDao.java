package com.etonghk.killrate.dao;

import java.util.List;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.domain.GameIssue;

public interface GameIssueDao {
    int insert(GameIssue record);

    GameIssue selectByPrimaryKey(Integer id);
    
    List<GameIssue> selectForGenerateKillrate(KillrateSetting setting);
}