package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.entity.BankBranchDetails;
import com.example.useful.repository.BankDetailsRepository;

@Service
public class BankDetailsService {

	@Autowired
	private BankDetailsRepository bankDetailsRepository;
	public BankBranchDetails save(BankBranchDetails bankDetails) {
		return bankDetailsRepository.save(bankDetails);
	}
	public List<BankBranchDetails> findAll() {
		return bankDetailsRepository.findAll();
	}
	public BankBranchDetails findById(String id) {
		return bankDetailsRepository.findById(id).get();
	}

}
