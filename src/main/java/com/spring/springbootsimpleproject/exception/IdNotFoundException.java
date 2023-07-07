package com.spring.springbootsimpleproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class IdNotFoundException extends Exception{

	String msg;

	public IdNotFoundException(String msg) {
		super(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
