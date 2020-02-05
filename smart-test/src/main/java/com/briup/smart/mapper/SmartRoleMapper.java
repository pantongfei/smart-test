package com.briup.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.smart.bean.SmartRole;

@Mapper
public interface SmartRoleMapper {
	    int deleteByPrimaryKey(Integer roleId);

	    int insert(SmartRole record);

	    SmartRole selectByPrimaryKey(Integer roleId);

	    List<SmartRole> selectAll();

	    int updateByPrimaryKey(SmartRole record);
	    
	    List<SmartRole> selectAllRoleMess();
	    
	    List<SmartRole> selectMenuByRoleName(String name);

		int updatePermissById(int id,int rid);

		int deletePermissById(int id, Integer i);

		Integer selectIdByName(String name);
}
