package com.spring.springbootsimpleproject.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.springbootsimpleproject.dao.StudentDao;
import com.spring.springbootsimpleproject.dto.Student;
import com.spring.springbootsimpleproject.exception.IdNotFoundException;
import com.spring.springbootsimpleproject.response.ResponseStructure;
import com.spring.springbootsimpleproject.sorting.SortStudentByName;

@Service
public class StudentService {

	@Autowired
	private ResponseStructure<Student> responseStructure;

	@Autowired
	private StudentDao studentDao;

	/*
	 * save method
	 */
	public ResponseStructure<Student> saveStudent(Student student) {

		Student student2 = studentDao.saveStudent(student);

		if (student2 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setStatusMessage("registered---successfully");
			responseStructure.setStatusDescription("fdxashjbbkjnsalk");
			responseStructure.setStatusData(student2);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("registered---unsuccessfully");
			responseStructure.setStatusDescription("Please pass correct data what is required");
			responseStructure.setStatusData(student2);
		}

		return responseStructure;
	}

	/*
	 * getStudentById
	 */
	public ResponseStructure<Student> getStudentById(int studentId) throws IdNotFoundException {

		Student student = studentDao.getStudentById(studentId);

		if (student != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setStatusMessage("Given Id is Present");
			responseStructure.setStatusDescription("fghjkl;'");
			responseStructure.setStatusData(student);
		} else {
//			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
//			responseStructure.setStatusMessage("Given Id is not Present");
//			responseStructure.setStatusDescription("sadfghjkl;");
//			responseStructure.setStatusData(student);

			throw new IdNotFoundException("id not found exception");
		}
		return responseStructure;
	}

	/*
	 * displayAllStudent
	 */
	public List<Student> displStudents() {

		List<Student> students = studentDao.displStudents();

		// Collections.sort(students);

		Collections.sort(students, new SortStudentByName());

		return students;
	}

	/*
	 * delete studentById
	 */
	public ResponseStructure<Student> deleteStudentById(int studentId) {

		Student student = studentDao.getStudentById(studentId);

		if (student != null) {

			studentDao.deleteStudentById(studentId);

			Student student1 = studentDao.getStudentById(studentId);

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Data deleted....");
			responseStructure.setStatusDescription("3456fghjkl");
			responseStructure.setStatusData(student1);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Given id is not present....");
			responseStructure.setStatusDescription("3456fghjkl");
			responseStructure.setStatusData(student);
		}
		return responseStructure;
	}

	/*
	 * updateStudent
	 */
	public ResponseStructure<Student> updateStudent(Student student, int studentId) {

		Student student1 = studentDao.getStudentById(studentId);

		if (student1 != null) {
			student1.setStudentName(student.getStudentName());
			student1.setStudentEmail(student.getStudentEmail());
			student1.setStudentPhone(student.getStudentPhone());

			Student student2 = studentDao.updateStudent(student1);

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Data Updated....");
			responseStructure.setStatusDescription("3456fghjkl");
			responseStructure.setStatusData(student2);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Data not Updated....");
			responseStructure.setStatusDescription("sdfghjkl");
			responseStructure.setStatusData(student1);
		}
		return responseStructure;
	}

	/*
	 * getStudentByPhone
	 */
	public Student getStudentByPhone(long studentPhone) {

		return studentDao.getStudentByPhone(studentPhone);
	}

	public void updateStudentById(String studentName, int studentId) {

		 studentDao.updateStudentById(studentName, studentId);
	}
	
	public List<Student> ascendingOrder(){
		return studentDao.ascendingOrder();
	}

}
