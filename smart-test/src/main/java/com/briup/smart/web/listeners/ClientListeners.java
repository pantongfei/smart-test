package com.briup.smart.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.briup.smart.service.Client1;
@WebListener
public class ClientListeners implements ServletContextListener{
	@Autowired
	private Client1 client1;
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("启动，，，，，，，，，，，，");
		System.out.println(client1);
		client1.gatherTest();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("销毁");
	}
}
