package com.briup.smart.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.SmartEvent;

import com.briup.smart.service.EventService;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="事件的查删操作")
@RestController
public class EventController {
	@Autowired
	private EventService service;
	
//	@ApiOperation(value="保存甲醛数据事件",notes="保存甲醛相关事件")
//	@PostMapping("/event/savedata_formaldehyde")
//	public Response<Integer> save_Data_formaldehyde(){
//		return Response.ok(service.save_Data_formaldehyde());
//	}
//	
//	@ApiOperation(value="保存fire数据事件",notes="保存fire相关事件")
//	@PostMapping("/event/savedata_fire")
//	public Response<Integer> save_Data_fire(){
//		return Response.ok(service.save_Data_fire());
//	}
//	
//	@ApiOperation(value="保存空气质量数据事件",notes="保存空气质量事件")
//	@PostMapping("/event/savedata_light")
//	public Response<Integer> save_Data_sql(){
//		return Response.ok(service.save_Data_Sql());
//	}
//	
//	@ApiOperation(value="保存smog数据事件",notes="保存smog相关事件")
//	@PostMapping("/event/savedata_smoke")
//	public Response<Integer> save_Data_smoke(){
//		return Response.ok(service.save_Data_smoke());
//	}
//	
//	@ApiOperation(value="保存pm2.5数据事件",notes="保存pm2.5相关事件")
//	@PostMapping("/event/savedata_pm25")
//	public Response<Integer> save_Data_pm25(){
//		return Response.ok(service.save_Data_pm25());
//	}
//	
//	@ApiOperation(value="保存co2数据事件",notes="保存co2数据事件")
//	@PostMapping("/event/savedata_co2")
//	public Response<Integer> save_Data_co2(){
//		return Response.ok(service.save_Data_co2());
//	}
//	
//	@ApiOperation(value="保存湿度数据事件",notes="保存湿度数据事件")
//	@PostMapping("/event/savedata_hum")
//	public Response<Integer> save_Data_hum(){
//		return Response.ok(service.save_Data_hum());
//	}
//	
//	@ApiOperation(value="保存温度数据事件",notes="保存温度数据事件")
//	@PostMapping("/event/savedata_temp")
//	public Response<Integer> save_Data_temp(){
//		return Response.ok(service.save_Data_temp());
//	}
//	
//	@ApiOperation(value="保存用户相关事件",notes="保存用户相关事件")
//	@PostMapping("/event/saveusact")
//	public Response<SmartEvent> save_UsAct(){
//		return Response.ok(service.save_UsAct());
//	}
//	@ApiOperation(value="保存联动触发事件",notes="保存联动触发事件")
//	@PostMapping("/event/savelinkage")
//	public Response<SmartEvent> save_Linkage(){
//		return Response.ok(service.save_Linkage());
//	}
	@ApiOperation(value="按照编号删除事务信息",notes="按照编号删除事务信息")
	@ApiImplicitParam(name="id",value="用户编号",paramType="path",required=true)
	@DeleteMapping("/event/{id}")
	public Response<Integer> deleteEvent(@PathVariable("id")Integer id){
		return Response.ok(service.deleteEventById(id));
	}
	
//	@ApiOperation(value="按照编号查找事务信息",notes="按照编号查找事务信息")
//	@ApiImplicitParam(name="id",value="事务编号",paramType="path",required=true)
//	@GetMapping("/event/{id}")
//	public Response<SmartEvent> getEventById(@PathVariable("id")Integer id){
//		return Response.ok(service.findEventById(id));
//	}
//	
	@ApiOperation(value="全部事件",notes="全部事件")
	@PostMapping("/event/all")
	public Response<List<SmartEvent>> selectAll(){
		return Response.ok(service.selectAll());
	}
	@ApiOperation(value="事件分页查询",notes="事件分页查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页码",required=false,defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数(0是全部)",required=false,defaultValue="2"),
		@ApiImplicitParam(name="content",value="搜索关键字",required=false),
		@ApiImplicitParam(name="type",value="事件类型",required=false),
		@ApiImplicitParam(name="day",value="事件日期",required=true)
	})
	@GetMapping("/event/page")
	 
	public Response<PageInfo<SmartEvent>> 
	getAllByPage(
			@RequestParam(name="pageNum",defaultValue="1")int pageNum,
			@RequestParam(name="pageSize",defaultValue="2")int pageSize,
			@RequestParam(name="content",required=false)String content,
			@RequestParam(name="type",required=false)String type,
			@RequestParam(name="day",required=true)String day) throws ParseException {
		return Response.ok(service.selectByPage(pageNum, pageSize,content,type,day));
	}
//	@ApiOperation(value="根据关键字查找事件",notes="根据关键字查找事件")
//	@ApiImplicitParam(name="content",value="事务关键字")
//	@GetMapping("/event/selectcontent/{content}")
//	public Response<List<SmartEvent>> selectContent(@PathVariable("content")String content) {
//		return Response.ok(service.selectContent(content));
//	}
//	@ApiOperation(value="根据日期查找事件",notes="根据日期查找事件")
//	@ApiImplicitParam(name="daytime",value="日期",paramType="path")
//	@GetMapping("/event/select/{daytime}")
//	public Response<List<SmartEvent>> selectByDate(@PathVariable("daytime")String day) throws ParseException {
//		return Response.ok(service.selectBydate(day));
//	}
}
