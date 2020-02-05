package com.briup.smart.bean;

import java.util.Date;

public class SmartCo2History {
	private int max_value;
	private int min_value;
	private Date time;
	public int getMax_value() {
		return max_value;
	}
	public void setMax_value(int max_value) {
		this.max_value = max_value;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getMin_value() {
		return min_value;
	}
	public void setMin_value(int min_value) {
		this.min_value = min_value;
	}
	@Override
	public String toString() {
		return "SmartCo2History [max_value=" + max_value + ", min_value=" + min_value + ", time=" + time + "]";
	}
}
