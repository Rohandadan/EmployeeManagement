package com.project.EmployeeMangementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EmployeeMangementSystem.entity.Employee;

@Repository
public interface Employeerepository extends JpaRepository<Employee,String>{
	Employee findByEmployeeId(String employeeId);
}
