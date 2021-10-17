package com.proj.mgmt.rest;

import com.proj.mgmt.entity.Project;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {
	
	
	private RequestStatus requestStatus;
	
	private Project project;
	
	

}
