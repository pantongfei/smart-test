package com.briup.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.smart.bean.SmartResource;
import com.briup.smart.bean.extend.SmartResourceExtend;

@Mapper
public interface SmartResourceMapper {
	  int deleteByPrimaryKey(Integer id);

	  int insert(SmartResource record);

	  SmartResource selectByPrimaryKey(Integer id);

	  List<SmartResource> selectAll();

	  int updateByPrimaryKey(SmartResource record);
	    
	  //根据角色查找能够访问的用户资源
	  List<SmartResourceExtend> selectByRoleId(Integer roldId);
}
