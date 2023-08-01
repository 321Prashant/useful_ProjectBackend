package com.example.useful.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="EmployeeBankDetails")
public class EmpBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeBankDetailsId;
	
	private String accountNo;
	
	private boolean salaryAccount;
	private Date effDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bankBranchId")
	private BankBranchDetails bankBranchDetails;
	
	@OneToMany(mappedBy="empBankDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<BankBranchTransaction> branchBankTransaction;

//	@ManyToOne
//	@JsonBackReference // for not getting output 
//	@JoinColumn(name="userId")
//	private Users userId;
	
//	{
//		 
//		  "accountNo": "22898079702",
//		  "salaryAccount": true,
//		  "effDate": "2023-07-16",
//        "bankBranchDetails":
//        {
//          
//          "country":"india",
//          "city":"pune"
//        },
//		  "branchBankTransaction": [
//		    {
//           
//		      "transactionDate": "2023-07-23",
//		      "transactioAmount": 3000,
//		      "transactionType": "Credit",
//		      "curr_bal": 8000
//		    },
//          {
//           
//		      "transactionDate": "2023-06-12",
//		      "transactioAmount": 8000,
//		      "transactionType": "Debit",
//		      "curr_bal": 16000
//		    }
//		  ]
//		}
	
//	needs to be checked with bankbranchtransaction object and bankDetails object everytime a new object will be created if you do not pass id, DTO required
//  on passing id it didn't check either
	
	public EmpBankDetails() {
		super();
	}

	

	public EmpBankDetails(String accountNo, boolean salaryAccount, Date effDate, BankBranchDetails bankBranchDetails,
			List<BankBranchTransaction> branchBankTransaction) {
		super();
		this.accountNo = accountNo;
		this.salaryAccount = salaryAccount;
		this.effDate = effDate;
		this.bankBranchDetails = bankBranchDetails;
		this.branchBankTransaction = branchBankTransaction;
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

	public List<BankBranchTransaction> getBranchBankTransaction() {
		return branchBankTransaction;
	}

	public void setBranchBankTransaction(List<BankBranchTransaction> branchBankTransaction) {
		this.branchBankTransaction = branchBankTransaction;
	}
	

	public Long getEmployeeBankDetailsId() {
		return employeeBankDetailsId;
	}



	public void setEmployeeBankDetailsId(Long employeeBankDetailsId) {
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
