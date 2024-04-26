package com.project.EmployeeMangementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.EmployeeMangementSystem.Repository.Employeerepository;
import com.project.EmployeeMangementSystem.entity.Employee;
@Service
public class Employeeservice {
	@Autowired
	Employeerepository employeerepo;
	
	public void makeNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeerepo.save(employee);
		
	}
	public boolean deleteEmployee(String employeeId) {
		// TODO Auto-generated method stub
		Employee emp = employeerepo.findByEmployeeId(employeeId);
		if(emp !=null) {
			employeerepo.deleteById(employeeId);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean UpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employee !=null) {
			employeerepo.save(employee);
			return true;
		}
		else {
			return false;
		}
	} 
	
	public boolean viewEmployee(String employeeId, Model model) {
		// TODO Auto-generated method stub
		Employee emp = employeerepo.findByEmployeeId(employeeId);
		if(emp !=null) {
			model.addAttribute("emp",employeerepo.findById(employeeId));
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isValidEmployee(String employeeId) {
		Employee emp = employeerepo.findById(employeeId).orElse(null);
		if(emp!=null) {
			return true;
		}
		else {
			return false;
		}
	}

}
