package com.example.useful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.CustomExceptionHadling.ControllerException;
import com.example.useful.CustomExceptionHadling.ServiceException;
import com.example.useful.entity.Address;
import com.example.useful.entity.Users;
import com.example.useful.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<?> getAllAddress() {
		try {
			List<Address> address = addressService.getAllAddress();
			return new ResponseEntity<List<Address>>(address,HttpStatus.ACCEPTED);
		}
		catch(ServiceException ex) {
			ControllerException controllerException = new ControllerException(ex.getErrorCode(),ex.getErrorMessage());
			return new ResponseEntity<ControllerException>(controllerException,HttpStatus.NOT_FOUND);
		}
	}
	
	//	Updating address in user and one at a time, sharing address ID
	@PutMapping("/updateAddressInUser/{id}")
	public ResponseEntity<?> updateAddressInUser(@RequestBody Address address, @PathVariable Integer id) {
		try {
			 Address addressUpdated = addressService.updateAddress(address,id);
			 return new ResponseEntity<Address>(addressUpdated, HttpStatus.ACCEPTED);
		}
		catch (ServiceException e) {
			ControllerException ex = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ex, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	//	Updating address in user and multiple at a time, sharing address ID
	@PutMapping("/updateAllAddressForUser")
	public ResponseEntity<?> updateAddressInUser(@RequestBody List<Address> address) {
		try {
			List<Address> addressesUpdated = addressService.updateAddressList(address);
			 return new ResponseEntity<List<Address>>(addressesUpdated, HttpStatus.ACCEPTED);
		}
		catch (ServiceException e) {
			ControllerException ex = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ex, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<?> deleteAddressInUser(@PathVariable Integer id) {
		try {
			 String addressDeleted = addressService.deleteAddress(id);
			 return new ResponseEntity<String>(addressDeleted, HttpStatus.ACCEPTED);
		}
		catch (ServiceException e) {
			ControllerException ex = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ex, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
