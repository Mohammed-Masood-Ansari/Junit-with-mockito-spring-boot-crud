package com.spring.springbootsimpleproject.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootsimpleproject.dao.EmployeeDao;
import com.spring.springbootsimpleproject.dto.Employee;
import com.spring.springbootsimpleproject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value = "/data")
	public String getData() {
		return "todays Date = "+LocalDate.now();
	}
	
	/*
	 * save employee methods....
	 */
	@PostMapping(value = "/saveEmp")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
	}
	
	/*
	 * save employee methods....
	 */
	@PostMapping(value = "/saveMutipleEmp")
	public List<Employee> saveMutipleEmployee(@RequestBody List<Employee> employee) {
		
		return employeeService.saveMutipleEmployee(employee);
	}
	
	/*
	 * getEmployeeByIds
	 */
	@GetMapping(value = "/getEmployee/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	/*
	 * getAllEmployee
	 */
	@GetMapping(value = "/getAll")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}
	
	/*
	 * delete by Id
	 */
	@DeleteMapping("/delete/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		
		employeeService.deleteEmployeeById(employeeId);
		
		return "data deleted";
	}
	/*
	 * update employee details
	 */
	@PutMapping(value = "/updateEmployee/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
		return employeeService.updateEmployee(employee, employeeId);
	}
	
	/*
	 * subquery select employee name with subQuery
	 */
	@GetMapping(value = "/getEmployeeName/{employeeId}")
	public Employee findEmployeeById(@PathVariable int employeeId) {
		return employeeService.findEmployeeById(employeeId);
	}
	
	@GetMapping("/orderByEmployeeName")
	public List<Employee> orderByEmployeeName(){
		return employeeService.orderByEmployeeName();
	}
	
	/*
	 * sortByPhone
	 */
	@GetMapping(value = "/sortByPhoneDesc")
	public List<Employee> getAllEmployeeSortByPhone() {
		return employeeDao.getAllEmployeeSortByPhone();
	}
}
