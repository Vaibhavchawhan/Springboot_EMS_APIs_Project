package com.qsp.springboot_employee_management_system.exception;

public class PhoneNotFound  extends RuntimeException{
  private String massage;

public PhoneNotFound(String massage) {
	super();
	this.massage = massage;
}
 @Override
	public String getMessage() {
	 return massage;
 }
}
