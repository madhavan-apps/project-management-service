package com.proj.mgmt.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.mgmt.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
	

}
