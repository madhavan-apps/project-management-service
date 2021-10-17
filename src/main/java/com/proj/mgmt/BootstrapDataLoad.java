package com.proj.mgmt;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.proj.mgmt.entity.Department;
import com.proj.mgmt.entity.Employee;
import com.proj.mgmt.entity.Project;
import com.proj.mgmt.entity.key.ProjectKey;
import com.proj.mgmt.entity.service.DepartmentService;
import com.proj.mgmt.entity.service.EmployeeService;
import com.proj.mgmt.entity.service.ProjectService;

import lombok.RequiredArgsConstructor;


@ConditionalOnProperty(
		prefix = "command.line.runner.dataload",
		value = "enabled",
		havingValue = "true",
		matchIfMissing = false)
@RequiredArgsConstructor
@Component
public class BootstrapDataLoad implements CommandLineRunner {

	private final DepartmentService departService;
	
	private final EmployeeService empService;
	
	private final ProjectService projService;
	
	@Override
	public void run(String... args) throws Exception {

		this.projService.deleteAllEntries();
		this.empService.deleteAllEntries();
		this.departService.deleteAllEntries();
		
		Department d1 = Department.builder()
				.departId("D001")
				.departName("FINANCE")
				.build();
		
		Department d2 = Department.builder()
				.departId("D002")
				.departName("ADMINSTRATION")
				.build();
		
		Department d3 = Department.builder()
				.departId("D003")
				.departName("COMMERCE")
				.build();
		
		Set<Department> departments = Stream.of(d1,d2,d3).collect(Collectors.toSet());
		departments = this.departService.saveAllDepartment(departments);
		d3 = this.departService.returnDepatmentById("D003");
		departments.remove(d3);
		
		Employee e1 = Employee.builder()
				.empId("E001")
				.firstName("William")
				.lastName("Rattary")
				.departments(departments)
				.build();
		
		Employee e2 = Employee.builder()
				.empId("E002")
				.firstName("Madhavan")
				.lastName("Sivaprakasam")
				.departments(departments)
				.build();
		
		Employee e3 = Employee.builder()
				.empId("E003")
				.departments(Stream.of(d3).collect(Collectors.toSet()))
				.firstName("Bill")
				.lastName("Griffin")
				.build();
		
		Set<Employee> employees1 = Stream.of(e1,e2,e3).collect(Collectors.toSet());
		employees1 = this.empService.saveAllEmployee(employees1);
		e3 = this.empService.returnEmployeeById("E003");
		employees1.remove(e3);
		
		ProjectKey key1 = ProjectKey.builder()
				.projId("P001")
				.build();
		
		Project p1 = Project.builder()
				.department(d1)
				.employees(employees1)
				.key(key1)
				.projectName("THREADSTONE")
				.build();
		this.projService.saveProject(p1);
		
		ProjectKey key2 = ProjectKey.builder()
				.projId("P001")
				.build();
		employees1.add(e3);
		Project p2 = Project.builder()
				.department(d2)
				.employees(employees1)
				.key(key2)
				.projectName("THREADSTONE")
				.build();
		this.projService.saveProject(p2);

	}

}
