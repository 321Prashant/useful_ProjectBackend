package com.example.useful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.entity.BankBranchDetails;
import com.example.useful.service.BankDetailsService;

@RestController
@RequestMapping("/bankDetials")
public class BankDetailsController {

	@Autowired
	private BankDetailsService bankDetailsService;
	
	@PostMapping("/addBankDetails")
	public ResponseEntity<?> addBankDetails(@RequestBody BankBranchDetails bankDetails){
		BankBranchDetails bankDetailsAdded = bankDetailsService.save(bankDetails);
		return new ResponseEntity<BankBranchDetails>(bankDetailsAdded,HttpStatus.CREATED);
	}
	
	@GetMapping("/getBankDetails")
	public ResponseEntity<?> getBankDetails(){
		List<BankBranchDetails> getAllBankDetails = bankDetailsService.findAll();
		return new ResponseEntity<List<BankBranchDetails>>(getAllBankDetails,HttpStatus.OK);
	}
	
	@GetMapping("/getBankDetailsById/{id}")
	public ResponseEntity<?> getBankDetails(@PathVariable String id){
		BankBranchDetails getAllBankDetails = bankDetailsService.findById(id);
		return new ResponseEntity<BankBranchDetails>(getAllBankDetails,HttpStatus.OK);
	}
}
