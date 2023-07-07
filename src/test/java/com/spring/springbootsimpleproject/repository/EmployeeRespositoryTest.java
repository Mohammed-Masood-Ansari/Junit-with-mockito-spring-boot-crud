package com.spring.springbootsimpleproject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.springbootsimpleproject.dto.Employee;

@DataJpaTest
class EmployeeRespositoryTest {

	@Autowired
	private EmployeeRespository employeeRespository;

	Employee employee;
	
	@BeforeEach
	void setUp() {
		
		employee = new Employee(123,"vikas","vikas1997@gmail.com",4567899);
		
		employeeRespository.save(employee);
	}
	
	@AfterEach
	void tearDown() {
		employee=null;
		employeeRespository.deleteAll();
	}
	
	//test cases for success
	@Test
	void testFindEmployeeById_Found() {
		Employee employeeFound = employeeRespository.findEmployeeById(123);
		assertThat(employeeFound.getEmployeeId()).isEqualTo(employee.getEmployeeId());
		assertThat(employeeFound.getEmployeeName()).isEqualTo(employee.getEmployeeName());
	}
	
	//test cases for failure
	@Test
	void testFindEmployeeById_NotFound() {
		Employee employeeFound = employeeRespository.findEmployeeById(12);
		assertThat(employeeFound==null).isTrue();
	}
}
