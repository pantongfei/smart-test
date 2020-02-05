package com.briup.smart.mapper;

import com.briup.smart.bean.SmartFire;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartFireMapper {
    int deleteByPrimaryKey(Integer fireId);

    int insert(SmartFire record);

    SmartFire selectByPrimaryKey(Integer fireId);

    List<SmartFire> selectAll();

    int updateByPrimaryKey(SmartFire record);
    
    List<SmartFire> getRealtimeMessage();
    
    List<SmartFire> getHistoryMessage();

	SmartFire selectlastfire();
	
	SmartFire selectlast2fire();
}