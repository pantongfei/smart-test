package com.briup.smart.mapper;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartHumidity;
import com.briup.smart.bean.SmartPm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartHumidityMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(SmartHumidity record);

    SmartHumidity selectByPrimaryKey(Integer hId);

    List<SmartHumidity> selectAll();

    int updateByPrimaryKey(SmartHumidity record);
    
    List<SmartHumidity> getRealtimeMessage();
    
    List<SmartHumidity> getHistoryMessage();
    
    List<SmartHumidity> getHistoryMinMessage();

	SmartHumidity selectlasthum();
	
	SmartHumidity selectlast2hum();
}