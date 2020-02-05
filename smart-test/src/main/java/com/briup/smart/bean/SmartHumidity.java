package com.briup.smart.bean;

import java.util.Date;

public class SmartHumidity {
    private Integer hId;

    private Date hTime;

    private int hValue;

    private String hLevel;
    public SmartHumidity() {
		// TODO Auto-generated constructor stub
	}
    public SmartHumidity(Date time, int value, String level) {
		// TODO Auto-generated constructor stub
    	this.hTime = time;
    	this.sethValue(value);
    	this.hLevel = level;
	}

	public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public Date gethTime() {
        return hTime;
    }

    public void sethTime(Date hTime) {
        this.hTime = hTime;
    }



    public String gethLevel() {
        return hLevel;
    }

    public void sethLevel(String hLevel) {
        this.hLevel = hLevel == null ? null : hLevel.trim();
    }
	public int gethValue() {
		return hValue;
	}
	public void sethValue(int hValue) {
		this.hValue = hValue;
	}
}