package com.briup.smart.mapper;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartTemperator;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartTemperatorMapper {
    int insert(SmartTemperator record);

    List<SmartTemperator> selectAll();
    
    List<SmartTemperator> getRealtimeMessage();
    
    List<SmartTemperator> getHistoryMessage();
    
    List<SmartTemperator> getHistoryMinMessage();

	SmartTemperator selectlasttemp();
	
	SmartTemperator selectlast2temp();
}