package com.briup.smart.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.SmartUser;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.service.FirstService;
import com.briup.smart.web.vm.FieldError;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="第一个测试Controller")
@RestController
public class FirstController {
	@Autowired
	private FirstService service;
	
	@ApiOperation(value="保存或更新用户信息",notes="保存或更新用户信息")
	@PostMapping("/user")
	public Response<String> first(SmartUser user){
		service.saveOrUpdate(user);
		return Response.ok("success");
	}
	
	@ApiOperation(value="按照用户编号删除用户信息",notes="按照用户编号删除用户信息")
	@ApiImplicitParam(name="id",value="用户编号",paramType="path",required=true)
	@DeleteMapping("/user/{id}")
	public Response<String> deleteUser(@PathVariable("id")Long id){
		return Response.ok("success");
	}
	
	@ApiOperation(value="按照用户编号查找用户信息",notes="按照用户编号查找用户信息")
	@ApiImplicitParam(name="id",value="用户编号",paramType="path",required=true)
	@GetMapping("/user/{id}")
	public Response<SmartUser> getUserById(@PathVariable("id")Long id){
		return Response.ok(service.findUserById(id));
	}
	
	@ApiOperation(value="分页查找所有用户",notes="分页查找所有用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页码",required=false,defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数(0是全部)",required=false,defaultValue="2")
	})
	@GetMapping("/user/byPage")
	public Response<PageInfo<SmartUser>> 
	getAllByPage(@RequestParam(name="pageNum",
	defaultValue="1")int pageNum,
			@RequestParam(name="pageSize",defaultValue="2")int pageSize){
		return Response.ok(service.getAllByPage(pageNum, pageSize));
	}
	
	
	
}
