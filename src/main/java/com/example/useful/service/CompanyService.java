package com.example.useful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.entity.Company;
import com.example.useful.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	
	public Company addUserInCompany(Company company) {
		return companyRepository.save(company);
	}
	
	public List<Company> GetCompanies() {
		return companyRepository.findAll();
		
	}
	
	
	
	
	public void deleteCompany(Integer id) {
		
//		Company company = companyRepository.findById(id).get();
		 companyRepository.deleteCompanyId(id);
//		 return "deleted company";
	}

	public Company updateCompany(Integer id, Company company) {
		Company companyUpdated = companyRepository.findById(id).get();
		companyUpdated.setCompanyName(company.getCompanyName());
		companyRepository.save(companyUpdated);
		return companyUpdated;
	}
	
}
