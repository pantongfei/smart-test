package com.briup.smart.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.SmartUserMessages;
import com.briup.smart.bean.extend.SmartResourceExtend;
import com.briup.smart.service.DisplayResourceService;
import com.briup.smart.service.PermissionService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="关于根据角色展示不同资源的Controller")
@RestController
public class DisplayResourceController {
	@Autowired
	private DisplayResourceService service;
    @Autowired
    private PermissionService service1;
	@ApiOperation(value="查找指定角色的资源",notes="查找指定角色的资源")
	@GetMapping("/displayResource")
	public Response<List> getEnvironmentData(/*HttpSession session*/SmartUserMessages user){
		//SmartUserMessages user =(SmartUserMessages)session.getAttribute("user");
		String rolename = user.getRole_name();
	    int roleId = service1.selectidByName(rolename);
		List<SmartResourceExtend> resources = service.findByRoldId(roleId);
		//session.setAttribute("resources", resources);
		return Response.ok(resources);
	}
}
