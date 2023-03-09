package com.example.useful.controller;

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

import com.example.useful.entity.Users;
import com.example.useful.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

	@Autowired
	public UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Users>> getAllUser(){
		List<Users> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
		

	
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Users> addUser(@RequestBody Users user){
		Users userSaved = userService.saveUser(user);
		return ResponseEntity.ok(userSaved);
	}
	
	@PutMapping("/updateUser/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable Integer id) {
		 Users updateUsers = userService.updateUser(user,id);
		 return updateUsers;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}	 
}
