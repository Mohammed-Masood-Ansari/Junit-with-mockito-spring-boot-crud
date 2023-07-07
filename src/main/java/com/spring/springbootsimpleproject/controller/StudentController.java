package com.spring.springbootsimpleproject.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootsimpleproject.dto.Student;
import com.spring.springbootsimpleproject.exception.IdNotFoundException;
import com.spring.springbootsimpleproject.repository.StudentRepository;
import com.spring.springbootsimpleproject.response.ResponseStructure;
import com.spring.springbootsimpleproject.service.StudentService;
import com.spring.springbootsimpleproject.sorting.SortStudentByName;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentRepository repository;
	/*
	 * save method
	 */
	@PostMapping(value = "/studentSave")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {
		
		return service.saveStudent(student);
	}
	
	/*
	 * getStudentById
	 */
	@GetMapping(value = "/getStudentById/{studentId}")
	public ResponseStructure<Student> getStudentById(@PathVariable int studentId) throws IdNotFoundException {
	
		return service.getStudentById(studentId);
	}
	
	/*
	 * displayAllStudent
	 */
	@GetMapping(value = "/getAllStudent")
	public List<Student> displStudents(){
		
		return service.displStudents();
	}
	
	/*
	 * delete studentById
	 */
	@DeleteMapping(value = "/delete/{studentId}")
	public ResponseStructure<Student> deleteStudentById(@PathVariable int studentId) {
		
		return service.deleteStudentById(studentId);
	}
	
	/*
	 * updateStudent
	 */
	@PutMapping(value = "/updateStudent/{studentId}")
	public ResponseStructure<Student> updateStudent(@RequestBody Student student,@PathVariable int studentId) {
		
		return service.updateStudent(student, studentId);
	}
	
	/*
	 * getStudentByPhone
	 */
	@GetMapping("/getStudentByPhone/{studentPhone}")
	public Student getStudentByPhone(@PathVariable long studentPhone) {
		
		return service.getStudentByPhone(studentPhone);
	}
	
	@GetMapping("/updateStudentById/{studentName}/{studentId}")
	public void updateStudentById(@PathVariable String studentName, @PathVariable int studentId) {

		service.updateStudentById(studentName, studentId);
	}
	
	@GetMapping("/orderByAsc")
	public List<Student> ascendingOrder(){
		return service.ascendingOrder();
	}
}
