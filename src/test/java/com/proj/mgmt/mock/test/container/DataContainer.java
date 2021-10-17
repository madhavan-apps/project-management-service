package com.proj.mgmt.mock.test.container;

import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.UPDATE;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.proj.mgmt.entity.Department;
import com.proj.mgmt.entity.Employee;
import com.proj.mgmt.entity.Project;
import com.proj.mgmt.entity.key.ProjectKey;
import com.proj.mgmt.rest.RequestStatus;

public class DataContainer {
	
	
	public static final String PROJECT_ID_PARAM_NAME= "projId";
	
	public static final String PROJECT_ID_PARAM_VALUE = "P001";
	
	public static final String DEPARTMENT_ID_PARAM_NAME = "deptId";
	
	public static final String DEPARTMENT_ID_PARAM_VALUE = "D001";

	public static final String EMPLOYEE_ID_PARAM_NAME = "empId";

	public static final String EMPLOYEE_ID_PARAM_VALUE = "E001";
	
	

	public static Optional<Project> returnProject() {

		ProjectKey key = ProjectKey.builder().projId("P001").build();

		Project p1 = Project.builder()
				.key(key)
				.department(returnDepartment().get())
				.employees(returnEmployees())
				.projectName("THREADSTONE")
				.build();

		return Optional.of(p1);

	}

	public static Optional<Employee> returnEmployee() {

		return Optional.of(Employee.builder()
				.empId("E003")
				.departments(returnDepartments())
				.firstName("Bill")
				.lastName("Griffin")
				.build());
	}


	public static Set<Employee> returnEmployees() {

		Employee e1 = Employee.builder()
				.empId("E001")
				.firstName("William")
				.lastName("Rattary")
				.departments(returnDepartments())
				.build();

		Employee e2 = Employee.builder()
				.empId("E002")
				.firstName("Madhavan")
				.lastName("Sivaprakasam")
				.departments(returnDepartments())
				.build();

		Employee e3 = Employee.builder()
				.empId("E003")
				.departments(returnDepartments())
				.firstName("Bill")
				.lastName("Griffin")
				.build();

		return Stream.of(e1, e2, e3).collect(Collectors.toSet());

	}
	
	public static Optional<Department> returnDepartment() {

		return Optional.of(Department.builder()
				.departId("D001")
				.departName("FINANCE")
				.build());
	}

	public static Set<Department> returnDepartments() {

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

		return Stream.of(d1, d2, d3).collect(Collectors.toSet());

	}
	
	
	public static RequestStatus returnRequestStatus() {
		
		return RequestStatus.builder()
				.responseMessage(UPDATE.message())
				.statusCode(UPDATE.status())
				.build();
	}

}
