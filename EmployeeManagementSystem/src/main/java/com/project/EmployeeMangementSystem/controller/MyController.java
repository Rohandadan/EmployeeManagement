package com.project.EmployeeMangementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.EmployeeMangementSystem.Repository.Employeerepository;
import com.project.EmployeeMangementSystem.entity.Employee;
import com.project.EmployeeMangementSystem.service.Employeeservice;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@Autowired
	Employeeservice employeeService;

	@Autowired
	private Employeerepository empRepo;

	@GetMapping("/Home")
	public String index() {
		return "Home.html";
	}

	@GetMapping("/Create_Employee")
	public String showCreateEmployee(@ModelAttribute("employee") Employee employee) {
		return "Create_Employee.jsp";
	}

	@PostMapping("/Create_Employee")
	public String newEmployee(@Valid Employee employee, BindingResult result, Model model) {
		String view = "";
		
		if (result.hasErrors()) {
			view = "Create_Employee.jsp";			
		}
		else {

			employee.setEmployeeId(employee.generator());
			String num = employee.getEmployeeId();
			model.addAttribute("EmployeeId", num);
			employeeService.makeNewEmployee(employee);
			view = "Employee_Created.jsp";

		}
		return view;
	}

	@GetMapping("Delete_Employee")
	public String deleteempage() {
		return "Delete_Employee.jsp";
	}

	@PostMapping("Delete_Employee")
	public String deleteem(@RequestParam String employeeId) {
		if (employeeService.deleteEmployee(employeeId)) {
			return "Employeedeleted.jsp";
		} else {
			return "employeenotfound.jsp";
		}
	}

	@GetMapping("Update_Employee")
	public String showemployeePage(@ModelAttribute("employee") Employee employee) {
		return "Update_Employee.jsp";
	}

	@PostMapping("Update_Employee")
	public String addemployeePage(@Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			if (!employeeService.isValidEmployee(employee.getEmployeeId())){
				model.addAttribute("invalid_id", "Employee Id does not exist.");
				return "Update_Employee.jsp";
			}
			return "Update_Employee.jsp";
		}
		else if (!employeeService.isValidEmployee(employee.getEmployeeId())){
			model.addAttribute("invalid_id", "Employee Id does not exist.");
			return "Update_Employee.jsp";
		}
		else if (employeeService.UpdateEmployee(employee)) {
			return "EmployeeUpdated.jsp";
		} else {
			return "employeenotfound.jsp";
		}

	}

	@GetMapping("/viewEmployee")
	public String searchEmployee() {
		return "View_Employee.jsp";
	}

	@PostMapping("/viewEmployee")
	public String viewEmployee(@RequestParam("employeeId") String employeeId, Model model) {
		
		if (!employeeService.isValidEmployee(employeeId)){
//			model.addAttribute("invalid_id", "Employee Id does not exist."); 
			return "employeenotfound.jsp";
		}
		else {
		Employee employee = empRepo.findByEmployeeId(employeeId);
		model.addAttribute("employee", employee);
		return "Employeeview.jsp";
		}
	}
}