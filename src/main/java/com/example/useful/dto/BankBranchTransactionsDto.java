package com.example.useful.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.useful.entity.EmpBankDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class BankBranchTransactionsDto {

	private Long bankTransactionId;
	private Date  transactionDate;
	private Integer transactioAmount;
	private String transactionType;
	
	private float curr_bal;
	private Integer empBankDetailsId;
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
	public Integer getEmpBankDetailsId() {
		return empBankDetailsId;
	}
	public void setEmpBankDetailsId(Integer empBankDetailsId) {
		this.empBankDetailsId = empBankDetailsId;
	}
	
	
}
