package com.example.useful.controller;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.entity.BankBranchTransaction;
import com.example.useful.service.BankBranchTransactionService;
import com.example.useful.service.EmpBankDetailsService;

@RestController
@RequestMapping("/bankTransaction")
public class BankBranchTransactionController {

	@Autowired
	private BankBranchTransactionService bankBranchTransactionService;
	@Autowired
	private EmpBankDetailsService empBankDetailsService;
	
	@PostMapping("/makeTransaction/{accountNumber}")
	public ResponseEntity<?> makeTransaction(@RequestBody BankBranchTransaction bankBranchTransaction, @PathVariable String accountNumber){
		
		float balanceToUpdate = empBankDetailsService.findTransactionFromAccountToUpdateBalance(accountNumber);
		if(bankBranchTransaction.getTransactionType().equalsIgnoreCase("D")) {
//			if(!bankBranchTransactionService.CheckIfFirstRecord(accountNumber)) {
//				//It shouldn't be first reord while subtracting debited amount
//			}
			
			if(bankBranchTransaction.getTransactioAmount() > bankBranchTransaction.getTransactioAmount()) {
				//You cant make a transaction in nagative
				//Throw an exception
				return null;
			}
			else
			bankBranchTransaction.setCurr_bal(balanceToUpdate - bankBranchTransaction.getTransactioAmount());
		}
		else if(bankBranchTransaction.getTransactionType().equalsIgnoreCase("C")) {
			bankBranchTransaction.setCurr_bal(balanceToUpdate + bankBranchTransaction.getTransactioAmount());
		}
		BankBranchTransaction bankBranchTransactionCreate = bankBranchTransactionService.save(bankBranchTransaction);
		
//		empBankDetails call hoga jisme ye bankTransactio save hoga
		
		return new ResponseEntity<>(bankBranchTransactionCreate, HttpStatus.CREATED);
	}
}
