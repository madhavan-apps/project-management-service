package com.proj.mgmt.rest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestStatus {

	private int statusCode;
	
	private String responseMessage;
	
}
