package com.sts.pojo;

public class Preorder {
	
	private Integer preorderId;

    private Integer goodId;

    private Double money;

    private Integer userId;

	public Integer getPreorderId() {
		return preorderId;
	}

	public void setPreorderId(Integer preorderId) {
		this.preorderId = preorderId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Preorder [preorderId=" + preorderId + ", goodId=" + goodId + ", money=" + money + ", userId=" + userId
				+ "]";
	}
}
