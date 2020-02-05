package com.briup.smart.bean;

import java.util.Date;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class SmartEvent {
    private Integer id;

    private String type;

    private String content;

    private Date time;

    private Date daytime;

   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDaytime() {
        return daytime;
    }

    public void setDaytime(Date daytime) {
        this.daytime = daytime;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}