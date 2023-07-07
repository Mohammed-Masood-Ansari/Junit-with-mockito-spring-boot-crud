package com.spring.springbootsimpleproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.springbootsimpleproject.dto.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	/*
	 * getStudentByPhone custom query with where clause
	 */
	public Student getByStudentPhone(long studentPhone);
	
	@Modifying
	@Transactional
	@Query(value = "update student set student_name=:name WHERE student_id=:id",nativeQuery = true)
	public void updateStudentById(@Param("name") String studentName,@Param("id") int studentId);
	
	@Query(value = "SELECT * FROM student ORDER BY student_name DESC",nativeQuery = true)
	public List<Student> ascendingOrder();
}
