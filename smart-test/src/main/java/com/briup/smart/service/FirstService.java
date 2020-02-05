package com.briup.smart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.briup.smart.bean.SmartUser;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.SmartUserMapper;
import com.briup.smart.web.vm.FieldError;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FirstService {
	@Autowired
	private SmartUserMapper userMapper;
	@Transactional
	public void saveOrUpdate(SmartUser user) {
		Collection<FieldError> fs = new HashSet<>();
		if("".equals(user.getName())||user.getName()==null) {
			fs.add(new FieldError("name","用户名不能为空！"));
		}
		if(user.getAge()>=18) {
			fs.add(new FieldError("age", "年龄必须小于18岁！"));
		}
		if(!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		if(user.getId()!=null) {
			userMapper.updateByPrimaryKey(user);
		}else {
			userMapper.insert(user);
		}
	}
	
	public SmartUser findUserById(Long id) {
		SmartUser user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	
	public int deleteUserById(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}
	
	public PageInfo<SmartUser> getAllByPage(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize, true);
		List<SmartUser> list= userMapper.selectAll();
		if(list==null||list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}
}
