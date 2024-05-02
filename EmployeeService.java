package com.qsp.springboot_employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.springboot_employee_management_system.dao.EmployeeDao;
import com.qsp.springboot_employee_management_system.dto.Employee;
import com.qsp.springboot_employee_management_system.exception.DataNotAvailable;
import com.qsp.springboot_employee_management_system.exception.IdNotFound;
import com.qsp.springboot_employee_management_system.exception.EmailNotFound;
import com.qsp.springboot_employee_management_system.exception.PhoneNotFound;
import com.qsp.springboot_employee_management_system.util.ResponceStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponceStructure<Employee>> saveEmployeee(Employee employee) {
		double sal = employee.getSalary();
		if (sal < 10000) {
			employee.setGrade('D');
		} else if (sal > 10000 && sal < 20000) {
			employee.setGrade('C');
		} else if (sal >= 20000 && sal < 400000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		structure.setMassage("data saved ");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmp(employee));
		// return structure;
		return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.CREATED);
	}

//-------------------------------------------------------------------------------------------------------------------	

	public ResponseEntity<ResponceStructure<Employee>> saveAll(List<Employee> list) {
		ResponceStructure<List<Employee>> structure = new ResponceStructure<List<Employee>>();
		for (Employee employee : list) {
			double sal = employee.getSalary();
			if (sal < 10000) {
				employee.setGrade('D');
			} else if (sal > 10000 && sal < 20000) {
				employee.setGrade('C');
			} else if (sal >= 20000 && sal < 400000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
		}
		structure.setMassage("data saved ");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAll(list));
		return new ResponseEntity<ResponceStructure<Employee>>(HttpStatus.CREATED);

	}

// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> fetchEmployee(int id) {
		Employee employee = dao.findEmployee(id);

		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		if (employee != null) {
			structure.setMassage("FOUND");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			// return structure;
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {
			throw new IdNotFound("No Student by this id");
		}
	}

//--------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<List<Employee>>> findAll() {
		List<Employee> list = dao.findAll();
		ResponceStructure<List<Employee>> structure = new ResponceStructure<List<Employee>>();
		if (list.isEmpty()) {
			structure.setMassage("data not FOUND");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			// return structure;
			throw new IdNotFound("Employee not found");
		} else {
			structure.setMassage("FOUND Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}
	}

// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> deleteEmployee(int id) {
		Employee employee = dao.findEmployee(id);
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		if (employee != null) {
			structure.setMassage("Found , Delete Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.deleteEmployee(employee));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotAvailable("ERROr--> Id Is Not Found");
		}
	}

// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> updateEmployee(int id, Employee employee) {
		Employee dbe = dao.findEmployee(id);
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		if (dbe != null) {
			employee.setId(id);
			double sal = employee.getSalary();
			if (sal < 10000) {
				employee.setGrade('D');
			} else if (sal > 10000 && sal < 20000) {
				employee.setGrade('C');
			} else if (sal >= 20000 && sal < 400000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
			structure.setMassage("FOUND , Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateEmp(id, employee));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotAvailable("id not found");
		}
	}
// -------------------------------------------------------------------------------------------------------------------

	// update phone
	public ResponseEntity<ResponceStructure<Employee>> updatePhone(int id, long phone) {
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			employee.setPhone(phone);
			structure.setMassage("FOUND, Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updatephone(id, phone));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new PhoneNotFound("phone not found");
		}
	}

// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> updateEmail(int id, String email) {
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			employee.setEmail(email);
			structure.setMassage("FOUND ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateEmail(id, email));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmailNotFound("email not found");
		}
	}
// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> updateSalary(int id, int salary) {
		Employee employee = dao.findEmployee(id);
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		if (employee != null) {
			double sal = employee.getSalary();
			if (sal < 10000) {
				employee.setGrade('D');
			} else if (sal > 10000 && sal < 20000) {
				employee.setGrade('C');
			} else if (sal >= 20000 && sal < 400000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
			employee.setSalary(salary);
			structure.setMassage("FOUND succefully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateSalary(id, salary));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("salary not found");
		}
	}
// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> findByphone(long phone) {
		Employee employee = dao.findByphone(phone);
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		if (employee != null) {
			structure.setMassage("FOUND");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByphone(phone));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new PhoneNotFound("Phone  not found");
		}
	}
// -------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<ResponceStructure<Employee>> findbyEmail(String email) {
		Employee employee = dao.findbyEmail(email);
		ResponceStructure<Employee> structure = new ResponceStructure<Employee>();
		if (employee != null) {
			structure.setMassage("FOUND");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findbyEmail(email));
			return new ResponseEntity<ResponceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmailNotFound("Email not found");
		}
	}

// -------------------------------------------------------------------------------------------------------------------

//	public ResponseEntity<ResponceStructure<Employee>> findByEmpSameAddress(String address) {
//		List<Employee> list=dao.findByEmpSameAddress(address);
//		ResponceStructure<List<Employee>> structure = new ResponceStructure<List<Employee>>(); 
//		if (list.isEmpty()) {
//			structure.setMassage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData( dao.findByEmpSameAddress(address));
//			return new ResponseEntity<ResponceStructure<Employee>>(HttpStatus.NOT_FOUND);
//		} else {
//			throw new DataNotAvailable("Data not available");
//		}
//		//return dao.findByEmpSameAddress(address);
//	}
	// ------------------------------------------------------------------------------------------------------------------

	public List<Employee> salLessThan(double salary) {
		return dao.findBysalLessThan(salary);
	}

	public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
		return dao.getEmployeeBySalaryGreaterThan(salary);
	}

//	public List<Employee> getEmployeeBySalaryBetween(double salary1, double salary2) {
//		return dao.getEmployeeBySalaryBetween(salary1,salary2);
//	}

}
