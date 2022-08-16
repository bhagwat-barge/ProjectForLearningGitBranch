package com.InclusiveEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.InclusiveEmployee.model.Employee;
import com.InclusiveEmployee.service.ServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceImpl serviceImpl;

	@PostMapping(value = "/saveemp", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee e) {

		Employee saveEmp = serviceImpl.saveEmp(e);
		return new ResponseEntity<Employee>(saveEmp, HttpStatus.CREATED);

	}

	@PostMapping(value = "/savealldata", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Employee>> saveAllEmp(@RequestBody List<Employee> e) {

		List<Employee> saveAllEmp = serviceImpl.saveAllEmp(e);

		return new ResponseEntity<List<Employee>>(saveAllEmp, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getid/{id}", produces = "application/json")
	public ResponseEntity<Employee> getById(@PathVariable Integer id) {

		Employee empById = serviceImpl.getEmpById(id);

		return new ResponseEntity<Employee>(empById, HttpStatus.OK);

	}

	@GetMapping(value = "/getall", produces = "application/json")
	public ResponseEntity<List<Employee>> getAll() {

		List<Employee> allEmp = serviceImpl.getAllEmp();

		return new ResponseEntity<List<Employee>>(allEmp, HttpStatus.OK);

	}

	@GetMapping(value = "/getbyage/{age}", produces = "application/json")
	public ResponseEntity<List<Employee>> getByAge(@PathVariable Integer age) {

		List<Employee> empByAge = serviceImpl.getEmpByAge(age);

		return new ResponseEntity<List<Employee>>(empByAge, HttpStatus.OK);

	}

	@PutMapping(value = "/updateEmp")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee e) {

		Employee updateEmp = serviceImpl.updateEmp(e);

		return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmpMul", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Employee>> updateMultipleEmp(@RequestBody List<Employee> e) {

		List<Employee> updateMultiEmp = serviceImpl.updateMultiEmp(e);

		return new ResponseEntity<List<Employee>>(updateMultiEmp, HttpStatus.OK);
	}

	@GetMapping(value = "/logincheck/{id}/{name}")
	public ResponseEntity<String> loginCheck(@PathVariable Integer id, @PathVariable String name) {

		Employee loginCheck = serviceImpl.loginCheck(id, name);

		if (loginCheck == null) {

			return new ResponseEntity<String>("Invalid Credentials", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Login Successfully", HttpStatus.FOUND);
	}

	@GetMapping(value = "/deletebyid{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {

		String deleteById = serviceImpl.deleteById(id);
		return new ResponseEntity<String>(deleteById, HttpStatus.OK);
	}

	@GetMapping(value = "/deleteall")
	public ResponseEntity<String> deleteAll() {

		serviceImpl.deleteAll();

		return new ResponseEntity<String>("All Data Deleted Successfully", HttpStatus.OK);

	}
}