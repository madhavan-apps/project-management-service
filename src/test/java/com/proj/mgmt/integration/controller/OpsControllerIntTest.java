package com.proj.mgmt.integration.controller;

import static com.proj.mgmt.mock.test.container.DataContainer.DEPARTMENT_ID_PARAM_NAME;
import static com.proj.mgmt.mock.test.container.DataContainer.DEPARTMENT_ID_PARAM_VALUE;
import static com.proj.mgmt.mock.test.container.DataContainer.EMPLOYEE_ID_PARAM_NAME;
import static com.proj.mgmt.mock.test.container.DataContainer.EMPLOYEE_ID_PARAM_VALUE;
import static com.proj.mgmt.mock.test.container.DataContainer.PROJECT_ID_PARAM_NAME;
import static com.proj.mgmt.mock.test.container.DataContainer.PROJECT_ID_PARAM_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;



@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class OpsControllerIntTest {
	
	
	@Autowired
	MockMvc mockMvc;
	
	@LocalServerPort
	private int port;
	
	MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
	
	@BeforeEach
	public void init() {
	
		params.add(PROJECT_ID_PARAM_NAME, PROJECT_ID_PARAM_VALUE);
		params.add(DEPARTMENT_ID_PARAM_NAME,DEPARTMENT_ID_PARAM_VALUE);
	}
	
	@Order(1)
	@Test
	public void test_reeturnProjectDetails() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/comp/projDetails") 
		          .param(PROJECT_ID_PARAM_NAME, PROJECT_ID_PARAM_VALUE)
		          .param(DEPARTMENT_ID_PARAM_NAME,DEPARTMENT_ID_PARAM_VALUE)
		          .accept(MediaType.APPLICATION_JSON))
		          .andExpect(status().isOk());
		
	}
	
	@Order(2)
	@Test
	public void test_unMapEmpFromProj() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/comp/unlinkEmpFromProj") 
		          .param(PROJECT_ID_PARAM_NAME, PROJECT_ID_PARAM_VALUE)
		          .param(DEPARTMENT_ID_PARAM_NAME,DEPARTMENT_ID_PARAM_VALUE)
		          .param(EMPLOYEE_ID_PARAM_NAME, EMPLOYEE_ID_PARAM_VALUE)
		          .accept(MediaType.APPLICATION_JSON))
		          .andExpect(status().isOk());
		
	}

}
