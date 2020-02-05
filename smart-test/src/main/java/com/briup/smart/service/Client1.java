package com.briup.smart.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class Client1{
	
	public void gatherTest() {
		System.out.println("这是gatherTest1,,,,,,,,,,,,,,,,,,");
		try {
				//Socket client = new Socket("10.0.0.101", 4196);
				Socket client = new Socket("4s.net579.com", 29471);
				OutputStream os = client.getOutputStream();
				//InputStream is = client.getInputStream();
				BufferedInputStream bis=new BufferedInputStream(client.getInputStream());
				
			    new Thread() {
			    	public void run() {
			    		while(true) {
						  try {
							  byte[] b = new byte[100];
							  int line = bis.read(b);
							  System.out.println("line，，，，，，，，，，，"+line);
							  //while(line!=-1) {
							  //int line = is.read(b);
								System.out.println("我已经陷入了死循环，，，，，");
							   /* while((by=is.read())!=0x0F) {
							    	System.out.println("by - >"+Integer.toHexString(by));
							    }*/
							    byte[] data = new byte[27];
							    System.arraycopy(b, 0, data, 0, 27);
							    String result = Client1.bytesToHexString(data);
							    
							    if(!result.equals("000000000000000000000000000000000000000000000000000000")) {
							    	ParsingData.parsingData(result);
							        System.out.println("---------------------"+result);
							    }
			    			//}
						    }catch (Exception e) {
								e.printStackTrace();
							}
			    		}
			    	};
			    }.start();
			    
			    
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	/*
	 * 将16进制字符串转化为byte[]
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
