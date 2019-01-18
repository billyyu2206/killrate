package com.etonghk.killrate.domain;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public class AwardSampleKey {
    private String gameType;

    private String gamePlayId;

    private Integer type;

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
    }

    public String getGamePlayId() {
        return gamePlayId;
    }

    public void setGamePlayId(String gamePlayId) {
        this.gamePlayId = gamePlayId == null ? null : gamePlayId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}