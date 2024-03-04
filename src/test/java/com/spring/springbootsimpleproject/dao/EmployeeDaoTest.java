package com.spring.springbootsimpleproject.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.springbootsimpleproject.dto.Employee;
import com.spring.springbootsimpleproject.repository.EmployeeRespository;

@DataJpaTest
class EmployeeDaoTest {

	@Mock
	private EmployeeRespository employeeRespository;

	private EmployeeDao employeeDao;

	AutoCloseable autoCloseable;

	Employee employee1;

	Employee employee2;

	List<Employee> employees;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		// we have to store employeeRespository inside EmployeeDao constructor...
		employeeDao = new EmployeeDao(employeeRespository);
		employee1 = new Employee(324, "milan", "milan@gmail.com", 789065432);
		employee2 = new Employee(325, "Akash", "akash@gmail.com", 7546065432l);
		employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
	}

	@AfterEach
	void tearDown() {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * to test saveEmployee() methods for EmployeeService class
	 */
	@Test
	void testSaveEmployee() {
		/*
		 * first we have to mock all classes
		 */
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.save(employee1)).thenReturn(employee1);
		assertThat(employeeDao.saveEmployee(employee1)).isEqualTo(employee1);
	}

	@Test
	void testSaveMutipleEmployee() {
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.saveAll(employees)).thenReturn(employees);
		assertThat(employeeDao.saveMutipleEmployee(employees)).isEqualTo(employees);
	}

	@Test
	void testGetEmployeeById() {
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.findById(324)).thenReturn(Optional.ofNullable(employee1));
		assertThat(employeeDao.getEmployeeById(324).getEmployeeName()).isEqualTo(employee1.getEmployeeName());
	}

	@Test
	void testGetAllEmployees() {
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.findAll()).thenReturn(employees);
		assertThat(employeeDao.getAllEmployees().get(0).getEmployeeName())
		.isEqualTo(employees.get(0).getEmployeeName());
	}

	@Test
	void testUpdateEmployee() {
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.save(employee1)).thenReturn(employee1);
		assertThat(employeeDao.updateEmployee(employee1)
				.getEmployeeName()).isEqualTo(employee1.getEmployeeName());
	}

	@Test
	void testFindEmployeeById() {
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.findEmployeeById(324)).thenReturn(employee1);
		assertThat(employeeDao.findEmployeeById(324).getEmployeeName()).isEqualTo(employee1.getEmployeeName());
	}

	@Test
	void testOrderByEmployeeName() {
		mock(Employee.class);
		mock(EmployeeRespository.class);
		when(employeeRespository.orderByEmployeeName()).thenReturn(employees);
		assertThat(employeeDao.orderByEmployeeName().get(0).getEmployeeName()).isEqualTo(employees.get(0).getEmployeeName());
	}
	
	/*
	 * delete method testing 
	 */
	@Test
	void testDeleteEmployeeById() {
		mock(Employee.class);
		mock(EmployeeRespository.class, Mockito.CALLS_REAL_METHODS);
		
		doAnswer(Answers.CALLS_REAL_METHODS).when(
				employeeRespository).deleteById(any());
		
		//assertThat(employeeDao.deleteEmployeeById(employee1.getEmployeeId()));
	}

}
