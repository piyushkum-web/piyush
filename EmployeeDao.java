package com.assignment.employment.dao;

import java.util.List;

import com.assignment.employment.model.Employee;

public interface EmployeeDao {
	
	void addEmployee(Employee employee);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();
	void updateEmployee(Employee employee);
	void deleteEmployee(int id);

}
