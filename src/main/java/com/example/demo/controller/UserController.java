package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return dao.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUserById(@PathVariable int id) {
		
		return dao.findOne(id);
	}
	
	@PostMapping("users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		
		User savedUser = dao.save(user);
		
		 URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		 return ResponseEntity.created(location).build();
	}
	

}
