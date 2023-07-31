package com.spring.springbootsimpleproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.springbootsimpleproject.dao.EmployeeDao;
import com.spring.springbootsimpleproject.dto.Employee;
@DataJpaTest
class EmployeeServiceTest {

	@Mock
	private EmployeeDao employeeDao;
	
	private EmployeeService employeeService;
	
	AutoCloseable autoCloseable;
	
	Employee employee1;
	Employee employee2;
	
	List<Employee> employees;
	
	@BeforeEach
	public void setup() {
		
		autoCloseable= MockitoAnnotations.openMocks(this);
		
		employeeService = new EmployeeService(employeeDao);
		
		employee1 = new Employee(324, "milan", "milan@gmail.com", 789065432);
		employee2 = new Employee(325, "Akash", "akash@gmail.com", 7546065432l);
		employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
	}
	
	@AfterEach
	public void tearDown() {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void saveEmployeeTest() {
		
		mock(Employee.class);
		mock(EmployeeDao.class);
		when(employeeDao.saveEmployee(employee1)).thenReturn(employee1);
		assertThat(employeeService.saveEmployee(employee1)).isEqualTo(employee1);
	}
}
