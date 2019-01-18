package com.etonghk.killrate.controller.dto.request;

import java.util.Arrays;
import java.util.Date;

public class GameLotteryOrder implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// Fields
	private int id;
	private String billno;
	private int accountId;
	private int type;
	private String lottery;
	private String issue;
	private String method;
	private String content;
	private Boolean compress;
	private int nums;
	private String model;
	private int multiple;
	private int code;
	private double point;
	private double money;
	private Date orderTime;
	private Date stopTime;
	private Date openTime;
	private int status;
	private String openCode;
	private double winMoney;
	private Date clearTime;
	private String reference;

	/**
	 * 存到MySQL数据库时不需要此字段
	 */
	private Integer[] pids;

	// Constructors

	/** default constructor */
	public GameLotteryOrder() {
	}

	/** minimal constructor */
	public GameLotteryOrder(String billno, int accountId, int type, String lottery, String issue, String method,
			String content, Boolean compress, int nums, String model, int multiple, int code, double point,
			double money, Date orderTime, Date stopTime, Date openTime, int status, double winMoney, Date clearTime) {
		this.billno = billno;
		this.accountId = accountId;
		this.type = type;
		this.lottery = lottery;
		this.issue = issue;
		this.method = method;
		this.content = content;
		this.compress = compress;
		this.nums = nums;
		this.model = model;
		this.multiple = multiple;
		this.code = code;
		this.point = point;
		this.money = money;
		this.orderTime = orderTime;
		this.stopTime = stopTime;
		this.openTime = openTime;
		this.status = status;
		this.winMoney = winMoney;
		this.clearTime = clearTime;
	}

	/** full constructor */
	public GameLotteryOrder(String billno, int accountId, int type, String lottery, String issue, String method,
			String content, Boolean compress, int nums, String model, int multiple, int code, double point,
			double money, Date orderTime, Date stopTime, Date openTime, int status, String openCode, double winMoney,
			Date clearTime, String reference) {
		this.billno = billno;
		this.accountId = accountId;
		this.type = type;
		this.lottery = lottery;
		this.issue = issue;
		this.method = method;
		this.content = content;
		this.compress = compress;
		this.nums = nums;
		this.model = model;
		this.multiple = multiple;
		this.code = code;
		this.point = point;
		this.money = money;
		this.orderTime = orderTime;
		this.stopTime = stopTime;
		this.openTime = openTime;
		this.status = status;
		this.openCode = openCode;
		this.winMoney = winMoney;
		this.clearTime = clearTime;
		this.reference = reference;
	}

	// Property accessors
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillno() {
		return this.billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getCompress() {
		return this.compress;
	}

	public void setCompress(Boolean compress) {
		this.compress = compress;
	}

	public int getNums() {
		return this.nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMultiple() {
		return this.multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getPoint() {
		return this.point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOpenCode() {
		return this.openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public double getWinMoney() {
		return this.winMoney;
	}

	public void setWinMoney(double winMoney) {
		this.winMoney = winMoney;
	}

	public Date getClearTime() {
		return this.clearTime;
	}

	public void setClearTime(Date clearTime) {
		this.clearTime = clearTime;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer[] getPids() {
		return pids;
	}

	public void setPids(Integer[] pids) {
		this.pids = pids;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameLotteryOrder [id=" + id + ", billno=" + billno + ", accountId=" + accountId + ", type=" + type
				+ ", lottery=" + lottery + ", issue=" + issue + ", method=" + method + ", content=" + content
				+ ", compress=" + compress + ", nums=" + nums + ", model=" + model + ", multiple=" + multiple
				+ ", code=" + code + ", point=" + point + ", money=" + money + ", orderTime=" + orderTime
				+ ", stopTime=" + stopTime + ", openTime=" + openTime + ", status=" + status + ", openCode=" + openCode
				+ ", winMoney=" + winMoney + ", clearTime=" + clearTime + ", reference=" + reference + ", pids="
				+ Arrays.toString(pids) + "]";
	}

}