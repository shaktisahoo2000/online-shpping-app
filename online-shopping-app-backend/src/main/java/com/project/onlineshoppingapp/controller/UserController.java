package com.project.onlineshoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlineshoppingapp.model.User;
import com.project.onlineshoppingapp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/shopping")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// http://localhost:8081/api/v1.0/shopping/register
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		log.info("Calling Register user Endpoint...");
		return ResponseEntity.ok(userService.register(user));
	}
	
	// http://localhost:8081/api/v1.0/shopping/login
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		log.info("Calling user login Endpoint...");
		return ResponseEntity.ok(userService.login(user));
	}

	
	// http://localhost:8081/api/v1.0/shopping/getAllUsers
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		log.info("Calling getAllUsers Endpoint...");
		return ResponseEntity.ok(userService.getAllUsers());	
	}	
	
	// http://localhost:8081/api/v1.0/shopping/updateUser/21001
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long userId){
		log.info("Calling updateUser Endpoint...");
		return ResponseEntity.ok(userService.updateUser(user, userId));
	}
	
	// http://localhost:8081/api/v1.0/shopping/deleteUser/21004
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
	    log.info("Calling deleteUser EndPoint...");
	    return ResponseEntity.ok(userService.deleteUser(userId));
	}
	
	@GetMapping("/test")
	public String test() {
		return "Hi From Test";
	}
	
	
	
	
}
