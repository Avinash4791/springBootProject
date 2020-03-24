package com.springBoot.project.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.project.model.Employee;
import com.springBoot.project.service.EmployeeService;

@RestController
public class EmployeeController {
	
	static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;
	
	// displaying list of all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}
	
	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
	}

	//updating employee by id
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id){
		employeeService.updateEmployee(e, id);
	}
	

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id){
		employeeService.deleteEmployeeByID(id);
	}
	
	@GetMapping("employees/byDepartment")
	public List<Employee> getEmployeeByDepartment(){
		List<Employee> employees = employeeService.getAllEmployees();
		Predicate<Employee> predicate = s->s.getDepartment().equalsIgnoreCase("Developemnet");
		List<Employee> filtredEmps = employees.stream().filter(predicate).collect(Collectors.toList());
		return filtredEmps;
	}

}
