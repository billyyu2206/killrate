package com.etonghk.killrate.domain;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public class AwardSample extends AwardSampleKey {
    private String methodName;

    private String betNumber;

    private String awardNumber;

    private String remarks;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getBetNumber() {
        return betNumber;
    }

    public void setBetNumber(String betNumber) {
        this.betNumber = betNumber == null ? null : betNumber.trim();
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber == null ? null : awardNumber.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}