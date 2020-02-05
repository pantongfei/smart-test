package com.briup.smart.service.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.SmartUserMessages;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.SmartUserMessagesMapper;
import com.briup.smart.web.vm.FieldError;

//用来实现自定义登陆逻辑
/**
 * 
 * <p>
 *      security 自定义登陆逻辑类
 *      用来做登陆认证，验证用户名与密码
 * </p>
 * 
 * @author  
 *
 */
/*@Service
public class UserDetailService {
	@Autowired
	private SmartUserMessagesMapper userMessMapper;
	
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
*/