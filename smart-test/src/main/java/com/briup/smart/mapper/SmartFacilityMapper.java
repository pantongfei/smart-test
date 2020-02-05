package com.briup.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartFacility;
import com.briup.smart.bean.SmartUserMessages;

@Mapper
public interface SmartFacilityMapper {
	int deleteByPrimaryKey(Integer fId);

    int insert(SmartFacility record);

    SmartCo2 selectByPrimaryKey(Integer fId);

    List<SmartFacility> selectAll();

    int updateByPrimaryKey(SmartFacility record);
    
    int deleteByName(String name);
}
