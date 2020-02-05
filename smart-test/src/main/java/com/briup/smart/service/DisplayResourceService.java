package com.briup.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.extend.SmartResourceExtend;
import com.briup.smart.mapper.SmartResourceMapper;

@Service
public class DisplayResourceService {
	@Autowired
	private SmartResourceMapper resourceMapper;
	@Transactional
	public List<SmartResourceExtend> findByRoldId(Integer roldId) {
		// TODO Auto-generated method stub
		return resourceMapper.selectByRoleId(roldId);
	}
}
