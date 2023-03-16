package com.example.useful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.entity.Company;
import com.example.useful.service.CompanyService;

@RestController
@RequestMapping("/Company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@PostMapping("/addUserInCompany")
	public ResponseEntity<Company> addUserInCompany( @RequestBody Company company){
		Company userAddedInCompany = companyService.addUserInCompany(company);
		return ResponseEntity.ok(userAddedInCompany);
	}
	
	@GetMapping("/getAllCompanies")
	public ResponseEntity<List<Company>> getAllCompanies(){
		List<Company> companies = companyService.GetCompanies();
		return ResponseEntity.ok(companies);
	}
	
	@DeleteMapping("/deleteCompanyById/{id}")
	public ResponseEntity<String> deleteCompany( @PathVariable Integer id){
		 companyService.deleteCompany(id);
		return ResponseEntity.ok("Deleted company");
	}
	
	@PutMapping("/UpdateCompany/{id}")
	public ResponseEntity<Company> updateCompany( @PathVariable Integer id, @RequestBody Company company){
		 Company companyUpdated = companyService.updateCompany(id, company);
		return ResponseEntity.ok(companyUpdated);
	}
	
	
	
	
}
