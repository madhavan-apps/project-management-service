package com.proj.mgmt.entity.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.proj.mgmt.entity.Employee;
import com.proj.mgmt.entity.repository.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeService {
	
	
	private final EmployeeRepo employeeRepo;
	
	public void deleteAllEntries() {
		
		if(this.employeeRepo.count()> 0) {
			
			this.employeeRepo.deleteAll();
		
		}
		
	}
	
	public Employee saveEmployee(Employee employee) {
		
		
		return this.employeeRepo.save(employee);
	}
	
	public Set<Employee> saveAllEmployee(Set<Employee> employees) {
		
		return new HashSet<Employee>(this.employeeRepo.saveAll(employees));
		
	}

	public Employee returnEmployeeById(String id) {
		
		return this.employeeRepo.findById(id).get();
	}

}
