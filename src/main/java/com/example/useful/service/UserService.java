package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.entity.Users;
import com.example.useful.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	public UsersRepository usersRepository;
	
	public List<Users> getAllUsers() {
		
		return usersRepository.findAll();
	}

	public Users saveUser(Users user) {
		return usersRepository.save(user);
	}

	public Users updateUser(Users user, Integer id) {
		Users userTobeUpdated = usersRepository.findById(id).get();
		
		userTobeUpdated.setName(user.getName());
		userTobeUpdated.setDescription(user.getDescription());
		userTobeUpdated.setUserRole(user.getUserRole());
		return usersRepository.save(userTobeUpdated); 	
		
	}

	public String deleteUser(Integer id) {
	usersRepository.deleteById(id);
		return "User deleted";
	}

}
