package com.etonghk.killrate.dao;

import com.etonghk.killrate.domain.GameIssue;

public interface GameIssueDao {
    int insert(GameIssue record);

    GameIssue selectByPrimaryKey(Integer id);
}