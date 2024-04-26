package com.project.EmployeeMangementSystem.entity;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {

	@Id
	@Column(name = "employeeId")
	private String employeeId;

	@Pattern(regexp="[A-Za-z]*", message="Enter the alphabets only.")
	@NotBlank(message="Employee Name is required.")
	private String employeeName;
	
	@Pattern(regexp="^\\S+@gmail\\.com$", message="Invalid Email Id.")
	private String email;
	
	@Pattern(regexp="[A-Za-z]*", message="Enter the alphabets only.")
	@NotBlank(message="Designation is required.")
	private String designation;
	
	@Pattern(regexp="[A-Za-z]*", message="Enter the alphabets only.")
	@NotBlank( message="Location is Required.")
	private String location;
	
	@Pattern(regexp="[6-9]{1}[0-9]{9}", message="Enter valid 10 digit mobile number.")
	private String contactNumber;
	
	@Min(value=5000, message="Minimum salary should be 5000.")
	@NotNull(message="Salary is required.")
	private Double salary;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String id) {
		this.employeeId = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee() {

	}

	public String generator() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder(7);
		for (int i = 0; i < 4; i++) {
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}

	public Employee(String employeeId, String employeeName, String email, String designation, String location,
			String contactNumber, double salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.designation = designation;
		this.location = location;
		this.contactNumber = contactNumber;
		this.salary = salary;
	}

}
