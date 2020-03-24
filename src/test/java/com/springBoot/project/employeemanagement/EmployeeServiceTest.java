package com.springBoot.project.employeemanagement;
 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springBoot.project.model.Employee;
import com.springBoot.project.service.EmployeeService;
 
public class EmployeeServiceTest {
     
	@Mock
    EmployeeService service;
     
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllEmployeesTest()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "Robot", "Rajani", "Account");
        Employee empTwo = new Employee(2, "Robot2", "Akshay", "Admin");
        Employee empThree = new Employee(3, "Bahubali", "Bahubali", "Security");
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
         
        when(service.getAllEmployees()).thenReturn(list);
         
        //test
        List<Employee> empList = service.getAllEmployees();
         
        assertEquals(3, empList.size());
        verify(service, times(1)).getAllEmployees();
    }
     
    @Test
    public void getEmployeeByIdTest()
    {
        when(service.getEmployee(1)).thenReturn(new Employee(1, "Money", "Hiest", "IT"));
         
        Employee emp = service.getEmployee(1);
         
        assertEquals("Money", emp.getFirstName());
        assertEquals("Hiest", emp.getLastName());
        assertEquals("IT", emp.getLastName());
    }
     
     @Test
    public void createEmployeeTest()
    {
    	 Employee emp = new Employee(1,"Stranger","Things", "Staffing");
         
    	 service.addEmployee(emp);
         
        verify(service, times(1)).addEmployee(emp);
    }
}