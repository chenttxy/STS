package com.sts.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private Integer goodId;

    private String goodName;

    private Integer goodType;

    private Double goodPrice;

    private String goodDescribe;

    private String goodImage;

    private Date goodTime;

    private Integer goodClick;

    private Integer goodStatus;

    private Integer userId;

    private Integer categoryId;
    
    private MultipartFile file;
    
    private Date endTime;

	public Integer getGoodType() {
		return goodType;
	}

	public void setGoodType(Integer goodType) {
		this.goodType = goodType;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodDescribe() {
        return goodDescribe;
    }

    public void setGoodDescribe(String goodDescribe) {
        this.goodDescribe = goodDescribe == null ? null : goodDescribe.trim();
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage == null ? null : goodImage.trim();
    }

    public Date getGoodTime() {
        return goodTime;
    }

    public void setGoodTime(Date goodTime) {
        this.goodTime = goodTime;
    }

    public Integer getGoodClick() {
        return goodClick;
    }

    public void setGoodClick(Integer goodClick) {
        this.goodClick = goodClick;
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

	@Override
	public String toString() {
		return "Product [goodId=" + goodId + ", goodName=" + goodName + ", goodType=" + goodType + ", goodPrice="
				+ goodPrice + ", goodDescribe=" + goodDescribe + ", goodImage=" + goodImage + ", goodTime=" + goodTime
				+ ", goodClick=" + goodClick + ", goodStatus=" + goodStatus + ", userId=" + userId + ", categoryId="
				+ categoryId + ", file=" + file + ", endTime=" + endTime + "]";
	}
    
}