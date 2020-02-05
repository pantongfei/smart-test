package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.service.PermissionService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "关于用户具有哪些资源Controller")
@RestController
public class BasePermissionController {
	@Autowired
	private PermissionService permissionService;
	@ApiOperation(value="查找用户角色下的权限",notes="查找角色信息(角色描述，角色资源权限)")
	@PostMapping("/selectMenuByRoleName")
	public Response<List> selectMenuByRoleName(String name){
		return Response.ok(permissionService.selectMenuByRoleName(name));
	}
}

