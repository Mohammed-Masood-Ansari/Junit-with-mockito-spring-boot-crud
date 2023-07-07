package com.spring.springbootsimpleproject.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student implements Comparable<Student>{
	
	@Id
	private int studentId;
	private String studentName;
	private String StudentEmail;
	private long studentPhone;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public long getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}
	@Override
	public int compareTo(Student o) {
		
		return this.studentName.compareTo(o.studentName);
	}
	
	
}
