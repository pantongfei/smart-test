package com.briup.smart.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="报警信息模型")
public class Warning {
    @ApiModelProperty(value="报警信息编号",example="1")
    private Integer id;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="报警时间")
    private Date time;
	@ApiModelProperty(value="报警数据或设备",example="")
    private String device;
	@ApiModelProperty(value="报警类型",example="")
    private String warningType;
	@ApiModelProperty(value="报警等级",example="")
    private String warningLevel;
	@ApiModelProperty(value="报警内容",example="")
    private String warningContent;
	@ApiModelProperty(value="报警信息状态",example="")
    private String state;
	@ApiModelProperty(value="确认人姓名",example="")
    private String wName;
	@ApiModelProperty(value="确认详细信息",example="")
    private String wShow;
	@ApiModelProperty(value="确认时间")
    private Date wTime;
	@ApiModelProperty(value="日时间")
	private Date dTime;
    public Date getdTime() {
		return dTime;
	}

	public void setdTime(Date dTime) {
		this.dTime = dTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getWarningType() {
        return warningType;
    }

    public void setWarningType(String warningType) {
        this.warningType = warningType == null ? null : warningType.trim();
    }

    public String getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(String warningLevel) {
        this.warningLevel = warningLevel == null ? null : warningLevel.trim();
    }

    public String getWarningContent() {
        return warningContent;
    }

    public void setWarningContent(String warningContent) {
        this.warningContent = warningContent == null ? null : warningContent.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName == null ? null : wName.trim();
    }

    public String getwShow() {
        return wShow;
    }

    public void setwShow(String wShow) {
        this.wShow = wShow == null ? null : wShow.trim();
    }

    public Date getwTime() {
        return wTime;
    }

    public void setwTime(Date wTime) {
        this.wTime = wTime;
    }
    /*@Override
    public String toString() {
    	return "Warning [ id="+id+",time="+time+",device="+device+",warningType="+warningType+",warningLevel="+warningLevel+","
    			+ " warningContent="+warningContent+",state="+state+",wName="+wName+",wTime="+wTime+",wShow="+wShow+"]";
    }*/
}