package com.briup.smart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartFire;
import com.briup.smart.bean.SmartFormaldehyde;
import com.briup.smart.bean.SmartHumidity;
import com.briup.smart.bean.SmartPm;
import com.briup.smart.bean.SmartSmog;
import com.briup.smart.bean.SmartSql;
import com.briup.smart.bean.SmartTemperator;
import com.briup.smart.mapper.SmartCo2Mapper;
import com.briup.smart.mapper.SmartFireMapper;
import com.briup.smart.mapper.SmartFormaldehydeMapper;
import com.briup.smart.mapper.SmartHumidityMapper;
import com.briup.smart.mapper.SmartPmMapper;
import com.briup.smart.mapper.SmartSmogMapper;
import com.briup.smart.mapper.SmartSqlMapper;
import com.briup.smart.mapper.SmartTemperatorMapper;
import com.briup.smart.mapper.SmartUserMapper;

@Service
public class EnvironmentService {
	@Autowired
	private SmartCo2Mapper co2mapper;
	@Autowired
	private SmartFireMapper fireMapper;
	@Autowired
	private SmartFormaldehydeMapper formaldehydeMapper;
	@Autowired
	private SmartHumidityMapper humidityMapper;
	@Autowired
	private SmartPmMapper pmMapper;
	@Autowired
	private SmartSmogMapper smogMapper;
	@Autowired
	private SmartSqlMapper sqlMapper;
	@Autowired
	private SmartTemperatorMapper temMapper;
	
	@Transactional
	public void saveEnvironMess(SmartCo2 co2,SmartFormaldehyde formaldehyde,SmartHumidity humidity,
			SmartPm pm,SmartSql sql,SmartTemperator tem) {
		co2mapper.insert(co2);
		formaldehydeMapper.insert(formaldehyde);
		humidityMapper.insert(humidity);
		pmMapper.insert(pm);
		sqlMapper.insert(sql);
		temMapper.insert(tem);
		
		//fireMapper.insert(fire);
		//smogMapper.insert(smog);
	}
	@Transactional
	public List getRealtimeMess() {
		List<SmartCo2> co2s = co2mapper.getRealtimeMessage();
		List<SmartHumidity> sds = humidityMapper.getRealtimeMessage();
		List<SmartPm> pms = pmMapper.getRealtimeMessage();
		List<SmartSql> sqs = sqlMapper.getRealtimeMessage();
		List<SmartFormaldehyde> jqs = formaldehydeMapper.getRealtimeMessage();
		List<SmartTemperator> wds = temMapper.getRealtimeMessage();
		List<SmartFire> fire = fireMapper.getRealtimeMessage();
		List<SmartSmog> smog = smogMapper.getRealtimeMessage();
		List l = new ArrayList<>();
		l.add(co2s);
		l.add(sds);
		l.add(pms);
		l.add(sqs);
		l.add(jqs);
		l.add(wds);
		l.add(fire);
		l.add(smog);
		return l;
	}
	@Transactional
	public List getHistoryMess() {
		List<SmartCo2> co2s = co2mapper.getHistoryMessage();
		//System.out.println(co2s);
		List<SmartHumidity> sds = humidityMapper.getHistoryMessage();
		List<SmartPm> pms = pmMapper.getHistoryMessage();
		List<SmartTemperator> wd = temMapper.getHistoryMessage();
		//List<SmartSql> sql = sqlMapper.getHistoryMessage();
		List<SmartFire> fire = fireMapper.getHistoryMessage();
		List<SmartSmog> smog = smogMapper.getHistoryMessage();
		List l = new ArrayList<>();
		l.add(wd);
		l.add(sds);
		l.add(co2s);
		l.add(pms);
		//l.add(sql);
		l.add(fire);
		l.add(smog);
		return l;
		
	}
	/*public List getHistoryMinMess() {
		// TODO Auto-generated method stub
		List<SmartCo2> co2s = co2mapper.getHistoryMinMessage();
		List<SmartHumidity> sds = humidityMapper.getHistoryMinMessage();
		List<SmartPm> pms = pmMapper.getHistoryMinMessage();
		List<SmartTemperator> wd = temMapper.getHistoryMinMessage();
		List l = new ArrayList<>();
		l.add(wd);
		l.add(sds);
		l.add(co2s);
		l.add(pms);
		return l;
	}*/
	
}
