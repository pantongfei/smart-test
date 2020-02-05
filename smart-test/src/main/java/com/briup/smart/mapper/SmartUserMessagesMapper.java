package com.briup.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.smart.bean.SmartSql;
import com.briup.smart.bean.SmartUserMessages;

@Mapper
public interface SmartUserMessagesMapper {
	  int deleteByPrimaryKey(Long id);

	  int insert(SmartUserMessages record);

	  SmartUserMessages selectByPrimaryKey(Long id);

	  List<SmartUserMessages> selectAll();

	  int updateByPrimaryKey(SmartUserMessages record);
	  
	  Long selectId(String name,String password);

      void modifyUserRolebyId(Long id,String role_name);

	  SmartUserMessages selectByname(String name);

	  SmartUserMessages selectByphone(String phone);
	  
}
