package com.briup.smart.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Client {
	// 请求获取主机返回的数据
	//public void client() 
	public static void main(String[] args){
		try (
				//Socket client = new Socket("10.0.0.101", 4196); 
				Socket client = new Socket("4s.net579.com", 29471); 
				OutputStream os = client.getOutputStream();
				InputStream is = client.getInputStream();
			) {
			    String message = "";
			    String machineCode = "1906010E"; 
			    String fixedByte = "CDB8B4AB";
			    String tempAddress = "1A19071008";
			    String requestData = "8686860F";
			   /* message =  machineCode + fixedByte +tempAddress+requestData;
			    os.write(Client.toBytes(message));
			   */
			    while(true) {
			    byte[] b = new byte[100];
			    int line = is.read(b);
			    
			    int by=-1;
			   /* while((by=is.read())!=0x0F) {
			    	System.out.println("by - >"+Integer.toHexString(by));
			    }*/
			    byte[] data = new byte[27];
			    System.arraycopy(b, 0, data, 0, 27);
			    String result = Client.bytesToHexString(data);
			    System.out.println(result);
			    if(!result.equals("000000000000000000000000000000000000000000000000000000")) {
			    	/*String s = "1A19071008";
			    	String str= result.substring(0,10);
			    	if(s.equals(str)) {
			    		ParsingData.parsingData(result);
			    	}*/
			    	ParsingData.parsingData(result);
			        System.out.println("---------------------"+result);
			    }
			    }
			    
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 将16进制字符串转换为byte[]
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] toBytes(String str) {
		if (str == null || str.trim().equals("")) {
			return new byte[0];
		}

		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}

		return bytes;
	}
	 /**
	  * 数组转换成十六进制字符串
	  * @param byte[]
	  * @return HexString
	  */
	 public static final String bytesToHexString(byte[] bArray) {
	  StringBuffer sb = new StringBuffer(bArray.length);
	  String sTemp;
	  for (int i = 0; i < bArray.length; i++) {
	   sTemp = Integer.toHexString(0xFF & bArray[i]);
	   if (sTemp.length() < 2)
	    sb.append(0);
	   sb.append(sTemp.toUpperCase());
	  }
	  return sb.toString();
	 }
}
