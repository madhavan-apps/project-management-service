package com.proj.mgmt.entity.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.proj.mgmt.entity.Department;
import com.proj.mgmt.entity.repository.DepartmentRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartmentService {
	
	private final DepartmentRepo departmentRepo; 
	
	public Department saveDepartment(Department department) {
		
		return this.departmentRepo.save(department);
	}
	
	
	public void deleteAllEntries() {
		
		if(this.departmentRepo.count()> 0) {
			
			this.departmentRepo.deleteAll();
			
		}
	}

	public Set<Department> saveAllDepartment(Set<Department> departments) {
		
		return new HashSet<Department>(this.departmentRepo.saveAll(departments));
	}


	public Department returnDepatmentById(String id) {
		
		return this.departmentRepo.findById(id).get();
	}
	
}
