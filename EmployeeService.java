package com.assignment.employment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.employment.dao.EmployeeDao;
import com.assignment.employment.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDAO;
	
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}
	
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeDAO.getAllEmployees();
	}
	
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}
	
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}
}
