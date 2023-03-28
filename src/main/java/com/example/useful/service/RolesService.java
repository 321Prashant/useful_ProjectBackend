package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.CustomExceptionHadling.ServiceException;

import com.example.useful.entity.Roless;
import com.example.useful.repository.RolesRepository;

@Service
public class RolesService {

	@Autowired
	private RolesRepository rolesRepository;
	
	public List<Roless> getAllRoles() {
		List<Roless> rolesFetched=  rolesRepository.findAll();
		if(rolesFetched.isEmpty())
		{
			throw new ServiceException("1000 from service roles","roles seems empty");
		}
		try {
			return rolesFetched;
		} 
		catch (Exception e) {
			throw new ServiceException("1000 from service roles","actual exception is:"+e.getMessage());
			}
	}

	public String deleteRole(Integer id) {
		try {
			rolesRepository.deleteById(id);
			return "Role deleted";
		}
		catch (Exception e) {
			throw new ServiceException("1000 from service roles","actual exception is:"+e.getMessage());
			
		}
		
	}

	 
	public Roless updateRoles(Integer id, Roless role) {
		Roless roleToUpdate = rolesRepository.findById(id).get();
		try {
			roleToUpdate.setRoleType(role.getRoleType());
			roleToUpdate.setUser(role.getUser());
			return roleToUpdate;
		}
		catch (Exception e) {
			throw new ServiceException("1000 from service roles","actual exception is:"+e.getMessage());
			
		}
	}

}
