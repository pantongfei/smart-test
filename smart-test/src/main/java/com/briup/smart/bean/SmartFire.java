package com.briup.smart.bean;

import java.util.Date;

public class SmartFire {
    private Integer fireId;

    private Date fireTime;

    private String fireStatus;
    
    public Integer getFireId() {
        return fireId;
    }

    public void setFireId(Integer fireId) {
        this.fireId = fireId;
    }

    public Date getFireTime() {
        return fireTime;
    }

    public void setFireTime(Date fireTime) {
        this.fireTime = fireTime;
    }

    public String getFireStatus() {
        return fireStatus;
    }

    public void setFireStatus(String fireStatus) {
        this.fireStatus = fireStatus == null ? null : fireStatus.trim();
    }
}