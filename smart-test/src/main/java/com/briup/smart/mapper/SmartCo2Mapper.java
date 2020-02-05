package com.briup.smart.mapper;

import com.briup.smart.bean.SmartCo2;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartCo2Mapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(SmartCo2 record);

    SmartCo2 selectByPrimaryKey(Integer cId);

    List<SmartCo2> selectAll();

    int updateByPrimaryKey(SmartCo2 record);
    
    List<SmartCo2> getRealtimeMessage();
    
    List<SmartCo2> getHistoryMessage();
    
    List<SmartCo2> getHistoryMinMessage();

	SmartCo2 selectlastco2();
	
	SmartCo2 selectlast2co2();
}