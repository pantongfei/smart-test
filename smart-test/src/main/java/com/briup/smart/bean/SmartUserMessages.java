package com.briup.smart.bean;

import io.swagger.annotations.ApiModelProperty;

public class SmartUserMessages {
	private Long id;
	@ApiModelProperty(value="用户昵称",example="")
	private String name;
	@ApiModelProperty(value="用户邮箱",example="")
	private String email;
	@ApiModelProperty(value="用户联系电话",example="")
	private String phone;
	@ApiModelProperty(value="用户头像",example="")
	private String avatarurl;
	@ApiModelProperty(value="用户密码",example="")
	private String password;
	@ApiModelProperty(value="用户备用电话",example="")
	private String mibo_phone;
	@ApiModelProperty(value="用户备用邮箱",example="")
	private String standby_email;
	@ApiModelProperty(value="用户角色",example="普通用户" )
	private String role_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAvatarurl() {
		return avatarurl;
	}
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMibo_phone() {
		return mibo_phone;
	}
	public void setMibo_phone(String mibo_phone) {
		this.mibo_phone = mibo_phone;
	}
	public String getStandby_email() {
		return standby_email;
	}
	public void setStandby_email(String standby_email) {
		this.standby_email = standby_email;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
