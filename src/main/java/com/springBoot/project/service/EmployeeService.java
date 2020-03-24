package com.springBoot.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.project.model.Employee;
import com.springBoot.project.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// fetching all employees
	public List<Employee> getAllEmployees(){
		List<Employee> emps = (List<Employee>)employeeRepository.findAll(); 
		return emps;
	}
	
	// fetching employee by id
	public Employee getEmployee(int id){
		return employeeRepository.findById(id).get();
	}
	
	// inserting employee
	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}
	
	// updating employee by id
	public void updateEmployee(Employee emp, int id){
			employeeRepository.save(emp);
	}
	
	
	// deleting employee by id
	public void deleteEmployeeByID(int id){
		employeeRepository.deleteById(id);
	}
}
