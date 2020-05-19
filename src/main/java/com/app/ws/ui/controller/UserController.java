package com.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Register this class as REST controller and enable receive/send http request/response
@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	// Bind GET request
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId) {
		return "get user was called" + userId ;
	}
	
	@PostMapping
	public String createUser() {
		return "create user was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
	
}
