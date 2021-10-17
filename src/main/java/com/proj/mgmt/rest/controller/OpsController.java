package com.proj.mgmt.rest.controller;

import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.NO_DATA;
import static com.proj.mgmt.common.OPSConstants.RESP_CODE_MSG_MAP.SUCCESS;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.mgmt.entity.Project;
import com.proj.mgmt.entity.service.ProjectService;
import com.proj.mgmt.rest.RequestStatus;
import com.proj.mgmt.rest.Response;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("comp")
public class OpsController {

	private final ProjectService service;

	@PostMapping("projDetails")
	public ResponseEntity<Response> returnProjectDetails(@RequestParam(name = "projId", required = true) String projId,
			@RequestParam(name = "deptId", required = true) String deptId) {

		Response response = null;
		RequestStatus status = null;
		Optional<Project> projectOpt = this.service.returnProjectDetails(projId, deptId);
		if (projectOpt.isPresent()) {

			status = RequestStatus.builder().statusCode(SUCCESS.status()).responseMessage(SUCCESS.message()).build();
			response = Response.builder().project(projectOpt.get()).requestStatus(status).build();

		} else {

			status = RequestStatus.builder().statusCode(NO_DATA.status()).responseMessage(NO_DATA.message()).build();
			response = Response.builder().requestStatus(status).build();
		}
		return ResponseEntity.ok(response);

	}

	@PostMapping("unlinkEmpFromProj")
	public ResponseEntity<Response> unEmployeeFrromProj(@RequestParam(name = "projId", required = true) String projId,
			@RequestParam(name = "deptId", required = true) String deptId,
			@RequestParam(name = "empId", required = true) String empId) {

		Response response = null;
		RequestStatus requestStatus = this.service.unlinkEmployeeFromProject(projId, deptId, empId);
		response = Response.builder().requestStatus(requestStatus).build();
		Optional<Project> projectOpt = this.service.returnProjectDetails(projId, deptId);
		if (projectOpt.isPresent()) {

			response.setProject(projectOpt.get());

		}

		return ResponseEntity.ok(response);

	}

}
