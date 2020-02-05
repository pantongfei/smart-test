package com.briup.smart.mapper;

import com.briup.smart.bean.SmartSmog;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartSmogMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(SmartSmog record);

    SmartSmog selectByPrimaryKey(Integer sId);

    List<SmartSmog> selectAll();

    int updateByPrimaryKey(SmartSmog record);
    
    List<SmartSmog> getRealtimeMessage();
    
    List<SmartSmog> getHistoryMessage();

	SmartSmog selectlastsmog();
	
	SmartSmog selectlast2smog();
}