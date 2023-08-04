package com.example.useful.dto;

import javax.persistence.OneToOne;

import com.example.useful.entity.EmpBankDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class BankBranchDetailsDto {

	private Long bankBranchId;
	
	private String country;
	private String city;
	private Integer empBankDetailsId;
	public Long getBankBranchId() {
		return bankBranchId;
	}
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getEmpBankDetailsId() {
		return empBankDetailsId;
	}
	public void setEmpBankDetailsId(Integer empBankDetailsId) {
		this.empBankDetailsId = empBankDetailsId;
	}
	
}
