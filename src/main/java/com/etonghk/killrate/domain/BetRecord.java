package com.etonghk.killrate.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BetRecord {
    private Integer id;

    private String billno;

    private Integer accountId;

    private Byte type;

    private String lottery;

    private String issue;

    private String method;

    private Boolean compress;

    private Integer nums;

    private String model;

    private Integer multiple;

    private Integer code;

    private BigDecimal point;

    private BigDecimal money;

    private LocalDateTime orderTime;

    private LocalDateTime stopTime;

    private LocalDateTime openTime;

    private Byte status;

    private String openCode;

    private BigDecimal winMoney;

    private LocalDateTime clearTime;

    private String reference;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery == null ? null : lottery.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Boolean getCompress() {
        return compress;
    }

    public void setCompress(Boolean compress) {
        this.compress = compress;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode == null ? null : openCode.trim();
    }

    public BigDecimal getWinMoney() {
        return winMoney;
    }

    public void setWinMoney(BigDecimal winMoney) {
        this.winMoney = winMoney;
    }

    public LocalDateTime getClearTime() {
        return clearTime;
    }

    public void setClearTime(LocalDateTime clearTime) {
        this.clearTime = clearTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}