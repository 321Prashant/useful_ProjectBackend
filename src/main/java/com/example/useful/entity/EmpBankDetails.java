package com.example.useful.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeBankDetails")
public class EmpBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeBankDetailsId;
	
	private String accountNo;
	
	private boolean salaryAccount;
	private Date effDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "empBankDetails", referencedColumnName = "bankBranchId")
	private BankBranchDetails bankBranchDetails;
//	
//	@OneToMany(targetEntity=BankBranchTransaction.class, mappedBy="empBankDetails", cascade = CascadeType.ALL)
//	private List<BankBranchTransaction> branchBankTransaction;

//	@ManyToOne
//	@JoinColumn(name="userId")
//	private Users userId;
	
	
	public EmpBankDetails() {
		super();
	}

	

	public EmpBankDetails(String accountNo, boolean salaryAccount, Date effDate, BankBranchDetails bankBranchDetails,
			List<BankBranchTransaction> branchBankTransaction, Users userId) {
		super();
		this.accountNo = accountNo;
		this.salaryAccount = salaryAccount;
		this.effDate = effDate;
		this.bankBranchDetails = bankBranchDetails;
//		this.branchBankTransaction = branchBankTransaction;
//		this.userId = userId;
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

	public BankBranchDetails getBankBranchDetails() {
		return bankBranchDetails;
	}

	public void setBankBranchDetails(BankBranchDetails bankBranchDetails) {
		this.bankBranchDetails = bankBranchDetails;
	}

//	public List<BankBranchTransaction> getBranchBankTransaction() {
//		return branchBankTransaction;
//	}
//
//	public void setBranchBankTransaction(List<BankBranchTransaction> branchBankTransaction) {
//		this.branchBankTransaction = branchBankTransaction;
//	}
	

	public Integer getEmployeeBankDetailsId() {
		return employeeBankDetailsId;
	}



	public void setEmployeeBankDetailsId(Integer employeeBankDetailsId) {
		this.employeeBankDetailsId = employeeBankDetailsId;
	}



//	public Users getUserId() {
//		return userId;
//	}
//
//
//
//	public void setUserId(Users userId) {
//		this.userId = userId;
//	}



	@Override
	public String toString() {
		return "EmpBankDetails [employeeBankDetailsId=" + employeeBankDetailsId + ", accountNo=" + accountNo
				+ ", salaryAccount=" + salaryAccount + ", effDate=" + effDate + ", bankBranchDetails="
				+ bankBranchDetails + ", branchBankTransaction=" +  ", userId=" +  "]";
	}
	
	
	
}
