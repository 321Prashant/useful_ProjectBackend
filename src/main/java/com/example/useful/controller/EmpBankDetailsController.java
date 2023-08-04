package com.example.useful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.dto.EmpBankDetailsDto;
import com.example.useful.entity.EmpBankDetails;
import com.example.useful.service.EmpBankDetailsService;

@RestController
@RequestMapping("/empBankDetails")
public class EmpBankDetailsController {

	@Autowired
	private EmpBankDetailsService empBankDetailsService;
	@PostMapping("/addEmpBankDetails")
	public ResponseEntity<?> addEmpBankDetails(@RequestBody EmpBankDetailsDto empBankDetailsDto){
		 EmpBankDetails empBankDetailsSaved =  empBankDetailsService.save(empBankDetailsDto);
		 return new ResponseEntity<EmpBankDetails>(empBankDetailsSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmpBankDetails")
	public ResponseEntity<?> getEmpBankDetails(){
		 List<EmpBankDetails> empBankDetailsSaved =  empBankDetailsService.get();
		 return new ResponseEntity<List<EmpBankDetails>>(empBankDetailsSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmpBankDetailsById/{id}")
	public ResponseEntity<?> getEmpBankDetailsById(@PathVariable Long id){
		 EmpBankDetails empBankDetailsSaved =  empBankDetailsService.getById(id);
		 return new ResponseEntity<EmpBankDetails>(empBankDetailsSaved,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmpBankDetails/{id}")
	public ResponseEntity<?> updateEmpBankDetails(@RequestBody EmpBankDetails empBankDetails, @PathVariable Long id){
		EmpBankDetails empBankDetailsUpdated =  empBankDetailsService.updateEmpBankDetails(empBankDetails ,id);
		 return new ResponseEntity<EmpBankDetails>(empBankDetailsUpdated,HttpStatus.CREATED);
			 
	}
}
