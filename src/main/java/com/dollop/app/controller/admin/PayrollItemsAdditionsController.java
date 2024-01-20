package com.dollop.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.dollop.app.entity.payload.PayrollItemsAdditionsRequest;
import com.dollop.app.entity.payload.PayrollItemsAdditionsResponse;
import com.dollop.app.service.admin.IPayrollItemsAdditionsService;

@RestController
@RequestMapping("/rise/admin/payrollItemsAdditions")
@CrossOrigin("*")

public class PayrollItemsAdditionsController {
	
	
	
	@Autowired
	private IPayrollItemsAdditionsService payrollItemsAdditionsService;

    // create payrollItemsAdditions
	@PostMapping("/")
	public ResponseEntity<PayrollItemsAdditionsResponse> createPayrollItemsAdditions(@RequestBody PayrollItemsAdditionsRequest payrollItemsAdditions) {
			return new ResponseEntity<PayrollItemsAdditionsResponse>(this.payrollItemsAdditionsService.addPayrollItemsAdditions(payrollItemsAdditions), HttpStatus.CREATED);
	}

    // update PayrollItemsAdditions
	@PutMapping("/")
	public ResponseEntity<PayrollItemsAdditionsResponse> updatePayrollItemsAdditions(@RequestBody PayrollItemsAdditionsRequest payrollItemsAdditions) {
		PayrollItemsAdditionsResponse updatePayrollItemsAdditions = this.payrollItemsAdditionsService.updatePayrollItemsAdditions(payrollItemsAdditions);
		return ResponseEntity.ok(updatePayrollItemsAdditions);
	}

	//  get payrollItemsAdditions by id
	@GetMapping("/{id}")
	public ResponseEntity<PayrollItemsAdditionsResponse> getSinglePayrollItemsAdditions(@PathVariable Integer id) {
		return ResponseEntity.ok(this.payrollItemsAdditionsService.getPayrollItemsAdditionsById(id));
	}

    // get all payrollItemsAdditions
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PayrollItemsAdditionsResponse>> getAllPayrollItemsAdditions(@PathVariable Integer pageNo, 
																@PathVariable Integer pageSize) {
		Page<PayrollItemsAdditionsResponse> payrollItemsAdditions = this.payrollItemsAdditionsService.getAllPayrollItemsAdditions(pageNo, pageSize);
		return new ResponseEntity<Page<PayrollItemsAdditionsResponse>>(payrollItemsAdditions, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePayrollItemsAdditions(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.payrollItemsAdditionsService.deletePayrollItemsAdditions(id),HttpStatus.ACCEPTED);	
	}



}
