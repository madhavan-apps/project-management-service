package com.proj.mgmt.entity.service;

import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.NO_DATA;
import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.NO_EMP_DATA;
import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.UPDATE;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.proj.mgmt.entity.Employee;
import com.proj.mgmt.entity.Project;
import com.proj.mgmt.entity.key.ProjectKey;
import com.proj.mgmt.entity.repository.ProjectRepo;
import com.proj.mgmt.rest.RequestStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProjectService {

	private final ProjectRepo projectRepo;

	public void deleteAllEntries() {

		if (this.projectRepo.count() > 0) {

			this.projectRepo.deleteAll();

		}
	}

	public Project saveProject(Project project) {

		return this.projectRepo.save(project);
	}

	public Optional<Project> returnProjectDetails(String projId, String departId) {

		ProjectKey key = ProjectKey.builder().projId(projId).depart(departId).build();
		return this.projectRepo.findById(key);

	}

	public RequestStatus unlinkEmployeeFromProject(String projId, String deptId, String empId) {

		Optional<Project> projectOpt = this.returnProjectDetails(projId, deptId);
		if (projectOpt.isPresent()) {

			Project project = projectOpt.get();
			Set<Employee> employees = project.getEmployees();
			Employee employee = Employee.builder().empId(empId).build();
			boolean removed = employees.remove(employee);
			if(removed) {
				
				project = this.projectRepo.save(project);
				return RequestStatus.builder()
						.responseMessage(UPDATE.message())
						.statusCode(UPDATE.status())
						.build();
				
			} else {
				
				return RequestStatus.builder()
						.responseMessage(NO_EMP_DATA.message())
						.statusCode(NO_EMP_DATA.status())
						.build();
				
				
			}

		} else {
			
			return RequestStatus.builder()
					.responseMessage(NO_DATA.message())
					.statusCode(NO_DATA.status())
					.build();

		}
	}

}
