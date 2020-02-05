package com.briup.smart.bean;

import java.util.Date;

public class SmartPm {
    private Integer pId;

    private Date pTime;

    private int pValue;

    private String pLevel;
    public SmartPm() {
		// TODO Auto-generated constructor stub
	}
    public SmartPm(Date time, int value, String level) {
		// TODO Auto-generated constructor stub
    	this.pTime = time;
    	this.setpValue(value);
    	this.pLevel = level;
	}

	public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }



    public String getpLevel() {
        return pLevel;
    }

    public void setpLevel(String pLevel) {
        this.pLevel = pLevel == null ? null : pLevel.trim();
    }
	public int getpValue() {
		return pValue;
	}
	public void setpValue(int pValue) {
		this.pValue = pValue;
	}
}