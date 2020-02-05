package com.briup.smart.bean;

import java.util.Date;

public class SmartCo2 {
    private Integer cId;

    private Date cTime ;
 
    private int cValue;

    private String cLevel;
    public SmartCo2() {
		// TODO Auto-generated constructor stub
	}

    public SmartCo2(Date time, int value, String level) {
		// TODO Auto-generated constructor stub
    	this.cTime = time;
    	this.setcValue(value);
    	this.cLevel = level;
	}

	public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }


    public String getcLevel() {
        return cLevel;
    }

    public void setcLevel(String cLevel) {
        this.cLevel = cLevel == null ? null : cLevel.trim();
    }

	public int getcValue() {
		return cValue;
	}

	public void setcValue(int cValue) {
		this.cValue = cValue;
	}

	@Override
	public String toString() {
		return "SmartCo2 [cId=" + cId + ", cTime=" + cTime + ", cValue=" + cValue + ", cLevel=" + cLevel + "]";
	}
}