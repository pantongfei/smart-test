package com.briup.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SmartTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTestApplication.class, args);
	}

}
