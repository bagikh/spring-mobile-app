package com.app.ws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ws.ui.model.request.UserDetailsRequestModel;
import com.app.ws.ui.model.response.UserRest;


// Register this class as REST controller and enable receive/send http request/response
@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue="1")int page, 
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		return "get user was called with page="+page+"limit="+limit+"sort"+sort ;
	}
	
	// Bind GET request. Respond to user request as JSON or XML format
	@GetMapping(path="/{userId}", produces= {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
			})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		UserRest returnValue = new UserRest();
		returnValue.setEmail("test@email.com");
		returnValue.setFirstName("Bagi");
		returnValue.setLastName("Kh");
		
		return new ResponseEntity <UserRest> (HttpStatus.OK) ;
	}
	
	@PostMapping(consumes =	{
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
		}, produces = {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
		})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		return new ResponseEntity <UserRest> (returnValue, HttpStatus.OK);
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
