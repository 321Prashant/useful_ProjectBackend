package com.example.useful.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="BankBranchTransaction")
public class BankBranchTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankTransactionId;
	private Date  transactionDate;
	private Integer transactioAmount;
	private String transactionType;
	
	private float curr_bal;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="empBankDetailsId")
	private EmpBankDetails empBankDetails;
	
//	{
        
//        "transactionDate": "2023-07-15T00:00:00.000+00:00",
//        "transactioAmount": 2000,
//        "transactionType": "Credit",
//        "curr_bal": 7000.0,
//        "empBankDetails":
//			{
//			"employeeBankDetailsId": 1,
//			"accountNo": "22898079702",
//			"salaryAccount": false,
//			"effDate": "2023-07-16T00:00:00.000+00:00",
//				"bankBranchDetails": {
//  				  "bankBranchId": 1,
//  				  "country": "india",
//   				  "city": "bangalore"
//				}
//			}}
//
//}		needs to be checked with banknranchdetails everytime a new object will be created if you do not pass id, DTO required
//		if passing id it creates an issue again some other id is stored and 2 times data stored

	public BankBranchTransaction() {
		super();
	}

	public BankBranchTransaction(Date transactionDate, Integer transactioAmount, String transactionType, float curr_bal,
			EmpBankDetails empBankDetails) {
		super();
		this.transactionDate = transactionDate;
		this.transactioAmount = transactioAmount;
		this.transactionType = transactionType;
		this.curr_bal = curr_bal;
		this.empBankDetails = empBankDetails;
	}

	@Override
	public String toString() {
		return "BankBranchTransaction [bankTransactionId=" + bankTransactionId + ", transactionDate=" + transactionDate
				+ ", transactioAmount=" + transactioAmount + ", transactionType=" + transactionType + ", curr_bal="
				+ curr_bal + ", empBankDetails=" +"]";
	}

	public Long getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(Long bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTransactioAmount() {
		return transactioAmount;
	}

	public void setTransactioAmount(Integer transactioAmount) {
		this.transactioAmount = transactioAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public float getCurr_bal() {
		return curr_bal;
	}

	public void setCurr_bal(float curr_bal) {
		this.curr_bal = curr_bal;
	}

	public EmpBankDetails getEmpBankDetails() {
		return empBankDetails;
	}

	public void setEmpBankDetails(EmpBankDetails empBankDetails) {
		this.empBankDetails = empBankDetails;
	}
	
	
	
	
}
