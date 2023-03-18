package com.example.useful.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.CustomExceptionHadling.ServiceException;
import com.example.useful.entity.Address;
import com.example.useful.entity.Users;
import com.example.useful.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	

	public List<Address> getAllAddress() {
		
		List<Address> address = addressRepository.findAll();
		if(address.isEmpty()) {
			throw new ServiceException("800","Exception from service layer is fetching address is:no address found ");
		}
		try {
			return address;
		}
		catch (Exception e) {
			throw new ServiceException("801","Exception from service layer is fetching address "+e.getMessage());
		}
	}
	
	     //ONETOMANY mapping user with address 
		//	update address seperately taking addressID ,,we are updating addresses in users 
		public Address updateAddress(Address address, Integer id) {
			
		try {
			
			Address addressUpdated= addressRepository.findById(id).get();
			addressUpdated.setAddressId(address.getAddressId());
			addressUpdated.setCity(address.getCity());
			addressUpdated.setCountry(address.getCountry());
			addressUpdated.setLocalAddress(address.getLocalAddress());
			
			addressUpdated.setUser(address.getUser());
			
			
			return addressRepository.save(addressUpdated); 
			
 
			}
			catch (Exception e) {
				throw new ServiceException("301","Exception is"+e.getMessage());
				// TODO: handle exception
			}
		}

		public List<Address> updateAddressList(List<Address> address) {
			try {
				for(Address addresses:address) {
				Address updatedAddress = addressRepository.findById(addresses.getAddressId()).get();
				updatedAddress.setCity(addresses.getCity());
				updatedAddress.setCountry(addresses.getCountry());
				updatedAddress.setLocalAddress(addresses.getLocalAddress());
				updatedAddress.setUser(addresses.getUser());
				
				addressRepository.save(updatedAddress);
			}
				return address;
			}
			
			catch (Exception e) {
				throw new ServiceException("301","Exception is"+e.getMessage());
				// TODO: handle exception
			}
		}

		public String deleteAddress(Integer id) {
			
		 addressRepository.deleteById(id);
		 return "Address deleted";
			
		}
	
	
		//	update all addresses taking addressList ,,we are updating addresses in users
		
		
}
