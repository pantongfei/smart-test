package com.briup.smart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.SmartUser;
import com.briup.smart.bean.SmartUserMessages;
import com.briup.smart.service.UserMessService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="关于用户信息管理的Controller")
@RestController
public class UserMessController {
	@Autowired
	private UserMessService userMessService;
	
	@ApiOperation(value="保存用户注册信息",notes="保存用户注册信息")
	@PostMapping("/userRegist")
	//@ApiImplicitParam(name="file",value="用户上传头像文件")
	public Response<String> saveuserMess(SmartUserMessages user,MultipartFile file){
		userMessService.saveuser(user,file);
		return Response.ok("success");
	}
	//@ApiOperation(value="查找指定用户的账号",notes="通过密码和昵称为用户返回一个id账号")
	/*@ApiImplicitParams({
	@ApiImplicitParam(name="name",value="用户昵称",paramType="path",required=true),
	@ApiImplicitParam(name="password",value="用户密码",paramType="path",required=true)})
	
	@GetMapping("/userid/{name}/{password}")
	public Response<Long> selectUserId(@PathVariable("name") String name,@PathVariable("password") String password){
    	Long id = userMessService.selectUserIdByNamePassword(name, password);
		return  Response.ok(id);
		
	}
	*/
	@ApiOperation(value="修改用户基本信息",notes="修改用户基本信息")
	@PostMapping("/userMess")
	public Response<String> updateuserMess(SmartUserMessages user,MultipartFile file){
		userMessService.saveOrUpdate(user,file);
		return Response.ok("success");
	}
	
    @ApiOperation(value="查询指定用户的信息",notes="查询指定用户的信息")
	@ApiImplicitParam(name="id",value="用户编号",paramType="path",required=true)
    @GetMapping("/userMess/{id}")
	public Response<SmartUserMessages> selectUserMess(@PathVariable("id") Long id){
    	SmartUserMessages sum = userMessService.selectById(id);
		return  Response.ok(sum);
		
	}
    @ApiOperation(value="超级管理员指定用户角色",notes="超级管理员指定用户角色")
    @ApiImplicitParams({
         @ApiImplicitParam(name="id",value="用户编号",required=true),
         @ApiImplicitParam(name="role_name",value="用户角色名",required=true)
    })
    @PostMapping("/userRole")
    public Response<String> modifyUserRole(Long id,String role_name){
    	userMessService.modifyRole(id,role_name);
		return Response.ok("success");
    }
    
}
