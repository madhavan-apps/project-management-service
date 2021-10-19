package com.proj.mgmt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.proj.mgmt.entity.key.ProjectKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name="PROJECT")
@Table(name="PROJECT")
public class Project {
	
	@EmbeddedId
	ProjectKey key;
	
	@Column(name="PROJ_NAME")
	private String projectName;
	
	@ManyToOne
	@JoinColumn(name = "DEPART_ID")
	@MapsId("depart")
	private Department department;
	
	@ManyToMany
	@JoinTable(name = "PROJ_EMP_MAP", 
	joinColumns = {
		 @JoinColumn(name="PROJ_ID",referencedColumnName = "PROJ_ID"),
		 @JoinColumn(name="DEPART_ID", referencedColumnName = "DEPART_ID") }, 
	 inverseJoinColumns= @JoinColumn(name="EMPLOYEE_ID")) 
	 private Set<Employee> employees;
	 

}
