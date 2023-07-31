package com.spring.springbootsimpleproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springbootsimpleproject.dao.EmployeeDao;
import com.spring.springbootsimpleproject.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeService(EmployeeDao employeeDao) {
	
		this.employeeDao=employeeDao;
	}

	/*
	 * save employee methods....
	 */
	public Employee saveEmployee(Employee employee) {

		return employeeDao.saveEmployee(employee);
	}

	/*
	 * save employee methods....
	 */
	public List<Employee> saveMutipleEmployee(List<Employee> employee) {

		return employeeDao.saveMutipleEmployee(employee);
	}

	/*
	 * getEmployeeByIds
	 */
	public Employee getEmployeeById(int employeeId) {

		return employeeDao.getEmployeeById(employeeId);
	}

	public List<Employee> getAllEmployees() {

		return employeeDao.getAllEmployees();
	}
	
	/*
	 * delete by Id
	 */
	public void deleteEmployeeById(int employeeId) {
		
		employeeDao.deleteEmployeeById(employeeId);
	}
	
	/*
	 * update employee details
	 */
	public Employee updateEmployee(Employee employee,int employeeId) {
		
		Employee employee2=getEmployeeById(employeeId);
		
		if(employee2!=null) {
			
			employee2.setEmployeeEmail(employee.getEmployeeEmail());
			employee2.setEmployeePhone(employee.getEmployeePhone());
			employee2.setEmployeeName(employee.getEmployeeName());
			
			return employeeDao.updateEmployee(employee2);
		}else {
			return null;
		}
	}
	
	/*
	 * subquery select employee name with subQuery
	 */
	public Employee findEmployeeById(int employeeId) {
		return employeeDao.findEmployeeById(employeeId);
	}
	/*
	 * orderByName
	 */
	public List<Employee> orderByEmployeeName(){
		return employeeDao.orderByEmployeeName();
	}
}
