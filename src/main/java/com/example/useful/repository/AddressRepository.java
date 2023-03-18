package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	
}
