package com.briup.smart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartFacility;
import com.briup.smart.bean.SmartFormaldehyde;
import com.briup.smart.bean.SmartHumidity;
import com.briup.smart.bean.SmartPm;
import com.briup.smart.bean.SmartSql;
import com.briup.smart.bean.SmartTemperator;
import com.briup.smart.service.EnvironmentService;
import com.briup.smart.service.FacilitiesService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="关于设备控制的Controller")
@RestController
public class FacilitiesController {
	@Autowired
	private FacilitiesService fservice;
	@ApiOperation(value="控制所有设备的开关操作",notes="控制所有设备的开关操作")
	@ApiImplicitParam(name="s",value="控制设备的动作",required=true)
	@PostMapping("/facilities")
	public Response<String> OpenAndClose(String s){
		String s1 = fservice.recieveAndExe(s);
		return Response.ok(s1);
	}
	
	//增加设备
	@ApiOperation(value="新增设备",notes="新增设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name",value="设备名称",required=true),
		@ApiImplicitParam(name="protocol",value="设备协议",required=true),
		@ApiImplicitParam(name="action",value="设备动作",required=true)
	})
	@PostMapping("/addfacility")
	public Response<String> addFacility(SmartFacility facility){
	    fservice.insertFacility(facility);
		return Response.ok("success");
	}
	//删除设备   按名字
	@ApiOperation(value="删除设备",notes="删除设备")
	@PostMapping("/removefacility")
	public Response<String> addFacility(String name){
	    fservice.deleteFacility(name);
		return Response.ok("success");
	}
	
}
