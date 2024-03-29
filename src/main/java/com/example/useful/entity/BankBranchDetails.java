package com.example.useful.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="bankBranchDetails")
public class BankBranchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankBranchId;
	
	private String country;
	private String city;
	
	@JsonBackReference
	@OneToOne(mappedBy = "bankBranchDetails")
	  private EmpBankDetails empBankDetails;
	
	
	
	public BankBranchDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankBranchDetails(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}
	public Long getBankBranchId() {
		return bankBranchId;
	}
	
	public EmpBankDetails getEmpBankDetails() {
		return empBankDetails;
	}
	public void setEmpBankDetails(EmpBankDetails empBankDetails) {
		this.empBankDetails = empBankDetails;
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
	@Override
	public String toString() {
		return "BankBranchDetails [bankBranchId=" + bankBranchId + ", country=" + country + ", city=" + city + "]";
	}
	
	
	
}
