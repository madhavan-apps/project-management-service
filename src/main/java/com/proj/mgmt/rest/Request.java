package com.proj.mgmt.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Request {
	
	private String projectId;
	
	private String departId;
	
	private String emplId;

}
