package com.InclusiveEmployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InclusiveEmployee.model.Employee;
import com.InclusiveEmployee.repository.EmployeeRepository;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee saveEmp(Employee e) {
		// TODO Auto-generated method stub
		Employee save = repo.save(e);
		
		return save;
	}

	@Override
	public List<Employee> saveAllEmp(List<Employee> e) {
		// TODO Auto-generated method stub
		
		List<Employee> saveAll = repo.saveAll(e);
		return saveAll;
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		Employee findById = repo.findById(id).get();
		System.out.println(findById);
		return findById;
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public List<Employee> getEmpByAge(int age) {
		// TODO Auto-generated method stub
		List<Employee> findByAge = repo.findByAgeLessThanEqual(age);
		
		return findByAge;
	}

	@Override
	public Employee updateEmp(Employee e) {
		// TODO Auto-generated method stub
		Employee save = repo.save(e);
		
		return save;
	}

	@Override
	public List<Employee> updateMultiEmp(List<Employee> e) {
		// TODO Auto-generated method stub
		List<Employee> saveAll = repo.saveAll(e);
		return saveAll;
	}

	@Override
	public Employee loginCheck(int id, String name) {
		// TODO Auto-generated method stub
		Employee findByIdAndName = repo.findByIdAndName(id, name);
		return findByIdAndName;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Id deleted Successfully";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll();
		
		return "All Data Deleted Successfully";
	}

}
