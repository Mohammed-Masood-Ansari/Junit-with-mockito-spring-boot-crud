package com.spring.springbootsimpleproject.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {

	private int statusCode;
	private String statusMessage;
	private String statusDescription;
	private T statusData;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public T getStatusData() {
		return statusData;
	}
	public void setStatusData(T statusData) {
		this.statusData = statusData;
	}
}
