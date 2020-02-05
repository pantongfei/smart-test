package com.briup.smart.web.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Warning;
import com.briup.smart.service.AddWarning;
import com.briup.smart.service.WarningService;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="关于报警信息的controller")
@RestController
public class WarningControler {
	@Autowired
	private WarningService warservice;
		
	@ApiOperation(value="确认报警信息的状态",notes="输入id更新报警信息")
	@PostMapping("/warning/{id}")	
	public Response<String> warning(Warning war){
		warservice.saveOrUpdate(war);
		return Response.ok("success");
	}
	
	/*@ApiOperation(value="按照报警内容查找",notes="按照报警内容查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name="warningContent",value="报警内容",required=false)
		//@ApiImplicitParam(name="time",value="报警时间",required=false),
		//@ApiImplicitParam(name="warningType",value="报警类型",required=false,defaultValue="数据异常")
		})
	@GetMapping("/warning/content")
	public Response<List<Warning>> getWarningByContent(
			@RequestParam(name="warningContent",required=false)String warningContent)
			//@RequestParam(name="warningType",defaultValue="数据异常")String warningType)
			{
		return Response.ok(warservice.findWarningByContent(warningContent));
	}*/
	
	@ApiOperation(value="分页查找报警信息",notes="分页查找报警信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页码",required=false,defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数(0是全部)",required=false,defaultValue="2"),
		@ApiImplicitParam(name="warningContent",value="输入关键字查询",required=false),
		@ApiImplicitParam(name="warningType",value="输入报警类型",required=false)
	})
	@GetMapping("/warning/FindPage")
	public Response<PageInfo<Warning>>
	getFindByPage(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
				@RequestParam(name="pageSize",defaultValue="2")int pageSize,
				@RequestParam(name="warningContent",required=false)String warningContent,
				@RequestParam(name="warningType",required=false)String warningType,
				@RequestParam(name="dayTime",required=false)String dayTime) throws ParseException{
			return Response.ok(warservice.getFindByPage(pageNum, pageSize,warningContent,warningType));
		}
	}
	
	
	/*
	 * @ApiOperation(value="分页查找所有报警信息",notes="分页查找所有报警信息")
	 * 
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(name="pageNum",value="当前页码",required=false,defaultValue="1"
	 * ),
	 * 
	 * @ApiImplicitParam(name="pageSize",value="每页显示数据个数(0是全部)",required=false,
	 * defaultValue="2") })
	 * 
	 * @GetMapping("/warning/byPage") public Response<PageInfo<Warning>>
	 * getAllByPage(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
	 * 
	 * @RequestParam(name="pageSize",defaultValue="2")int pageSize){ return
	 * Response.ok(warservice.getAllByPage(pageNum, pageSize)); }
	 */

