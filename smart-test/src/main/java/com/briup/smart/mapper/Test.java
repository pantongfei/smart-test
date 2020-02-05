package com.briup.smart.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.briup.smart.common.utils.dataSource.DataSourceUtils;

public class Test {
	public static void test(String s){
		 String s1 = null;
		 QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	  	  String sql = "select f_protocol from smart_facilities where f_action = ? ";
	  	  try {
				 Map<String, Object> map = qr.query(sql, new MapHandler(),s);
				 for (Object ss: map.values()) {
			          System.out.println("value= " + ss);
			          s1 = (String) ss;
		              }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  System.out.println(s1);
	}
	public static void main(String[] args) {
	      Test.test("一路灯开");
  	       
}
}
