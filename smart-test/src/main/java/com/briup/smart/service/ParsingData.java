package com.briup.smart.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.briup.smart.bean.SmartCo2;
import com.briup.smart.bean.SmartFire;
import com.briup.smart.bean.SmartFormaldehyde;
import com.briup.smart.bean.SmartHumidity;
import com.briup.smart.bean.SmartPm;
import com.briup.smart.bean.SmartSql;
import com.briup.smart.bean.SmartTemperator;
import com.briup.smart.common.utils.dataSource.DataSourceUtils;
import com.briup.smart.mapper.SmartCo2Mapper;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class ParsingData {
	public static void parsingData(String s) {
		String s1 = "1A19071008";
    	String str= s.substring(0,10);
    	String s2 = "8A000001";
    	String str1 = s.substring(0,8);
    	if(s1.equals(str)) {
    		//1A19071008 003201  010601    001B01 001601 003401   002601      039101 0F
    		//           甲醛    有机物浓度      pm2.5     温度     湿度    空气质量指数      CO2浓度
    		//           mg/m³    mg/m³     mg/m³         ℃            %                   mg/m³    
    		//System.out.println("--------------------------------");
    		//System.out.println(s);
    		//System.out.println("--------------------------------");
    		String  data1 = s.substring(10, 14);
    		String  data2 = s.substring(16, 20);
    		String  data3 = s.substring(22, 26);
    		String  data4 = s.substring(28, 32);
    		String  data5 = s.substring(34, 38);
    		String  data6 = s.substring(40, 44);
    		String  data7 = s.substring(46, 50);
    		//数据项字段值
    	    int d1 = Integer.parseInt(data1.replaceAll("^0[x|X]", ""), 16);
    	    System.out.println("甲醛浓度"+d1);
    	    int d2 = Integer.parseInt(data2.replaceAll("^0[x|X]", ""), 16);
    	    int d3 = Integer.parseInt(data3.replaceAll("^0[x|X]", ""), 16);
    	    int d4 = Integer.parseInt(data4.replaceAll("^0[x|X]", ""), 16);
    	    int d5 = Integer.parseInt(data5.replaceAll("^0[x|X]", ""), 16);
    	    int d6 = Integer.parseInt(data6.replaceAll("^0[x|X]", ""), 16);
    	    int d7 = Integer.parseInt(data7.replaceAll("^0[x|X]", ""), 16);
    	    //判断报警信息
    	    AddWarning add = new AddWarning();
    	    add.getSelectFor(d1);
    	    add.getSelectOrganic(d2);
    	    add.getSelectPM(d3);
    	    add.getSelectTemp(d4);
    	    add.getSelectHumi(d5);
    	    add.getSelectAQI(d6);
    	    add.getSelectCO(d7);
    	    //数据项数据级别
    	    String[] levels = LevelService.levelJudge(d1, d3, d4, d5, d6, d7);
    	   /* String sd1 = String.valueOf(d1)+" mg/m³";
    	    String sd3 = String.valueOf(d3)+" mg/m³";
    	    String sd4 = String.valueOf(d4)+" ℃";
    	    String sd5 = String.valueOf(d5)+" %";
    	    String sd6 = String.valueOf(d6);
    	    String sd7 = String.valueOf(d7)+" mg/m³";*/
    	    //System.out.println(sd7);
    	    //System.out.println(getTime());
    	    //实时时间
    	    Date time = getTime();
    	   
    	  /*  SmartFormaldehyde jq = new SmartFormaldehyde(time,sd1,levels[0]);
    	    SmartCo2 co2 = new SmartCo2(time,sd7,levels[5]);
    	    SmartHumidity sd = new SmartHumidity(time,sd5,levels[3]);
    	    SmartPm pm = new SmartPm(time,sd3,levels[1]);
    	    SmartSql sq = new SmartSql(time,sd6,levels[4]);
    	    SmartTemperator wd = new SmartTemperator(time,sd4,levels[2]);*/
    	    
    	    //连接数据库，保存数据记录
    	    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    	    String sql = "insert into smart_co2(c_time,c_value,c_level) values(?,?,?)";
    	           try {
					   qr.update(sql,time,d7,levels[5]);
					   System.out.println("-----------------------------");
					 sql = "insert into smart_formaldehyde(f_time,f_value,f_level) values(?,?,?)";
	    	           qr.update(sql,time,d1,levels[0]);
	    	           
	    	           sql = "insert into smart_humidity(h_time,h_value,h_level) values(?,?,?)";
	    	           qr.update(sql,time,d5,levels[3]);
	    	           
	    	           sql = "insert into smart_pm(p_time,p_value,p_level) values(?,?,?)";
	    	           qr.update(sql,time,d3,levels[1]);
	    	           
	    	           sql = "insert into smart_sql(s_time,s_value,s_level) values(?,?,?)";
	    	           qr.update(sql,time,d6,levels[4]);
	    	           
	    	           sql = "insert into smart_temperator(t_time,t_value,t_level) values(?,?,?)";
	    	           qr.update(sql,time,d4,levels[2]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    	           
    	          
    	           
    	    
     	}else if(str1.equals(s2)) {
     		  AddWarning add = new AddWarning();
     		  //String st = "网络连接异常/数据采集失败";
      	      add.getDevice();
     		
     		
     	}else{
    	             Date time = getTime();
    	             QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    	        	 if(s.equals("FFFFFFFF0300020F")) {
    	        		  String ss1 = "可燃气体泄露";
    	        		  String sql = "insert into smart_fire(fire_time,fire_status) values(?,?)";
    	        		  try {
							qr.update(sql,time,ss1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	        	 }else if(s.equals("FFFFFFFF0500020F")) {
    	        		  String ss2 = "烟雾警告";
    	        		  String sql = "insert into smart_smog(s_time,s_status) values(?,?) ";
    	        		  try {
							qr.update(sql,time,ss2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	        	 }else {
    	     		        String ss1 = "可燃气体未泄露";
    	     		        String ss2 = "烟雾正常";
    	     		        String sql = "insert into smart_fire(fire_time,fire_status) values(?,?)";
    	     		        try {
								qr.update(sql,time,ss1);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    	     		               sql = "insert into smart_smog(s_time,s_status) values(?,?) ";
    	     		            try {
									qr.update(sql,time,ss2);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
    	     		        
    	     	}
    	         
     	}
	}
	  private static Date getTime() {
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
	    }
}
