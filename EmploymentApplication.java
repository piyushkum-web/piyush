package com.assignment.employment;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.employment.model.Employee;
import com.assignment.employment.service.EmployeeService;

@SpringBootApplication
public class EmploymentApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmploymentApplication.class, args);
	}
	
	@Override
	public void run(String...args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- Employee Database Menu ---");
			System.out.println("1. Add Employee");
			System.out.println("2. Get Employee by ID");
			System.out.println("3. Get All Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.println("Enter choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1->{
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Name: ");
				String name = sc.nextLine();
				
				System.out.println("Enter Salary: ");
				double salary = sc.nextDouble();
				sc.nextLine();
				
				Employee emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				
				
				employeeService.addEmployee(emp);
				System.out.println("Employee added.");
			}
			
			case 2 ->{
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				Employee emp = employeeService.getEmployeeById(id);
				if(emp != null) {
					System.out.println("ID: "+ emp.getId());
					System.out.println("Name: "+ emp.getName());
					System.out.println("Salary: "+ emp.getSalary());
				}else {
					System.out.println("Employee not found");
				}
			}
			
			case 3 ->{
				List<Employee> employees = employeeService.getAllEmployee();
				if(employees.isEmpty()) {
					System.out.println("No employee found.");	
				}else {
					for(Employee e: employees) {
						System.out.println("ID: "+ e.getId() + ", Name: "+ e.getName() + ", Salary: "+e.getSalary());
					}
				}
			}
			case 4 ->{
				System.out.print("Enter ID of employee to update: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter new name: ");
				String name = sc.nextLine();
				
				System.out.print("Enter new salary: ");
				double salary = sc.nextDouble();
				
				Employee emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				
				employeeService.updateEmployee(emp);
				System.out.println("Employee updated.");
			}
			
			case 5 -> {
				System.out.println("Enter ID to delete: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				employeeService.deleteEmployee(id);
				System.out.println("Employee deleted.");
			}
			
			case 6 -> {
				System.out.println("Exiting...");
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

}
