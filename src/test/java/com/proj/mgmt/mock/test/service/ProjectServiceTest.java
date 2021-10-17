package com.proj.mgmt.mock.test.service;

import static com.proj.mgmt.mock.test.container.DataContainer.returnProject;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proj.mgmt.entity.Project;
import com.proj.mgmt.entity.key.ProjectKey;
import com.proj.mgmt.entity.repository.ProjectRepo;
import com.proj.mgmt.entity.service.ProjectService;
import com.proj.mgmt.rest.RequestStatus;

public class ProjectServiceTest {
	
	@Mock
	ProjectRepo projectRepo;
	
	@InjectMocks
	ProjectService service;
	
	@BeforeEach
	public void init() {
		
		MockitoAnnotations.openMocks(this);
		when(projectRepo.findById(isA(ProjectKey.class))).thenReturn(returnProject());
		when(projectRepo.save(isA(Project.class))).thenReturn(returnProject().get());
	}
	
	
	@Test
	public void test_saveProject() {
		
		Project project = this.service.saveProject(new Project());
		assertNotNull(project);
	}
	
	@Test
	public void test_returnProjectDetails() {
		
		Optional<Project> projectOpt = this.service.returnProjectDetails(null, null);
		assertNotNull(projectOpt);
		
	}
	
	@Test
	public void test_unlinkEmployeeFromProject() {
		
		RequestStatus status = this.service.unlinkEmployeeFromProject(null, null, null);
		assertNotNull(status);
		
	}

}
