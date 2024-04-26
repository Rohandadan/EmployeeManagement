package com.project.EmployeeMangementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {
	 @GetMapping("login")
	    public String showLoginForm() {
	        return "login.html"; 

} 
	 @PostMapping("login")
	    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
	        
	    	if(username.equals("akhil") && password.equals("narra")) {
	    		return "redirect:/Home";
	    	}
	        
	        return "redirect:login";
	    }


	}
