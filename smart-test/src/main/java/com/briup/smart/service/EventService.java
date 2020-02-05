package com.briup.smart.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.smart.bean.SmartEvent;
import com.briup.smart.mapper.SmartFormaldehydeMapper;
import com.briup.smart.mapper.SmartCo2Mapper;
import com.briup.smart.mapper.SmartEventMapper;
import com.briup.smart.mapper.SmartFireMapper;
import com.briup.smart.mapper.SmartHumidityMapper;
import com.briup.smart.mapper.SmartPmMapper;
import com.briup.smart.mapper.SmartSmogMapper;
import com.briup.smart.mapper.SmartSqlMapper;
import com.briup.smart.mapper.SmartTemperatorMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EventService {
	@Autowired
	private SmartEventMapper eventMapper;
	@Autowired
	private SmartCo2Mapper co2Mapper;
	@Autowired
	private SmartHumidityMapper humMapper;
	@Autowired
	private SmartPmMapper pm25Mapper;
	@Autowired
	private SmartTemperatorMapper tempMapper;
	@Autowired
	private SmartFormaldehydeMapper formaldehydeMapper;
	@Autowired
	private SmartFireMapper fireMapper;
	@Autowired
	private SmartSqlMapper sqlMapper;
	@Autowired
	private SmartSmogMapper smogMapper;
	
	//甲醛
	public int save_Data_formaldehyde() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		int a = (formaldehydeMapper.selectlastformaldehyde()).getfValue();
		int b = (formaldehydeMapper.selectlast2formaldehyde()).getfValue();
		if(a<b) {
			int c = b-a;
			if(c>a*0.2) {
				String str = "甲醛浓度由"+b+"变为"+a;
				event.setContent(str);
			}else {
				return 0;
			}
		}else if(a>b) {
			int c = a-b;
			if(c>a*0.2) {
				String str = "甲醛浓度由"+b+"变为"+a;
				event.setContent(str);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_fire() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		String a = (fireMapper.selectlastfire()).getFireStatus();
		String b = (fireMapper.selectlast2fire()).getFireStatus();
		if(a!=b) {
			String str =  "火光由"+b+"变为"+a;
			event.setContent(str);
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_Sql() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		int a = (sqlMapper.selectlastsql()).getsValue();
		int b = (sqlMapper.selectlast2sql()).getsValue();
		if(a<b) {
			int c = b-a;
			if(c>a*0.2) {
				String str = "空气质量指数由"+b+"lx变为"+a+"lx";
				event.setContent(str);
			}else {
				return 0;
			}
		}else if(a>b) {
			int c = a-b;
			if(c>a*0.2) {
				String str = "空气质量指数由"+b+"lx变为"+a+"lx";
				event.setContent(str);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_smoke() {

		SmartEvent event=new SmartEvent();
		String a = (smogMapper.selectlastsmog()).getsStatus();
		String b = (smogMapper.selectlast2smog()).getsStatus();
		if(a!=b) {
			String str =  "烟雾状态由"+b+"变为"+a;
			event.setContent(str);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_pm25() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		int a = (pm25Mapper.selectlastpm25()).getpValue();
		int b = (pm25Mapper.selectlast2pm25()).getpValue();
		if(a<b) {
			int c = b-a;
			if(c>a*0.2) {
				String str = "PM2.5浓度由"+b+"ug/m^3变为"+a+"ug/m^3";
				event.setContent(str);
			}else {
				return 0;
			}
		}else if(a>b) {
			int c = a-b;
			if(c>a*0.2) {
				String str = "PM2.5浓度由"+b+"ug/m^3变为"+a+"ug/m^3";
				event.setContent(str);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_co2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		int a = (co2Mapper.selectlastco2()).getcValue();
		int b = (co2Mapper.selectlast2co2()).getcValue();
		if(a<b) {
			int c = b-a;
			if(c>a*0.2) {
				String str = "二氧化碳浓度由"+b+"ppm变为"+a+"ppm";
				event.setContent(str);
			}else {
				return 0;
			}
		}else if(a>b) {
			int c = a-b;
			if(c>a*0.2) {
				String str = "二氧化碳浓度由"+b+"ppm变为"+a+"ppm";
				event.setContent(str);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_hum() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		int a = (humMapper.selectlasthum()).gethValue();
		int b = (humMapper.selectlast2hum()).gethValue();
		if(a<b) {
			int c = b-a;
			if(c>a*0.2) {
				String str = "湿度由"+b+"%变为"+a+"%";
				event.setContent(str);
			}else {
				return 0;
			}
		}else if(a>b) {
			int c = a-b;
			if(c>a*0.2) {
				String str = "湿度由"+b+"%变为"+a+"%";
				event.setContent(str);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public int save_Data_temp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		int a = (tempMapper.selectlasttemp()).gettValue();
		int b = (tempMapper.selectlast2temp()).gettValue();
		if(a<b) {
			int c = b-a;
			if(c>a*0.2) {
				String str = "温度由"+b+"℃变为"+a+"℃";
				event.setContent(str);
			}else {
				return 0;
			}
		}else if(a>b) {
			int c = a-b;
			if(c>a*0.2) {
				String str = "温度由"+b+"℃变为"+a+"℃";
				event.setContent(str);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setType("数据变化");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return 0;
	}
	
	public SmartEvent save_UsAct() {
		String act = "打开门";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SmartEvent event=new SmartEvent();
		String username = "张三";
		
		String str=username+act;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			
			event.setId(null);
			event.setContent(str);
			event.setType("用户操作");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return event;
	}
	
	public SmartEvent save_Linkage() {
		String condition = "温度联动触发操作_";
		String act = "开空调";
		SmartEvent event=new SmartEvent();
		String str=condition+act;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		try {
			Date dt = sdf.parse(df.format(d));
			event.setId(null);
			event.setContent(str);
			event.setType("联动触发");
			event.setTime(t);
			event.setDaytime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventMapper.insert(event);
		return event;
	}
	
	public List<SmartEvent> selectBydate(String day) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date daytime = sdf.parse(day);
			List<SmartEvent> list = eventMapper.selectByDay(daytime);
			if(list==null||list.isEmpty()) {
				list = new ArrayList<>();
			}
		return list;
	}
	public List<SmartEvent> selectAll(){
		List<SmartEvent> list  = eventMapper.selectAll();
		return list;
	}

//	public List<SmartEvent> selectContent(String content) {
//			if(content!=null&&content!="") {
//				String mes = "where content like CONCAT(\'%\',#{content,jdbcType=VARCHAR},\'%\')";
//				List<SmartEvent> list = eventMapper.selectContent(content, mes);
//				return list;
//			}
//			String mes = null;
//			List<SmartEvent> list = eventMapper.selectContent(content, mes);
//			return list;
//	}
//	public SmartEvent findEventById(Integer id) {
//		SmartEvent event = eventMapper.selectByPrimaryKey(id);
//		return event;
//	}
	public int deleteEventById(Integer id) {
		int a = eventMapper.deleteByPrimaryKey(id);
		eventMapper.updateid(id);
		return a;
	}
//	public int updateById(Integer id) {
//		int a  = eventMapper.updateid(id);
//		return a;
//	}
	public PageInfo<SmartEvent> selectByPage(int pageNum,int pageSize,String content,String type,String day) throws ParseException{
		PageHelper.startPage(pageNum, pageSize, true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date daytime =  sdf.parse(day);
		List<SmartEvent> list=eventMapper.selectthree(content, type, daytime);
		if(list==null||list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}
}
