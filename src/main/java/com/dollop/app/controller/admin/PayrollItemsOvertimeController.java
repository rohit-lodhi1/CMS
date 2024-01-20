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

import com.dollop.app.entity.payload.PayrollItemsOvertimeRequest;
import com.dollop.app.entity.payload.PayrollItemsOvertimeResponse;
import com.dollop.app.service.admin.IPayrollItemsOvertimeService;

@RestController
@RequestMapping("/rise/admin/PayrollItemsOvertime")
@CrossOrigin("*")

public class PayrollItemsOvertimeController {
	


	
	@Autowired
	private IPayrollItemsOvertimeService payrollItemsOvertimeService;

    // create payrollItemsOvertime
	@PostMapping("/")
	public ResponseEntity<PayrollItemsOvertimeResponse> createPayrollItemsOvertime(@RequestBody PayrollItemsOvertimeRequest payrollItemsOvertime) {
		System.out.println(payrollItemsOvertime);
		return new ResponseEntity<PayrollItemsOvertimeResponse>(this.payrollItemsOvertimeService.addPayrollItemsOvertime(payrollItemsOvertime), HttpStatus.CREATED);
	}

    // update PayrollItemsOvertime
	@PutMapping("/")
	public ResponseEntity<PayrollItemsOvertimeResponse> updatePayrollItemsOvertime(@RequestBody PayrollItemsOvertimeRequest payrollItemsOvertime) {
		PayrollItemsOvertimeResponse updatePayrollItemsOvertime = this.payrollItemsOvertimeService.updatePayrollItemsOvertime(payrollItemsOvertime);
		return ResponseEntity.ok(updatePayrollItemsOvertime);
	}

	//  get payrollItemsDeductions by id
	@GetMapping("/{id}")
	public ResponseEntity<PayrollItemsOvertimeResponse> getSinglePayrollItemsOvertime(@PathVariable Integer id) {
		return ResponseEntity.ok(this.payrollItemsOvertimeService.getPayrollItemsOvertimeById(id));
	}

    // get all payrollItemsOvertime
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PayrollItemsOvertimeResponse>> getAllPayrollItemsDeductions(@PathVariable Integer pageNo, 
																@PathVariable Integer pageSize) {
		Page<PayrollItemsOvertimeResponse> payrollItemsOvertime= this.payrollItemsOvertimeService.getAllPayrollItemsOvertime(pageNo, pageSize);
		return new ResponseEntity<Page<PayrollItemsOvertimeResponse>>(payrollItemsOvertime, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePayrollItemsOvertime(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.payrollItemsOvertimeService.deletePayrollItemsOvertime(id),HttpStatus.ACCEPTED);	
	}


}
