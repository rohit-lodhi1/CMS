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

import com.dollop.app.entity.payload.PayrollItemsDeductionsRequest;
import com.dollop.app.entity.payload.PayrollItemsDeductionsResponse;
import com.dollop.app.service.admin.IPayrollItemsDeductionsService;

@RestController
@RequestMapping("/rise/admin/payrollItemsDeductions")
@CrossOrigin("*")

public class PayrollItemsDeductionsController {


	
	@Autowired
	private IPayrollItemsDeductionsService payrollItemsDeductionsService;

    // create payrollItemsDeductions
	@PostMapping("/")
	public ResponseEntity<PayrollItemsDeductionsResponse> createPayrollItemsDeductions(@RequestBody PayrollItemsDeductionsRequest payrollItemsDeductions) {
		return new ResponseEntity<PayrollItemsDeductionsResponse>(this.payrollItemsDeductionsService.addPayrollItemsDeductions(payrollItemsDeductions), HttpStatus.CREATED);
	}

    // update PayrollItemsDeductions
	@PutMapping("/")
	public ResponseEntity<PayrollItemsDeductionsResponse> updatePayrollItemsAdditions(@RequestBody PayrollItemsDeductionsRequest payrollItemsDeductions) {
		PayrollItemsDeductionsResponse updatePayrollItemsDeductions = this.payrollItemsDeductionsService.updatePayrollItemsDeductions(payrollItemsDeductions);
		return ResponseEntity.ok(updatePayrollItemsDeductions);
	}

	//  get payrollItemsDeductions by id
	@GetMapping("/{id}")
	public ResponseEntity<PayrollItemsDeductionsResponse> getSinglePayrollItemsDeductions(@PathVariable Integer id) {
		return ResponseEntity.ok(this.payrollItemsDeductionsService.getPayrollItemsDeductionssById(id));
	}

    // get all payrollItemsAdditions
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PayrollItemsDeductionsResponse>> getAllPayrollItemsDeductions(@PathVariable Integer pageNo, 
																@PathVariable Integer pageSize) {
		Page<PayrollItemsDeductionsResponse> payrollItemsDeductions= this.payrollItemsDeductionsService.getAllPayrollItemsDeductions(pageNo, pageSize);
		return new ResponseEntity<Page<PayrollItemsDeductionsResponse>>(payrollItemsDeductions, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePayrollItemsDeductions(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.payrollItemsDeductionsService.deletePayrollItemsDeductions(id),HttpStatus.ACCEPTED);	
	}


}
