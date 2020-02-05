package com.briup.smart.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.SmartFacility;
import com.briup.smart.common.utils.dataSource.DataSourceUtils;
import com.briup.smart.mapper.SmartFacilityMapper;

@Service
public class FacilitiesService {
	@Autowired
	private SmartFacilityMapper ficilitymapper;
	
	public void insertFacility(SmartFacility facility) {
		ficilitymapper.insert(facility);
	}
	public void deleteFacility(String name) {
		ficilitymapper.deleteByName(name);
	}
	public String recieveAndExe(String s) {
		System.out.println(s);
		client1(s);
		String s1 = null;
		if(s.equals("一路灯开")) {
			 s1 = "一路灯已开启";
		}
		if(s.equals("一路灯关")) {
			 s1 = "一路灯已关闭";
		}
		if(s.equals("二路灯开")) {
			 s1 = "二路灯已开启";
		}
		if(s.equals("二路灯关")) {
			 s1 = "二路灯已关闭";
		}
		if(s.equals("三路灯开")) {
			 s1 = "三路灯已开启";
		}
		if(s.equals("三路灯关")) {
			 s1 = "三路灯已关闭";
		}
		if(s.equals("窗帘开")) {
			 s1 = "窗帘已开启";
		}
		if(s.equals("窗帘关")) {
			 s1 = "窗帘已关闭";
		}
		if(s.equals("空调开")) {
			 s1 = "空调已开启";
		}
		if(s.equals("空调关")) {
			 s1 = "空调已关闭";
		}
		if(s.equals("门锁开")) {
			 s1 = "门锁已开启";
		}
		return s1;
	
		
	}
	public static void client1(String s) {
		try(  
				Socket client = new Socket("10.0.0.101", 4196);
				OutputStream os = client.getOutputStream();
			){
			    System.out.println(s);
				String message = "";
				String machineCode = "1906010E";
				String fixedByte = "CDB8B4AB";
				
				//String lightAddress1 = "1A18072804";
				//String lightAddress2 = "1A1809040A";
				//String lightAddress3 = "1A1807280B";
				
				//String lightOn = "0000010F";
				//String lightOff = "0000000F";
				String s1 = null;
				/*if(s.equals("一路灯开")) {
					s1 = "1A180728040000010F";
				}
				if(s.equals("一路灯关")) {
					s1 = "1A180728040000000F";
				}
				if(s.equals("二路灯开")) {
					s1 = "1A1809040A0000010F";
				}
				if(s.equals("二路灯关")) {
					s1 = "1A1809040A0000000F";
				}
				if(s.equals("三路灯开")) {
					s1 = "1A1807280B0000010F";
				}
				if(s.equals("三路灯关")) {
					s1 = "1A1807280B0000000F";
				}
				if(s.equals("窗帘开")) {
					s1 = "FFFFFFFFFF0000030F";
				}
				if(s.equals("窗帘关")) {
					s1 = "FFFFFFFFFF0001030F";
				}
				if(s.equals("空调开")) {
					s1 = "FFFFFFFF0000020F";
				}
				if(s.equals("空调关")) {
					s1 = "FFFFFFFF0000010F";
				}
				if(s.equals("门锁开")) {
					s1 = "0277287A011A0F";
				}*/
				  QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		    	  String sql = "select f_protocol from smart_facilities where f_action = ?";
		    	  try {
					 Map<String, Object> map = qr.query(sql, new MapHandler(),s);
					 System.out.println(map);
					 for (Object ss: map.values()) {
				          System.out.println("value= " + ss);
				          s1 = (String) ss;
			              }
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    	  
				message = machineCode + fixedByte + s1;
				System.out.println(message);
//				message = machineCode + fixedByte + lightAddress1 + lightOn;
//				message = machineCode + fixedByte + lightAddress1 + lightOff;
				
//				message = machineCode + fixedByte + lightAddress2 + lightOn;
//				message = machineCode + fixedByte + lightAddress2 + lightOff;
				
//				message = machineCode + fixedByte + lightAddress3 + lightOn;
//				message = machineCode + fixedByte + lightAddress3 + lightOff;
				
				os.write(Client.toBytes(message));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  
		}
	
}
