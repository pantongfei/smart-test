package com.briup.smart.bean;

import java.util.Date;

public class SmartSql {
    private Integer sId;

    private Date sTime;

    private int sValue;

    private String sLevel;
    public SmartSql() {
		// TODO Auto-generated constructor stub
	}
    public SmartSql(Date time, int value, String level) {
		// TODO Auto-generated constructor stub
    	this.sTime = time;
    	this.setsValue(value);
    	this.sLevel = level;
	}

	public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }



    public String getsLevel() {
        return sLevel;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel == null ? null : sLevel.trim();
    }
	public int getsValue() {
		return sValue;
	}
	public void setsValue(int sValue) {
		this.sValue = sValue;
	}
}