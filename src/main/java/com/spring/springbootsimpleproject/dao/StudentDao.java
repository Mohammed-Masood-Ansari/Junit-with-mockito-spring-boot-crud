package com.spring.springbootsimpleproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.springbootsimpleproject.dto.Student;
import com.spring.springbootsimpleproject.repository.EmployeeRespository;
import com.spring.springbootsimpleproject.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository ;
	/*
	 * save method
	 */
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	/*
	 * getStudentById
	 */
	public Student getStudentById(int studentId) {
	
		Optional<Student> optional=studentRepository.findById(studentId);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}else
			return null;
	}
	
	/*
	 * displayAllStudent
	 */
	public List<Student> displStudents(){
		
		return studentRepository.findAll();
	}
	
	/*
	 * delete studentById
	 */
	public void deleteStudentById(int studentId) {
		
		Student student=getStudentById(studentId);
		
		studentRepository.delete(student);
	}
	
	/*
	 * updateStudent
	 */
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	/*
	 * getStudentByPhone
	 */
	public Student getStudentByPhone(long studentPhone) {
		
		return studentRepository.getByStudentPhone(studentPhone);
	}
	public void updateStudentById(String studentName,int studentId) {
		
		studentRepository.updateStudentById(studentName, studentId);
	}
	
	public List<Student> ascendingOrder(){
		return  studentRepository.ascendingOrder();
	}
}
