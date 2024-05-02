package com.qsp.springboot_employee_management_system.exception;

public class IdNotFound extends RuntimeException {
	private String massage;

	public IdNotFound(String massage) {
		this.massage = massage;
	}

	@Override
	public String getMessage() {
		return massage;
	}
}
