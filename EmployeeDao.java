package com.qsp.springboot_employee_management_system.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.springboot_employee_management_system.dto.Employee;
import com.qsp.springboot_employee_management_system.repo.EmployeeRepo;

@Repository // ----------> it is CRUD class
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo; // refernce of repo class

//1.save
	public Employee saveEmp(Employee employee) {
		return repo.save(employee);
	}

//2.saveall	
	public List<Employee> saveAll(List<Employee> list) {
		return repo.saveAll(list);
	}

//3.findemployee	
	public Employee findEmployee(int id) {
		return repo.findById(id).get();
	}

//4.findall	
	public List<Employee> findAll() {
		return repo.findAll();
	}

//5.delete employee	
//	public Employee deleteEmployee(Employee employee) {
//		 repo.delete(employee);
//       return employee;
//	}

//	public Employee deleteEmployee(Employee employee) {
//		Optional<Employee> optional = repo.findById(id);
//		if (optional.isPresent()) {
//	Employee e = optional.get();
//			repo.delete(e);
//			return e;
//		}
//		return null;
//	}

//--------------------------------------------------------------------

	public Employee updateEmp(int id, Employee e) {
		return repo.save(e);
	}

	public Employee updatephone(int id, long phone) {
		Employee employee = findEmployee(id);
		return repo.save(employee);

	}

	public Employee updateEmail(int id, String email) {
		Employee employee = findEmployee(id);
		return repo.save(employee);
	}

	public Employee updateSalary(int id, int salary) {
		Employee employee = findEmployee(id);
		return repo.save(employee);
	}
	// -------------------------------------------------

	public Employee findByphone(long phone) {
		return repo.findEmpByPhone(phone);
	}

	public Employee findbyEmail(String email) {
		return repo.findEmpByEmail(email);
	}

	public Employee deleteEmployee(Employee employee) {
		repo.delete(employee);
		return employee;
	}
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//
//	public List<Employee> findByEmpSameAddress(String address) {
//		return repo.findByEmpSameAddress(address);
//	}
//--------------------------------------------------------------------------------

	public List<Employee> findBysalLessThan(double salary) {
		return repo.findEmployeeBySalaryLessThan(salary);
	}

	public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
		return repo.getEmployeeBySalaryGreaterThan(salary);
	}

//	public List<Employee> getEmployeeBySalaryBetween(double salary1, double salary2) {
//	  return repo.getEmployeeBySalaryBetween(salary1,salary2);
//	}
}
//----------------------------------------------------------------------------------------------

