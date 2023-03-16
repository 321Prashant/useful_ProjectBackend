package com.example.useful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.CustomExceptionHadling.ControllerException;
import com.example.useful.CustomExceptionHadling.ServiceException;
import com.example.useful.entity.Users;
import com.example.useful.service.UserService;

@CrossOrigin("*")
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
	
	@GetMapping("/getAllUsers/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Integer id){
		Users users = userService.getUserById(id);
		return ResponseEntity.ok(users);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Users user){
		try{
			Users userSaved = userService.saveUser(user);
			return new ResponseEntity<Users>(userSaved,HttpStatus.CREATED);
		}
		catch (ServiceException e) {
		ControllerException ex = new ControllerException(e.getErrorCode(),e.getErrorMessage());
//		throw new ControllerException(ex.getErrorCode(),ex.getErrorMessage());
		return new ResponseEntity<ControllerException>(ex, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateUser/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable Integer id) {
		 Users updateUsers = userService.updateUser(user,id);
		 return updateUsers;
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}	 
	
	@GetMapping("/getCompanyOfUser/{id}")
	public Users getUserCompany(@PathVariable Integer id) {
		return userService.getCompanyOfUser(id);
		
		
	}

}
