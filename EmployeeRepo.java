package com.qsp.springboot_employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springboot_employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findEmpByPhone(long phone);

	Employee findEmpByEmail(String email);

//	@Query("SELECT e    FROM employee e  WHERE e.address=?1")
//	List<Employee> findByEmpSameAddress(String address);

	List<Employee> findEmployeeBySalaryLessThan(double salary);

	List<Employee> getEmployeeBySalaryGreaterThan(double salary);

	@Query("select e  FROM Employee e WHERE e.salary between ?1 AND ?2")
	List<Employee> getEmployeeBySalaryBetween(double salary1, double salary2);

}
