package com.example.useful.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankBranchDetails")
public class BankBranchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String bankBranchId;
	
	private String country;
	private String city;
	
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
	public String getBankBranchId() {
		return bankBranchId;
	}
	public void setBankBranchId(String bankBranchId) {
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
