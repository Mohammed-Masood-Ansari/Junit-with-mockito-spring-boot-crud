package com.spring.springbootsimpleproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springbootsimpleproject.dto.Employee;
import com.spring.springbootsimpleproject.repository.EmployeeRespository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRespository employeeRespository;
	
	public EmployeeDao(EmployeeRespository employeeRespository2) {
		// TODO Auto-generated constructor stub
		this.employeeRespository = employeeRespository2;
	}

	/*
	 * save employee methods....
	 */
	public Employee saveEmployee(Employee employee) {
		
		return employeeRespository.save(employee);
	}
	
	/*
	 * save employee methods....
	 */
	public List<Employee> saveMutipleEmployee(List<Employee> employee) {
		
		return employeeRespository.saveAll(employee);
	}
	
	/*
	 * getEmployeeByIds
	 */
	public Employee getEmployeeById(int employeeId) {
		
		Optional<Employee> optional=employeeRespository.findById(employeeId);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<Employee> getAllEmployees(){
		
		return employeeRespository.findAll();
	}
	
	/*
	 * delete by Id
	 */
	public void deleteEmployeeById(int employeeId) {
		Employee employee=getEmployeeById(employeeId);
		employeeRespository.delete(employee);
		
	}
	
	/*
	 * update employee details
	 */
	public Employee updateEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}
	
	/*
	 * subquery select employee name with subQuery
	 */
	public Employee findEmployeeById(int employeeId) {
		return employeeRespository.findEmployeeById(employeeId);
	}
	
	/*
	 * orderByName
	 */
	public List<Employee> orderByEmployeeName(){
		return employeeRespository.orderByEmployeeName();
	}
}
