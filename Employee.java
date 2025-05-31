package com.assignment.employment.model;

public class Employee {

	private int id;
	private String name;
	private double salary;
	
	// we will provide constructors for the class with and without parameters
	public Employee() {}
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	// providing getters and setters
	
	public void setId(int id) {
		this.id= id;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return name;
	}
	
	public void setSalary(double salary) {
		this.salary= salary;
	}
	public double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return String.format("Employee{id=%id, name='%s', salary=%.2f}",id, name, salary);
		}
}
