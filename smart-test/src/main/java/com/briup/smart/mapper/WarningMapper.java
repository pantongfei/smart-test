package com.briup.smart.mapper;

import com.briup.smart.bean.Warning;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WarningMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warning record);

    Warning selectByPrimaryKey(Integer id);

    List<Warning> selectAll();

    int updateByPrimaryKey(Warning record);
    
    List<Warning> selectByWarningContent(@Param("Warning_content")String warningContent,@Param("Warning_type")String warningType);
    
    int selectCount();

	//List<Warning> selectByWarningContent1(Warning warningContent);
}