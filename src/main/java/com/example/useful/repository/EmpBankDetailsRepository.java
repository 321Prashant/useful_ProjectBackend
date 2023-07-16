package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.useful.entity.EmpBankDetails;

public interface EmpBankDetailsRepository extends JpaRepository<EmpBankDetails,Integer>{

	EmpBankDetails findByAccountNo(String accountNumber);

	

}
