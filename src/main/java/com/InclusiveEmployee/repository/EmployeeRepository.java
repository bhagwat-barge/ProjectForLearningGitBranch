package com.InclusiveEmployee.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InclusiveEmployee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

	public List<Employee> findByAgeLessThanEqual(int age);
	
	public Employee findByIdAndName(int id,String name);
	
	
}
