package com.springBoot.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.project.model.Employee;

// interface extending crud repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
