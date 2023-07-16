package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.entity.BankBranchTransaction;
import com.example.useful.entity.EmpBankDetails;
import com.example.useful.repository.EmpBankDetailsRepository;

@Service
public class EmpBankDetailsService {

	@Autowired
	private EmpBankDetailsRepository empBankDetailsRepository;
	
	public List<EmpBankDetails> get() {
		
		return empBankDetailsRepository.findAll();
	}

	public EmpBankDetails getById(Integer id) {
		
		return empBankDetailsRepository.findById(id).get();
	}

	public EmpBankDetails updateEmpBankDetails(EmpBankDetails empBankDetails, Integer id) {
		
		EmpBankDetails empBankDetailsToUpdated = empBankDetailsRepository.findById(id).get();
		empBankDetailsToUpdated.setBankBranchDetails(empBankDetails.getBankBranchDetails());
		return empBankDetailsRepository.save(empBankDetailsToUpdated);
	}

	public EmpBankDetails save(EmpBankDetails empBankDetails) {
		
		return empBankDetailsRepository.save(empBankDetails);
	}

	public float findTransactionFromAccountToUpdateBalance(String accountNumber) {
		EmpBankDetails empBankDetails =  empBankDetailsRepository.findByAccountNo(accountNumber);
//		for (BankBranchTransaction empBankTransaction : empBankDetails.getBranchBankTransaction()) {
//			return empBankTransaction.getCurr_bal();
//		
//	 }
		return 0.0f;
	}


}
