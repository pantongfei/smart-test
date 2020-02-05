package com.briup.smart.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.smart.bean.SmartRole;
import com.briup.smart.mapper.SmartRoleMapper;

@Service
public class PermissionService {
	@Autowired
	private SmartRoleMapper rolemapper;

	public List<SmartRole> findRoleById() {
		// TODO Auto-generated method stub
		// System.out.println(rolemapper);
		List<SmartRole> roles = rolemapper.selectAllRoleMess();
		return roles;
	}

	public List<SmartRole> selectMenuByRoleName(String name){ 
		  List<SmartRole> selectMenuByRoleName = rolemapper.selectMenuByRoleName(name);
		  return selectMenuByRoleName;
	}

	public void updatePermission(int id, List<Integer> list) {
		// TODO Auto-generated method stub
		for (Integer i : list) {
			rolemapper.updatePermissById(id, i);
		}
	}

	public void deletePermission(int id, List<Integer> list) {
		// TODO Auto-generated method stub
		for (Integer i : list) {
			rolemapper.deletePermissById(id, i);
		}
	}

	public Integer selectidByName(String name) {
		return rolemapper.selectIdByName(name);
	}
}
