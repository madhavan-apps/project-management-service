package com.proj.mgmt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "emp")
@Table(name = "EMPLOYEE")
public class Employee {

	@Column(name = "EMPLOYEE_ID")
	@Id
	String empId;

	@Column(name = "EMP_FIRST_NAME")
	String firstName;

	@Column(name = "EMP_LAST_NAME")
	String lastName;
	
	@ManyToMany
	@JoinTable(name = "EMP_DEPART_MAP", 
	joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "DEPART_ID"))
	Set<Department> departments;

	@JsonIgnore
	@ManyToMany(targetEntity = Project.class, mappedBy = "employees")
	Set<Project> projects;
	
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) {
			
			return true;
		}
		
		if(null == o || !(o instanceof Employee)) {
			
			return false;
		}
		
		Employee dept = (Employee) o;
		if(dept.getEmpId().equals(this.empId)) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	
	
	@Override
	public int hashCode() {
		
		int result = 17;
		if(this.empId != null) {
			
			return (result * this.empId.hashCode());
		}
		return result;
			
	}

}
