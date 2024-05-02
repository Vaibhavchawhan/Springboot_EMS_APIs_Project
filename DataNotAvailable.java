package com.qsp.springboot_employee_management_system.exception;

public class DataNotAvailable extends RuntimeException {
	private String massage;

	public DataNotAvailable(String massage) {

		this.massage = massage;
	}
	
	@Override
	public String getMessage() {
	return massage;
	}

}
