package com.briup.smart.service;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.smart.bean.Warning;
import com.briup.smart.mapper.WarningMapper;

public class AddWarning {
	public Connection getCon() {
		String username="root";
		String password="root";
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://47.102.205.67:3306/smart_sxnd?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
		Connection conn = null;
		try {
			Class.forName(driver);
            conn=(Connection) DriverManager.getConnection(url,username,password);
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	
	public  void getSelectTemp(int temp){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time, d_time) values(?,?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(temp>=0&&temp<16) {
        		String device = "温度";
        		String WarningType="数据异常";
        		String WarningLevel="低温";
        		String WarningContent="温度低于16℃低温警告";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		}else if (temp<=0) {
        			String device = "温度";
            		String WarningType="数据异常";
            		String WarningLevel="寒冷";
            		String WarningContent="温度低于0℃寒冷警告";
            		String state="未确认";       		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}else if(temp>=35&&temp<37) {
            		String device = "温度";
            		String WarningType="数据异常";
            		String WarningLevel="高温";
            		String WarningContent="温度超过35度高温警告";
            		String state="未确认";        		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
            	}else if (temp>=37&&temp<40) {
            		String device = "温度";
            		String WarningType="数据异常";
            		String WarningLevel="炎热";
            		String WarningContent="温度超过37度炎热警告,注意防暑";
            		String state="未确认";
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();       		
    			}else if (temp>=40) {
    				String device = "温度";
            		String WarningType="数据异常";
            		String WarningLevel="酷热";
            		String WarningContent="温度超过40度酷热警告,极易中暑";
            		String state="未确认";
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();		
			}       	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	public  void getSelectFor(int formald){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(formald>=100) {
        		String device = "甲醛";
        		String WarningType="数据异常";
        		String WarningLevel="甲醛浓度超标";
        		String WarningContent="甲醛浓度过高,注意及时处理";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	public  void getSelectOrganic(int Organic){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(Organic>=100) {
        		String device = "有机物";
        		String WarningType="数据异常";
        		String WarningLevel="有机物浓度超标";
        		String WarningContent="有机物浓度过高,注意及时通风处理";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	public  void getSelectPM(int pm){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(pm>=75&&pm<115) {
        		String device = "PM2.5";
        		String WarningType="数据异常";
        		String WarningLevel="轻度污染";
        		String WarningContent="PM2.5含量超标,请注意!";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		}else if (pm>=115&&pm<150) {
        			String device = "PM2.5";
            		String WarningType="数据异常";
            		String WarningLevel="中度污染";
            		String WarningContent="PM2.5含量大量超标,请及时处理";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}else if (pm>=150&&pm<250) {
					String device = "PM2.5";
            		String WarningType="数据异常";
            		String WarningLevel="重度污染";
            		String WarningContent="PM2.5含量重度超标,危!";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}else if (pm>=250) {
					String device = "PM2.5";
            		String WarningType="数据异常";
            		String WarningLevel="严重污染";
            		String WarningContent="PM2.5含量严重超标,危!!!!!!!";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	public  void getSelectHumi(int hum){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(hum>=80) {
        		String device = "湿度";
        		String WarningType="数据异常";
        		String WarningLevel="过于潮湿";
        		String WarningContent="湿度过高，请降低湿度";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		}else if (hum<30) {
        			String device = "湿度";
            		String WarningType="数据异常";
            		String WarningLevel="过于干燥";
            		String WarningContent="湿度过低，请提高湿度";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	public  void getSelectAQI(int aqi){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(aqi>=101&&aqi<151) {
        		String device = "空气质量指数";
        		String WarningType="数据异常";
        		String WarningLevel="轻度污染";
        		String WarningContent="空气质量轻度污染,请注意!";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		}else if (aqi>=150&&aqi<201) {
        			String device = "空气质量指数";
            		String WarningType="数据异常";
            		String WarningLevel="中度污染";
            		String WarningContent="空气质量中度污染,请及时处理";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}else if (aqi>=201&&aqi<301) {
					String device = "空气质量指数";
            		String WarningType="数据异常";
            		String WarningLevel="重度污染";
            		String WarningContent="空气质量重度污染,危!";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}else if (aqi>=301) {
					String device = "空气质量指数";
            		String WarningType="数据异常";
            		String WarningLevel="严重污染";
            		String WarningContent="空气质量严重污染,危!!!!!!!";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	public  void getSelectCO(int co2){
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
			if(co2>=2000&&co2<5000) {
        		String device = "二氧化碳";
        		String WarningType="数据异常";
        		String WarningLevel="二氧化碳浓度超标";
        		String WarningContent="二氧化碳浓度过高,注意及时通风";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
        		}else if (co2>=5000) {
        			String device = "二氧化碳";
            		String WarningType="数据异常";
            		String WarningLevel="二氧化碳严重超标";
            		String WarningContent="二氧化碳浓度严重超标,请检查是否相关设施出问题";
            		String state="未确认";      		
            		ps.setString(1,device);
            		ps.setString(2,WarningType);
            		ps.setString(3,WarningLevel);
            		ps.setString(4,WarningContent);
            		ps.setString(5,state);
            		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
            		ps.execute();
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	
	public void getDevice() {
		String sql = "insert into smart_warning ( device, Warning_type, Warning_level, Warning_content, state, time) values(?,?,?,?,?,?)";
		Connection conn = getCon();
		PreparedStatement ps;
		//Date time = getTime();
		try {
			ps = conn.prepareStatement(sql);
        		String device = "环境监测传感器";
        		String WarningType="设备异常";
        		String WarningLevel="连接异常";
        		String WarningContent="连接异常,未能读取环境监测数据";
        		String state="未确认";      		
        		ps.setString(1,device);
        		ps.setString(2,WarningType);
        		ps.setString(3,WarningLevel);
        		ps.setString(4,WarningContent);
        		ps.setString(5,state);
        		ps.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
        		ps.setTimestamp(7, new Timestamp((new java.util.Date()).getTime()));
        		ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}          	
	}
	/*private static Date getTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String time = df.format(date);
        try {
			date = df.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date;
    }*/
	//测试svn
}
