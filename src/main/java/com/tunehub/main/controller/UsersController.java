package com.tunehub.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.main.entities.Users;
import com.tunehub.main.services.UsersService;

import jakarta.servlet.http.HttpSession;



@Controller
public class UsersController {
	@Autowired
	UsersService service;
@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	{
	boolean userStatus = service.emailExists(user.getEmail());
	if(userStatus==false)
	{
	service.addUser(user);
	System.out.println("user added");
	}
	else {
		System.out.println("user already exist");
	}
	return "home";
	}


@PostMapping("/validate")
public String validate(@RequestParam ("email") String email , 
		@RequestParam ("password") String password , HttpSession session) {
    //TODO: process POST request
    
    if(service.validateUser(email,password)== true){
    	String role = service.getRole(email);
    	if(role.equals("admin")) {
    		return "adminhome";
    	}
    	
    		else {
    			return "customerhome";
    		}
    		
    }
    
    else
    {
    	return "login";
    }
}




}
