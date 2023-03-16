package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.CustomExceptionHadling.ServiceException;
import com.example.useful.entity.Company;
import com.example.useful.entity.Users;
import com.example.useful.repository.CompanyRepository;
import com.example.useful.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	public UsersRepository usersRepository;
	@Autowired
	public CompanyRepository companyRepository;
	
	public List<Users> getAllUsers() {
		
		return usersRepository.findAll();
	}

	public Users saveUser(Users user) {
		if(user.getName().isEmpty() || user.getName() == null) {
			throw new ServiceException("300","Your name is empty please check it again");
		}
		try {
			return usersRepository.save(user);
				
		}
		catch (Exception e) {
			throw new ServiceException("301","Exception is"+e.getMessage());
			// TODO: handle exception
		}
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

	public Users getUserById(Integer id) {
		Users user = usersRepository.findById(id).get();
		return user;
	}
	
	
	//need to watch
	public Users getCompanyOfUser(Integer id) {
		Users userOfCompany = companyRepository.findUserFromCompany(id);
		if(userOfCompany == null)
			throw new ServiceException("100","User of this company didn't exists");
		try {
			return  userOfCompany;
		}
		catch(Exception e) {
			throw new ServiceException("900","Exception occurs on searching user from a company"+e.getMessage());
		}
	}

}
