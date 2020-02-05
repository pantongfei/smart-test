package com.briup.smart.mapper;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartPm;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartPmMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(SmartPm record);

    SmartPm selectByPrimaryKey(Integer pId);

    List<SmartPm> selectAll();

    int updateByPrimaryKey(SmartPm record);
    
    List<SmartPm> getRealtimeMessage();
    
    List<SmartPm> getHistoryMessage();

    List<SmartPm> getHistoryMinMessage();
    
	SmartPm selectlastpm25();
	
	SmartPm selectlast2pm25();
}