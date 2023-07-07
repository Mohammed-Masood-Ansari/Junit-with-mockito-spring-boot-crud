package com.spring.springbootsimpleproject.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.springbootsimpleproject.response.ResponseStructure;

import lombok.val;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public  ResponseEntity<ResponseStructure<String>> noIdFoundExceptio(IdNotFoundException exception) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setStatusMessage("given id is not present");
		responseStructure.setStatusDescription("dfghjkl;");
		responseStructure.setStatusData(exception.getMessage());
		
		return 
		new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatusCode.valueOf(404));
	}
}
