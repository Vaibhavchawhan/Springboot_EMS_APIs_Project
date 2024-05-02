 package com.qsp.springboot_employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee_management_system.dao.EmployeeDao;
import com.qsp.springboot_employee_management_system.dto.Employee;
import com.qsp.springboot_employee_management_system.service.EmployeeService;
import com.qsp.springboot_employee_management_system.util.ResponceStructure;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

//--------------------------------------------------------------------------------------------------------------------
	@PostMapping("/save")
	public ResponseEntity<ResponceStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) { // @REQUEST BODY																										// USED
		return service.saveEmployeee(employee);
	}

//--------------------------------------------------------------------------------------------------------------------
	@PostMapping("/saveall")
	public ResponseEntity<ResponceStructure<Employee>> saveAll(@RequestBody List<Employee> list) {
		return service.saveAll(list);
	}

//--------------------------------------------------------------------------------------------------------------------

	@GetMapping("/fetch")
	public ResponseEntity<ResponceStructure<Employee>> fetchEmployee(@RequestParam int id) { // request param used
		return service.fetchEmployee(id);
	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponceStructure<List<Employee>>> findAll() {
		return service.findAll();
	}
// --------------------------------------------------------------------------------------------------------------------

	@DeleteMapping("/delete/{id}") // path variable
	public ResponseEntity<ResponceStructure<Employee>> deleteEmp(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
// --------------------------------------------------------------------------------------------------------------------

	@PutMapping("/update") // used servise packge
	public ResponseEntity<ResponceStructure<Employee>> updateEmployee(@RequestParam int id,
			@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

// -----------------------------------------------------------------------------------------------

	@PatchMapping("/updatephone")
	public ResponseEntity<ResponceStructure<Employee>> updatePhone(int id, long phone) {
		return service.updatePhone(id, phone);
	}

	// UPDATE EMAIL NUMBER BY ID
	@PatchMapping("/updateemail")
	public ResponseEntity<ResponceStructure<Employee>> updateEmail(int id, String email) {
		return service.updateEmail(id, email);
	}

	// UPDATE NAME NUMBER BY ID
	@PatchMapping("/updatesalary")
	public ResponseEntity<ResponceStructure<Employee>> updateSalary(int id, int salary) {
		return service.updateSalary(id, salary);
	}
// -----------------------------------------------------------------------------------------------

	// FIND ID BY PHONE number
	@GetMapping("/findbyphone")
	public ResponseEntity<ResponceStructure<Employee>> findByphone(long phone) {
		return service.findByphone(phone);
	}

// FIND ID BY Email_id
	@GetMapping("/findbyemail")
	public ResponseEntity<ResponceStructure<Employee>> findbyEmail(String email) {
		return service.findbyEmail(email);
	}

//--------------------------------------------------------------------------------------------------------------------	

// find By address how much id in same place
//	@GetMapping("/findbyempsameaddress")
//	public ResponseEntity<ResponceStructure<Employee>> findByEmpSameAddress(String address) {
//		return service.findByEmpSameAddress(address);
//	}
//-------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/lessthansal")
	public List<Employee> salLessThan(@RequestParam double salary) {
		return service.salLessThan(salary);
	}

	@GetMapping("/SalaryGreaterThan")
	public List<Employee> salMoreThan(@RequestParam double salary) {
		return service.getEmployeeBySalaryGreaterThan(salary);
	}

//--------------------------------------------------------------------	
//	@GetMapping("/salbetween")
//	public List<Employee> getEmployeeBySalaryBetween(double salary1, double salary2) {
//		return service.getEmployeeBySalaryBetween(salary1, salary2);
//	}

}
