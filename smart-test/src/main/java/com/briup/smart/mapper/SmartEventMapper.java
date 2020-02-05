package com.briup.smart.mapper;

import com.briup.smart.bean.SmartEvent;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SmartEventMapper {
	int deleteByPrimaryKey(Integer id);
    int insert(SmartEvent record);
    //SmartEvent selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(SmartEvent record);
	List<SmartEvent> selectAll();
    List<SmartEvent> selectthree(@Param("content")String content,@Param("type")String type,@Param("daytime")Date daytime);
	List<SmartEvent> selectByDay(Date daytime);
	int updateid(Integer id);
}