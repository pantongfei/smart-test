package com.briup.smart.bean;

import java.util.Date;

public class SmartFormaldehyde {
    private Integer fId;

    private Date fTime;

    private int fValue;

    private String fLevel;
    public SmartFormaldehyde() {
		// TODO Auto-generated constructor stub
	}
    public SmartFormaldehyde(Date time, int value, String level) {
		// TODO Auto-generated constructor stub
    	this.fTime = time;
    	this.setfValue(value);
    	this.fLevel = level;
	}

	public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }


    public String getfLevel() {
        return fLevel;
    }

    public void setfLevel(String fLevel) {
        this.fLevel = fLevel == null ? null : fLevel.trim();
    }
	public int getfValue() {
		return fValue;
	}
	public void setfValue(int fValue) {
		this.fValue = fValue;
	}
}