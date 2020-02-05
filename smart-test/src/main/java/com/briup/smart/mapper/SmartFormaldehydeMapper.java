package com.briup.smart.mapper;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartFormaldehyde;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SmartFormaldehydeMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(SmartFormaldehyde record);

    SmartFormaldehyde selectByPrimaryKey(Integer fId);

    List<SmartFormaldehyde> selectAll();

    int updateByPrimaryKey(SmartFormaldehyde record);
    
    List<SmartFormaldehyde> getRealtimeMessage();

	SmartFormaldehyde selectlastformaldehyde();
	
	SmartFormaldehyde selectlast2formaldehyde();
}