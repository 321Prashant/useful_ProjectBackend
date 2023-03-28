package com.example.useful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.useful.CustomExceptionHadling.ControllerException;
import com.example.useful.CustomExceptionHadling.ServiceException;

import com.example.useful.entity.Roless;
import com.example.useful.service.RolesService;

@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	public RolesService rolesService;
	
	@GetMapping("/getAllUsers")
	public List<Roless> getAllRoles(){
		List<Roless> rolesFetched;
		try {
			rolesFetched = rolesService.getAllRoles();
			return rolesFetched;
		}
		catch (ServiceException e) {
			throw new ControllerException("roles exception 40"+e.getErrorCode(),"controller actual exception is"+e.getErrorMessage());
		}
	}
	
	@PutMapping("/updateUser/{id}")
	public Roless updateRole(@PathVariable Integer id, @RequestBody Roless role){
		try {
			Roless roles = rolesService.updateRoles(id, role);
			return roles;
		}
		catch (ServiceException e) {
			throw new ControllerException("roles exception 40"+e.getErrorCode(),"controller actual exception is"+e.getErrorMessage());
		}
	}
	@DeleteMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable Integer id){
		try {
			return rolesService.deleteRole(id);
		}
		catch (ServiceException e) {
			throw new ControllerException("roles exception 40"+e.getErrorCode(),"controller actual exception is"+e.getErrorMessage());
		}
	}
}
