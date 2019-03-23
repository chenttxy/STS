package com.sts.pojo;

import java.util.Date;

public class Reporte {
    private Integer reporteId;

    private String reporteInfo;

    private Date reporteTime;

    private Integer userId;

    private Integer goodId;

    public Integer getReporteId() {
        return reporteId;
    }

    public void setReporteId(Integer reporteId) {
        this.reporteId = reporteId;
    }

    public String getReporteInfo() {
        return reporteInfo;
    }

    public void setReporteInfo(String reporteInfo) {
        this.reporteInfo = reporteInfo == null ? null : reporteInfo.trim();
    }

    public Date getReporteTime() {
        return reporteTime;
    }

    public void setReporteTime(Date reporteTime) {
        this.reporteTime = reporteTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}