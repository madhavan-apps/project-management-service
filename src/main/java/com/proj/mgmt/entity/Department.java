package com.proj.mgmt.entity;

import static javax.persistence.CascadeType.ALL;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity(name = "depart")
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	@Column(name = "DEPART_ID")
	String departId;

	@Column(name = "DEPT_NAME")
	String departName;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Employee.class, mappedBy = "departments")
	Set<Employee> employees;

	@JsonIgnore
	@OneToMany(cascade = ALL, targetEntity = Project.class, mappedBy = "department")
	Set<Project> projects;
	
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) {
			
			return true;
		}
		
		if(null == o || !(o instanceof Department)) {
			
			return false;
		}
		
		Department dept = (Department) o;
		if(dept.getDepartId().equals(this.getDepartId())) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	
	
	@Override
	public int hashCode() {
		
		int result = 17;
		if(this.departId != null) {
			
			return (result * this.departId.hashCode());
		}
		return result;
			
	}

}
