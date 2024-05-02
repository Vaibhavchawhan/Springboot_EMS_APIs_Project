package com.qsp.springboot_employee_management_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.qsp.springboot_employee_management_system.util.ResponceStructure;

@RestControllerAdvice // or @ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new HashMap<String, String>();
		for (ObjectError objectError : errors) {
			FieldError error = (FieldError) objectError;
			String name = error.getField();
			String message = error.getDefaultMessage();
			map.put(name, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponceStructure<String>> handlePhoneNotFound(PhoneNotFound ex) {
		ResponceStructure<String> structure = new ResponceStructure<String>();
		structure.setMassage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Student Not Found By Phone Number ");
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> handleIdNotFound(IdNotFound ex) {
		ResponceStructure<String> structure = new ResponceStructure<String>();
		structure.setMassage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Student Not found by id");
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponceStructure<String>> handleEmailNotFound(EmailNotFound ex) {
		ResponceStructure<String> structure = new ResponceStructure<String>();
		structure.setMassage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Student not found By Email");
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataNotAvailable.class)
	public ResponseEntity<ResponceStructure<String>> handleDataNotAvailable(DataNotAvailable ex) {
		ResponceStructure<String> structure = new ResponceStructure<String>();
		structure.setMassage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("DataNotAvailable by Student");
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
