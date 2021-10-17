package com.proj.mgmt.mock.test.service;



import static com.proj.mgmt.mock.test.container.DataContainer.returnEmployee;
import static com.proj.mgmt.mock.test.container.DataContainer.returnEmployees;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proj.mgmt.entity.Employee;
import com.proj.mgmt.entity.repository.EmployeeRepo;
import com.proj.mgmt.entity.service.EmployeeService;

public class EmployeeServiceTest {
	
	@Mock
	EmployeeRepo employeeRepo;
	
	@InjectMocks
	EmployeeService service;
	
	@BeforeEach
	public  void init() {
		
		MockitoAnnotations.openMocks(this);
		doNothing().when(employeeRepo).deleteAll();
		when(employeeRepo.findById(isA(String.class))).thenReturn(returnEmployee());
		when(employeeRepo.save(isA(Employee.class))).thenReturn(returnEmployee().get());
		when(employeeRepo.saveAll(null)).thenReturn(new ArrayList<Employee>(returnEmployees()));

	}
	
	@Test
	public void test_returnEmployeeById() {
		
		Employee employee = this.service.returnEmployeeById("E001");
		assertNotNull(employee);
	}
	
	@Test
	public void test_saveEmployee() {
		
		Employee employee = this.service.saveEmployee(new Employee());
		assertNotNull(employee);
		
	}

	public void test_saveAllEmployees() {
		
		Set<Employee> employees = this.service.saveAllEmployee(null);
		assertNotNull(employees);
	}
	

	@Test
	public void test_deleteAllEntries() {
		
		this.service.deleteAllEntries();
		
		
	}
	
	

}
