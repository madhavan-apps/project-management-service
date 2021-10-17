package com.proj.mgmt.mock.test.controller;

import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.SUCCESS;
import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.UPDATE;
import static com.proj.mgmt.mock.test.container.DataContainer.DEPARTMENT_ID_PARAM_NAME;
import static com.proj.mgmt.mock.test.container.DataContainer.DEPARTMENT_ID_PARAM_VALUE;
import static com.proj.mgmt.mock.test.container.DataContainer.EMPLOYEE_ID_PARAM_NAME;
import static com.proj.mgmt.mock.test.container.DataContainer.EMPLOYEE_ID_PARAM_VALUE;
import static com.proj.mgmt.mock.test.container.DataContainer.PROJECT_ID_PARAM_NAME;
import static com.proj.mgmt.mock.test.container.DataContainer.PROJECT_ID_PARAM_VALUE;
import static com.proj.mgmt.mock.test.container.DataContainer.returnProject;
import static com.proj.mgmt.mock.test.container.DataContainer.returnRequestStatus;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.proj.mgmt.entity.service.ProjectService;
import com.proj.mgmt.rest.controller.OpsController;

@WebMvcTest(controllers = OpsController.class)
public class OpsControllerTest {

	
	@Autowired
	private MockMvc mockMv;
	
	@MockBean
	private ProjectService service;
	
	MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
	
	@BeforeEach
	public void  init() {
		
		MockitoAnnotations.openMocks(this);
		when(this.service.returnProjectDetails(any(String.class), any(String.class))).thenReturn(returnProject());
		when(this.service.unlinkEmployeeFromProject(any(String.class), any(String.class),any(String.class))).thenReturn(returnRequestStatus());
		params.add(PROJECT_ID_PARAM_NAME, PROJECT_ID_PARAM_VALUE);
		params.add(DEPARTMENT_ID_PARAM_NAME,DEPARTMENT_ID_PARAM_VALUE);
		
	}
	
	@Test
	public void test_returnProjectDetails() throws Exception {
		
		this.mockMv.perform(MockMvcRequestBuilders.post("/comp/projDetails").params(params))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content()
				.string(containsString(SUCCESS.message())));
	}
	
	
	@Test
	public void testunEmployeeFrromProj() throws Exception {
		
		    params.add(EMPLOYEE_ID_PARAM_NAME,EMPLOYEE_ID_PARAM_VALUE);
			this.mockMv.perform(MockMvcRequestBuilders.post("/comp/unlinkEmpFromProj").params(params))
			.andDo(print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().
					string(containsString(UPDATE.message())));
	  
	  }
	 

}
