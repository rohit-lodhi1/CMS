package com.dollop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.BankInformationRequest;
import com.dollop.app.entity.payload.BankInformationResponse;
import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;
import com.dollop.app.service.IBankInformationService;

@RestController
@RequestMapping("/rise/bankInformation")
@CrossOrigin("*")

public class BankInformationController {
	

	@Autowired
	private IBankInformationService bankInformationService;

	
	// add bankInformation
	@PostMapping("/{userId}")
	public ResponseEntity<BankInformationResponse> createBankInformation(@RequestBody  BankInformationRequest bankInformationRequest
			, @PathVariable Integer userId) {
		return new ResponseEntity<BankInformationResponse>(this.bankInformationService.addBankInformation(bankInformationRequest,userId),

				HttpStatus.CREATED);
	}

	
	
	// update bankInformation
	@PutMapping("/")
	public ResponseEntity<BankInformationResponse> updateBankInformation(@RequestBody BankInformationRequest bankInformationRequest) {
		BankInformationResponse familyInform = this.bankInformationService.updateBankInformation(bankInformationRequest);
		return ResponseEntity.ok(familyInform);
	}

	

	// get bankInformation
	@GetMapping("/{bankInformationId}")
	public ResponseEntity<BankInformationResponse> getBankInformationById(@PathVariable Integer bankInformationId) {
		return ResponseEntity.ok(this.bankInformationService.getBankInformationById(bankInformationId));
	}
	
	
	
	
	
	 // delete bankInformation by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBankInformation(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.bankInformationService.deleteBankInformation(id),HttpStatus.ACCEPTED);	
	}


}
