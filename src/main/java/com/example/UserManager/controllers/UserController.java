package com.example.UserManager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting all Users");
		Iterable<User> users = userService.GetAllUsers();
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "users";
    }
	@GetMapping("/findUser")
	public String findUser(@RequestParam("idNum") int idNum, ModelMap model) {
		logger.info("Searching for User");
		User user = userService.GetUserById(idNum);
		logger.info("Sending User Info to View");
		model.addAttribute("user",user);
		return "userUpdateForm";	
	}
	
	@PostMapping("/update")
	public String updateUserInfo(@RequestParam("idNum") Integer idNum,
			@RequestParam("password") String password,@RequestParam("email") String email,
			@RequestParam("name") String name) {
		
		logger.info("Finding User");
		User user = userService.GetUserById(idNum);
		logger.info("Updating User's Email");
		user.setEmail(email);
		logger.info("Updating User's Name");
		user.setName(name);
		logger.info("Updating User's Password");
		user.setPassword(password);
		logger.info("Save Updated User Object");
		userService.UpdateUser(user);  
		
		return "success";
	}

}