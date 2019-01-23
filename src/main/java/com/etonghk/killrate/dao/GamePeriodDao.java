package com.etonghk.killrate.dao;

import java.util.List;

import com.etonghk.killrate.domain.GamePeriod;
/**
 * 
 * @author Peter.Hong
 * @date 2019年1月23日
 */
public interface GamePeriodDao {
    GamePeriod selectByPrimaryKey(Integer id);
    /**
     * 	拿取有開放的遊戲
     * @return
     */
    List<GamePeriod> getGamePeriodsList();
}