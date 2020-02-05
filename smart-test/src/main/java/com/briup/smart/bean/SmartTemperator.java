package com.briup.smart.bean;

import java.util.Date;

public class SmartTemperator {
    private Integer tId;

    private Date tTime;

    private int tValue;

    private String tLevel;
    public SmartTemperator() {
		// TODO Auto-generated constructor stub
	}
    public SmartTemperator(Date time, int value, String level) {
		// TODO Auto-generated constructor stub
    	this.tTime = time;
    	this.settValue(value);
    	this.tLevel = level;
	}

	public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Date gettTime() {
        return tTime;
    }

    public void settTime(Date tTime) {
        this.tTime = tTime;
    }



    public String gettLevel() {
        return tLevel;
    }

    public void settLevel(String tLevel) {
        this.tLevel = tLevel == null ? null : tLevel.trim();
    }
	public int gettValue() {
		return tValue;
	}
	public void settValue(int tValue) {
		this.tValue = tValue;
	}
}