package com.spring.springbootsimpleproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.springbootsimpleproject.dto.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

	@Query(value = "SELECT * FROM employee Where employee_id=?1",nativeQuery = true)
	public Employee findEmployeeById(int employeeId);
	
	@Query(value = "SELECT * FROM employee ORDER BY employee_name DESC",nativeQuery = true)
	public List<Employee> orderByEmployeeName();

	public Employee findByEmployeeId(int employeeId);
	
	@Modifying
	@Query("DELETE FROM Employee u WHERE u.employeeId = ?1")
	public Employee deleteEmployeeById(int employeeId);
}
