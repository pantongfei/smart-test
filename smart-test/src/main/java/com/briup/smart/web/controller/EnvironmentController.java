package com.briup.smart.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartFire;
import com.briup.smart.bean.SmartFormaldehyde;
import com.briup.smart.bean.SmartHumidity;
import com.briup.smart.bean.SmartPm;
import com.briup.smart.bean.SmartSmog;
import com.briup.smart.bean.SmartSql;
import com.briup.smart.bean.SmartTemperator;
import com.briup.smart.bean.SmartUser;
import com.briup.smart.service.EnvironmentService;
import com.briup.smart.service.FirstService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags="关于环境指标的Controller")
@RestController
public class EnvironmentController {
	@Autowired
	private EnvironmentService service;
	
	/*@ApiOperation(value="保存所有环境指标信息",notes="保存所有环境指标信息")
	@PostMapping("/environment")
	public Response<String> saveEnvironmnent(SmartCo2 co2,SmartFormaldehyde formaldehyde,SmartHumidity humidity,
			SmartPm pm,SmartSql sql,SmartTemperator tem){
		service.saveEnvironMess(co2,formaldehyde,humidity,pm,sql,tem);
		return Response.ok("success");
	}*/
	/*@ApiOperation(value="按照编号查找环境指标信息",notes="按照编号查找环境指标信息")
	@ApiImplicitParam(name="id",value="编号",paramType="path",required=true)
	@GetMapping("/user/{id}")
	public Response<SmartUser> getUserById(@PathVariable("id")Long id){
		return Response.ok(service.findUserById(id));
	}*/
	@ApiOperation(value="查找环境有关数据项最新4条记录",notes="查找环境有关数据项最新4条记录")
	@GetMapping("/realtimeEnvironment")
	public Response<List> getEnvironmentData(){
		return Response.ok(service.getRealtimeMess());
	}
	@ApiOperation(value="查询温度、湿度、CO2、PM2.5过去五天历史记录最大值、最小值",notes="查询温度、湿度、CO2、PM2.5过去五天历史记录最大值、最小值")
	@GetMapping("/historyRecordMax")
	public Response<List> getHistoryDataMax(){
		return Response.ok(service.getHistoryMess());
	}
	/*@ApiOperation(value="查询温度、湿度、CO2、PM2.5过去五天历史记录最小值",notes="查询温度、湿度、CO2、PM2.5过去五天历史记录最小值")
	@GetMapping("/historyRecordMin")
	public Response<List> getHistoryDataMin(){
		return Response.ok(service.getHistoryMinMess());
	}*/

	
	
}
