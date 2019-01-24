package com.etonghk.killrate.domain;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public class AwardSampleKey {
    private String lotteryType;

    private String method;

    private Integer type;

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType == null ? null : lotteryType.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}