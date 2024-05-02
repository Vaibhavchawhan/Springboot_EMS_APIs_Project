package com.qsp.springboot_employee_management_system.exception;

public class EmailNotFound extends RuntimeException {
	private String massage;

	public EmailNotFound(String massage) {
		super();
		this.massage = massage;
	}

	@Override
	public String getMessage() {
		return massage;
	}
}
