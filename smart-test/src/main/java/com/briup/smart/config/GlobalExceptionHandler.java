package com.briup.smart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.web.vm.Response;

@Configuration
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataValidFailedException.class)
	@ResponseBody
	public Response<String> dataValidFailed(DataValidFailedException e){
		e.printStackTrace();
		return Response.error(e.getErrors());
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Response<String> afterException(Exception e){
		e.printStackTrace();
		return Response.error("unexpect_error", "内部错误，请联系管理员！", e.getMessage());
	}
}
