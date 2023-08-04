package com.example.useful.controller;

import java.util.Collections;
import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.SubstringFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.dto.BankBranchTransactionsDto;
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
	public ResponseEntity<?> makeTransaction(@RequestBody BankBranchTransactionsDto bankBranchTransactionDto, @PathVariable String accountNumber){
		
		float curr_balance = empBankDetailsService.findTransactionFromAccountToUpdateBalance(accountNumber);
//		BankBranchTransaction lastBankBranchTransaction = empBankDetailsService.findLastTransaction(accountNumber);
		BankBranchTransaction bankBranchTransaction = new BankBranchTransaction();
		if(bankBranchTransactionDto.getTransactionType().equalsIgnoreCase("Debit")) {
//			if(!bankBranchTransactionService.CheckIfFirstRecord(accountNumber)) {
//				//It shouldn't be first record while subtracting debited amount
//			}
			
//			if(curr_balance < bankBranchTransactionDto.getTransactioAmount()) {
				//You cant make a transaction in nagative
				//Throw an exception
//				return null;
//			}
//			else
				bankBranchTransactionDto.setCurr_bal(curr_balance - bankBranchTransactionDto.getTransactioAmount());
		}
		else if(bankBranchTransactionDto.getTransactionType().equalsIgnoreCase("Credit")) {
			bankBranchTransactionDto.setCurr_bal(curr_balance + bankBranchTransactionDto.getTransactioAmount());
		}
		EmpBankDetails empBankDetails =  empBankDetailsRepository.findByAccountNo(accountNumber);
		bankBranchTransaction.setTransactionDate(bankBranchTransactionDto.getTransactionDate());
		bankBranchTransaction.setTransactioAmount(bankBranchTransactionDto.getTransactioAmount());
		bankBranchTransaction.setCurr_bal(bankBranchTransactionDto.getCurr_bal());
		bankBranchTransaction.setTransactionType(bankBranchTransactionDto.getTransactionType());
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
	
	@GetMapping("/findLastTenTransactions/{accountNumber}")
	public List<BankBranchTransaction>lastTenTransactions(@PathVariable String accountNumber){
		List<BankBranchTransaction> bankBranchTransaction = empBankDetailsService.getAllBankBranchTransactions(accountNumber);
		Collections.sort(bankBranchTransaction);
		
		return bankBranchTransaction.subList(0, bankBranchTransaction.size()<10?bankBranchTransaction.size():10);
//		List<BankBranchTransaction> bankBranchTransactionLastTen = bankBranchTransaction.subList(bankBranchTransaction.size()-10, bankBranchTransaction.size());
//		return (ResponseEntity<?>) bankBranchTransactionLastTen;
	}
	}
			

	
	//last API is find last generic months data with PDF stored file 

