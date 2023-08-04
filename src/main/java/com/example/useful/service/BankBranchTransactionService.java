package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//	public ResponseEntity<?> lastTenTransactions(List<BankBranchTransaction> bankBranchTransaction) {
//		
//		return bankBranchTransactionRepository.lastTenTransactions(bankBranchTransaction);
//	}

}
