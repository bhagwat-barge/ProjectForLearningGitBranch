package com.InclusiveEmployee.service;

import java.util.List;

import com.InclusiveEmployee.model.Employee;

public interface ServiceI {

	
	public Employee saveEmp(Employee e);
	
	public List<Employee> saveAllEmp(List<Employee> e);
	
	public Employee getEmpById(int id);
	
	public List<Employee> getAllEmp();
	
	public List<Employee> getEmpByAge(int age);
	
	public Employee updateEmp(Employee e);
	
	public List<Employee> updateMultiEmp(List<Employee> e);
	
	public Employee loginCheck(int id,String name);
	
	public String deleteById(int id);
	
	public String deleteAll();
}
