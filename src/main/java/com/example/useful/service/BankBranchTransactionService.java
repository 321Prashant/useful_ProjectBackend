package com.example.useful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.entity.BankBranchTransaction;
import com.example.useful.repository.BankBranchTransactionRepository;

@Service
public class BankBranchTransactionService {

	@Autowired
	private BankBranchTransactionRepository bankBranchTransactionRepository;
	
	public BankBranchTransaction save(BankBranchTransaction bankBranchTransaction) {
		return bankBranchTransactionRepository.save(bankBranchTransaction);
	}

}
