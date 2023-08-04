package com.example.useful.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.useful.entity.BankBranchDetails;
import com.example.useful.entity.BankBranchTransaction;

public class EmpBankDetailsDto {

	private Long employeeBankDetailsId;
	
	private String accountNo;
	
	private boolean salaryAccount;
	private Date effDate;
	
	private Long bankBranchDetailsId;
	
	private Integer branchBankTransactionId;

	public Long getEmployeeBankDetailsId() {
		return employeeBankDetailsId;
	}

	public void setEmployeeBankDetailsId(Long employeeBankDetailsId) {
		this.employeeBankDetailsId = employeeBankDetailsId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public boolean isSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Long getBankBranchDetailsId() {
		return bankBranchDetailsId;
	}

	public void setBankBranchDetailsId(Long bankBranchDetailsId) {
		this.bankBranchDetailsId = bankBranchDetailsId;
	}

	public Integer getBranchBankTransactionId() {
		return branchBankTransactionId;
	}

	public void setBranchBankTransactionId(Integer branchBankTransactionId) {
		this.branchBankTransactionId = branchBankTransactionId;
	}
	
	
}
