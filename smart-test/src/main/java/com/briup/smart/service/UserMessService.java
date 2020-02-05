package com.briup.smart.service;

import java.util.Collection;
import java.util.HashSet;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.SmartUser;
import com.briup.smart.bean.SmartUserMessages;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.common.utils.multipart.FileUpLoad;
import com.briup.smart.mapper.SmartUserMessagesMapper;
import com.briup.smart.web.vm.FieldError;

import net.sf.jsqlparser.statement.update.Update;

@Service
public class UserMessService {
	@Autowired
	private SmartUserMessagesMapper userMessMapper;

	@Transactional
	public void saveOrUpdate(SmartUserMessages userMess,MultipartFile file) {
		Collection<FieldError> fs = new HashSet<>();
		if("".equals(userMess.getEmail())||userMess.getEmail()==null) {
			fs.add(new FieldError("email", "邮箱信息不能为空！"));
		}
		if("".equals(userMess.getName())||userMess.getName()==null) {
			fs.add(new FieldError("name","昵称不能为空！"));
		}
		if("".equals(userMess.getPhone())||userMess.getPhone()==null) {
			fs.add(new FieldError("phone","联系电话不能为空！"));
		}
		if("".equals(userMess.getPassword())||userMess.getPassword()==null) {
			fs.add(new FieldError("password","密码不能为空！"));
		}
		String username = userMess.getName();
		SmartUserMessages user = userMessMapper.selectByname(username);
		if(user!=null) {
			fs.add(new FieldError("username","用户名已存在！"));
		}
		if(!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		
			FileUpLoad upload = new FileUpLoad();
			String path = upload.uploadPicture(file);
			userMess.setAvatarurl(path);
			userMessMapper.updateByPrimaryKey(userMess);
	}
	@Transactional
	public SmartUserMessages selectById(Long id) {
		SmartUserMessages sum = userMessMapper.selectByPrimaryKey(id);
		
		return sum;
	}
	@Transactional
	//包括上传图片
	public  void saveuser(SmartUserMessages userMess,MultipartFile file) {
		// TODO Auto-generated method stub
		Collection<FieldError> fs = new HashSet<>();
		if("".equals(userMess.getEmail())||userMess.getEmail()==null) {
			fs.add(new FieldError("email", "邮箱信息不能为空！"));
		}
		if("".equals(userMess.getName())||userMess.getName()==null) {
			fs.add(new FieldError("name","昵称不能为空！"));
		}
		if("".equals(userMess.getPhone())||userMess.getPhone()==null) {
			fs.add(new FieldError("phone","联系电话不能为空！"));
		}
		if("".equals(userMess.getPassword())||userMess.getPassword()==null) {
			fs.add(new FieldError("password","密码不能为空！"));
		}
		String username = userMess.getName();
		SmartUserMessages user = userMessMapper.selectByname(username);
		if(user!=null) {
			fs.add(new FieldError("username","用户名已存在！"));
		}
		if(!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		System.out.println("userMess:"+userMess);
		System.out.println("file:"+file);
		FileUpLoad upload = new FileUpLoad();
		String path = upload.uploadPicture(file);
		userMess.setAvatarurl(path);
		userMessMapper.insert(userMess);
		
	}
/*	@Transactional
	public Long selectUserIdByNamePassword(String name,String password) {
		Long id = userMessMapper.selectId(name, password);
		return id;
		
	}*/
	@Transactional
	public void modifyRole(Long id,String role_name) {
		// TODO Auto-generated method stub
		userMessMapper.modifyUserRolebyId(id,role_name);
	}
	@Transactional
	public SmartUserMessages login(String nameorphone, String password) {
		Collection<FieldError> fs = new HashSet<>();
		if("".equals(nameorphone)||nameorphone==null) {
			fs.add(new FieldError("name","昵称不能为空！"));
		}
		if("".equals(password)||password==null) {
			fs.add(new FieldError("password","密码不能为空！"));
		}
		 SmartUserMessages user;
		//判断传递过来的字符串是电话还是用户名
		//若是用户名则
		if(Character.isLetter(nameorphone.charAt(0))) {
			String name = nameorphone;
			user = userMessMapper.selectByname(name);
		}else {
		//若是电话则
		    String phone = nameorphone;
		    user = userMessMapper.selectByphone(phone);
		}
		if(user==null||!password.equals(user.getPassword())) {
			fs.add(new FieldError("user", "用户名或者密码错误！"));
		}
		if(!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		return user;
	}
	
}
