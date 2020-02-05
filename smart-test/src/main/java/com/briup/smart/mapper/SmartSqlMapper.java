package com.briup.smart.mapper;

import com.briup.smart.bean.SmartPm;
import com.briup.smart.bean.SmartSql;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartSqlMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(SmartSql record);

    SmartSql selectByPrimaryKey(Integer sId);

    List<SmartSql> selectAll();

    int updateByPrimaryKey(SmartSql record);
    
    List<SmartSql> getRealtimeMessage();
    
    List<SmartSql> getHistoryMessage();

	SmartSql selectlastsql();
	
	SmartSql selectlast2sql();
}