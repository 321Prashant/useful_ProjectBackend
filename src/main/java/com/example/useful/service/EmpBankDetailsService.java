package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.dto.EmpBankDetailsDto;
import com.example.useful.entity.BankBranchDetails;
import com.example.useful.entity.BankBranchTransaction;
import com.example.useful.entity.EmpBankDetails;
import com.example.useful.repository.BankBranchTransactionRepository;
import com.example.useful.repository.BankDetailsRepository;
import com.example.useful.repository.EmpBankDetailsRepository;

@Service
public class EmpBankDetailsService {

	@Autowired
	private EmpBankDetailsRepository empBankDetailsRepository;
	@Autowired
	private BankBranchTransactionRepository bankBranchTransactionRepository;
	@Autowired
	private BankDetailsRepository bankBranchDetailsRepository;
	
	public List<EmpBankDetails> get() {
		
		return empBankDetailsRepository.findAll();
	}

	public EmpBankDetails getById(Long id) {
		
		return empBankDetailsRepository.findById(id).get();
	}

	public EmpBankDetails updateEmpBankDetails(EmpBankDetails empBankDetails, Long id) {
		
		EmpBankDetails empBankDetailsToUpdated = empBankDetailsRepository.findById(id).get();
		empBankDetailsToUpdated.setBankBranchDetails(empBankDetails.getBankBranchDetails());
		return empBankDetailsRepository.save(empBankDetailsToUpdated);
	}

	public EmpBankDetails save(EmpBankDetailsDto empBankDetailsDto) {
		EmpBankDetails empBankDetails = new EmpBankDetails();
		BankBranchDetails bankBranchDetails = bankBranchDetailsRepository.findById(empBankDetailsDto.getBankBranchDetailsId()).get();
//		bankBranchDetails.setEmpBankDetails(empBankDetails);
		empBankDetails.setAccountNo(empBankDetailsDto.getAccountNo());
		empBankDetails.setSalaryAccount(empBankDetailsDto.isSalaryAccount());
		empBankDetails.setEffDate(empBankDetailsDto.getEffDate());
		
		empBankDetails.setBankBranchDetails(bankBranchDetails);
	
//		empBankDetails.setBranchBankTransaction(null);
//		List<BankBranchTransaction> bankBranchTransactionList  = empBankDetails.getBranchBankTransaction();
//		for(BankBranchTransaction bankTransaction:bankBranchTransactionList){
//			bankTransaction.setEmpBankDetails(empBankDetails);
//		}
		return empBankDetailsRepository.save(empBankDetails);
	}

	public float findTransactionFromAccountToUpdateBalance(String accountNumber) {
		
		EmpBankDetails empBankDetails =  empBankDetailsRepository.findByAccountNo(accountNumber);
		Long idFetched =  empBankDetails.getEmployeeBankDetailsId();
		List<BankBranchTransaction> transaction =   bankBranchTransactionRepository.getByEmpBankDetails(idFetched);
		System.out.println(transaction);
		BankBranchTransaction lastBankBranchTransaction = transaction.get(transaction.size() - 1);
		return lastBankBranchTransaction.getCurr_bal();
	}

	public BankBranchTransaction findLastTransaction(String accountNumber) {
		
		EmpBankDetails empBankDetails =  empBankDetailsRepository.findByAccountNo(accountNumber);
		Long idFetched =  empBankDetails.getEmployeeBankDetailsId();
		List<BankBranchTransaction> transaction =   bankBranchTransactionRepository.getByEmpBankDetails(idFetched);
		BankBranchTransaction lastBankBranchTransaction = transaction.get(transaction.size() - 1);
		return lastBankBranchTransaction;
	}
	
	public List<BankBranchTransaction> getAllBankBranchTransactions(String accountNumber){
		EmpBankDetails empBankDetails =  empBankDetailsRepository.findByAccountNo(accountNumber);
		Long idFetched =  empBankDetails.getEmployeeBankDetailsId();
		List<BankBranchTransaction> transaction =   bankBranchTransactionRepository.getByEmpBankDetails(idFetched);
		return transaction;
	}

}
