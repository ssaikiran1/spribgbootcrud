package com.mavencrud.simplemavencrud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	@Autowired
	private IEmpRepository emprepo;

	// mapping the getAllEmployees() method to /employees
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {

		List<Employee> emps = emprepo.getAllEmployees();

		return emps;
	}

	@RequestMapping(value = "/employees/{id}")
	public ResponseEntity<Object> getEmployeeByEmpNo(@PathVariable("id") int id) {
		return new ResponseEntity<>(emprepo.getEmployeeByEmpNo(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		System.out.println("hii");
		ArrayList<Employee> x = emprepo.deleteEmployee(id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Employee emp) {
		emprepo.updateEmployee(emp);
		return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee emp) {
		emprepo.addEmployee(emp);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/emps")
	public ResponseEntity<Object> getEmployees() {
		return new ResponseEntity<>(emprepo.getAllEmployees(), HttpStatus.OK);
	}
}