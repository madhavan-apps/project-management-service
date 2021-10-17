package com.proj.mgmt.mock.test.service;

import static com.proj.mgmt.mock.test.container.DataContainer.returnDepartment;
import static com.proj.mgmt.mock.test.container.DataContainer.returnDepartments;
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

import com.proj.mgmt.entity.Department;
import com.proj.mgmt.entity.repository.DepartmentRepo;
import com.proj.mgmt.entity.service.DepartmentService;

public class DepartmentServiceTest {
	
	@Mock
	DepartmentRepo departmentRepo;
	
	
	@InjectMocks
	DepartmentService service;
	
	
	@BeforeEach
	public void init() {
		
		MockitoAnnotations.openMocks(this);
		doNothing().when(departmentRepo).deleteAll();
		when(departmentRepo.findById(isA(String.class))).thenReturn(returnDepartment());
		when(departmentRepo.save(isA(Department.class))).thenReturn(returnDepartment().get());
		when(departmentRepo.saveAll(null)).thenReturn(new ArrayList<Department>(returnDepartments()));
		
	}
	
	@Test
	public void test_returnDepartmentById() {
		
		Department department = this.service.returnDepatmentById("D001");
		assertNotNull(department);
	}
	
	@Test
	public void test_saveDepartment() {
		
		Department department = this.service.saveDepartment(new Department());
		assertNotNull(department);
		
	}

	public void test_saveAllDepartment() {
		
		Set<Department> employees = this.service.saveAllDepartment(null);
		assertNotNull(employees);
	}
	

	@Test
	public void test_deleteAllEntries() {
		
		this.service.deleteAllEntries();
		
		
	}
	
	
	
	

}
