package com.briup.smart.service;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Warning;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.WarningMapper;
import com.briup.smart.web.vm.FieldError;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class WarningService {
	@Autowired
	private WarningMapper warMapper;
	@Transactional
	public void saveOrUpdate(Warning war) {
		Collection<FieldError> fs = new HashSet<>();
		if(!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		warMapper.updateByPrimaryKey(war);
	}
	
	/*public List<Warning> findWarningByContent(String warningContent) {
		Map<Object, Object> param = new HashMap<>();
		param.put("Warning_content", warningContent);
		param.put("Warning_Type", warningType);
		List<Warning> list1 = new ArrayList<>();
		list1 = warMapper.selectByWarningContent(warningContent);
		//Warning war = warMapper.selectByWarningContent(warningContent);
		return list1;
	}*/
	public int deleteUserById(Integer id) {
		return warMapper.deleteByPrimaryKey(id);
	}
	
	public PageInfo<Warning> getFindByPage(int pageNum,int pageSize,String warningContent,String warningType) throws ParseException{
		//DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		//Date dtime= sdf.parse(time);
		PageHelper.startPage(pageNum, pageSize, true);
		List<Warning> list2 = warMapper.selectByWarningContent(warningContent,warningType);
		if(list2==null||list2.isEmpty()) {
			list2 = new ArrayList<>();
		}
		return new PageInfo<>(list2);
	}
	
	public PageInfo<Warning> getAllByPage(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize, true);
		List<Warning> list = warMapper.selectAll();
		if(list==null||list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}
}
