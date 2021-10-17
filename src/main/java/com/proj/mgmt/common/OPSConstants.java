package com.proj.mgmt.common;

public class OPSConstants {

	public enum RESP_CODE_MSG_MAP {

		SUCCESS(200, "Information successfully retrieved."),
		FAILURE(500, "Error occured while processing the request."), 
		UPDATE(200, "Successfully updated."),
		NO_DATA(600, "No data available for the specified criteria."),
		NO_EMP_DATA(601, "Specified employee is not mapped to the project.");

		private int status;

		private String message;

		private RESP_CODE_MSG_MAP(int code, String message) {

			this.status = code;
			this.message = message;
		}

		public int status() {

			return this.status;
		}

		public String message() {

			return this.message;
		}

	};
	
}
