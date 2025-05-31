package com.assignment.employment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.assignment.employment.model.Employee;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class EmployeeRowMapper implements RowMapper<Employee>{
		public Employee mapRow(ResultSet rs, int rowNum) {
			Employee emp = new Employee();
			try {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
			}catch(Exception e) {
				System.out.println("Error mapping row:" + e.getMessage());
			}
			return emp;
		}

		
	}
	
	@Override
	public void addEmployee(Employee employee) {
		String sql = "insert into employee(id, name, salary) values(?, ?, ?)";
		jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getSalary());
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee where id = ?";
		return  jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
	}
	
	public List<Employee> getAllEmployee(){
		return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
	}
	
	public void updateEmployee(Employee employee) {
		String sql = "update employee set name = ?, salary = ? where id = ?";
		jdbcTemplate.update(sql, employee.getName(), employee.getSalary(), employee.getId());
	}
	
	public void deleteEmployee(int id) {
		String sql = "delete from employee where id=?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
