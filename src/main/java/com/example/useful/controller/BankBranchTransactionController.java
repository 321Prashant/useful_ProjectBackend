package com.example.useful.controller;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.entity.BankBranchTransaction;
import com.example.useful.entity.EmpBankDetails;
import com.example.useful.repository.EmpBankDetailsRepository;
import com.example.useful.service.BankBranchTransactionService;
import com.example.useful.service.EmpBankDetailsService;

@RestController
@RequestMapping("/bankTransaction")
public class BankBranchTransactionController {

	@Autowired
	private BankBranchTransactionService bankBranchTransactionService;
	@Autowired
	private EmpBankDetailsService empBankDetailsService;
	@Autowired
	private EmpBankDetailsRepository empBankDetailsRepository;
	
	@PostMapping("/makeTransaction/{accountNumber}")
	public ResponseEntity<?> makeTransaction(@RequestBody BankBranchTransaction bankBranchTransaction, @PathVariable String accountNumber){
		
		float curr_balance = empBankDetailsService.findTransactionFromAccountToUpdateBalance(accountNumber);
//		BankBranchTransaction lastBankBranchTransaction = empBankDetailsService.findLastTransaction(accountNumber);
		
		if(bankBranchTransaction.getTransactionType().equalsIgnoreCase("Debit")) {
//			if(!bankBranchTransactionService.CheckIfFirstRecord(accountNumber)) {
//				//It shouldn't be first record while subtracting debited amount
//			}
			
			if(curr_balance > bankBranchTransaction.getTransactioAmount()) {
				//You cant make a transaction in nagative
				//Throw an exception
				return null;
			}
			else
			bankBranchTransaction.setCurr_bal(curr_balance - bankBranchTransaction.getTransactioAmount());
		}
		else if(bankBranchTransaction.getTransactionType().equalsIgnoreCase("Credit")) {
			bankBranchTransaction.setCurr_bal(curr_balance + bankBranchTransaction.getTransactioAmount());
		}
		EmpBankDetails empBankDetails =  empBankDetailsRepository.findByAccountNo(accountNumber);
		bankBranchTransaction.setEmpBankDetails(empBankDetails);
		BankBranchTransaction bankBranchTransactionCreate = bankBranchTransactionService.save(bankBranchTransaction);
		
//		empBankDetails call hoga jisme ye bankTransaction save hoga
		
		return new ResponseEntity<>(bankBranchTransactionCreate, HttpStatus.CREATED);
	}
	
	@GetMapping("/findCurrentBal/{accountNumber}")
	public ResponseEntity<?> lastBalance(@PathVariable String accountNumber){
		float curr_balance = empBankDetailsService.findTransactionFromAccountToUpdateBalance(accountNumber);

		return new ResponseEntity<>(curr_balance,HttpStatus.FOUND);
	}
	
	//last API is find last generic months data with PDF stored file 
}
