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

import com.dollop.app.entity.payload.EstimatesRequest;
import com.dollop.app.entity.payload.EstimatesResponse;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.InvoicesResponse;
import com.dollop.app.service.admin.IEstimatesService;
import com.dollop.app.service.admin.IInvoicesService;

@RestController
@RequestMapping("/rise/admin/hr/estimate")
@CrossOrigin("*")

public class EstimatesController {

	
	@Autowired
	private IEstimatesService estimatesService;

	// add Estimates
	@PostMapping("/")
	public ResponseEntity<EstimatesResponse> createEstimates(@RequestBody  EstimatesRequest estimatesRequest) {
		return new ResponseEntity<EstimatesResponse>(this.estimatesService.addEstimates(estimatesRequest), HttpStatus.CREATED);
	}
	
	// update Estimates
	@PutMapping("/")
	public ResponseEntity<EstimatesResponse> updateEstimates(@RequestBody EstimatesRequest estimatesRequest){
		EstimatesResponse updateinvoices = this.estimatesService.updateEstimates(estimatesRequest);
	return ResponseEntity.ok(updateinvoices);
	}
	
	
	
	// get all Estimates
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<EstimatesResponse>> getAllEstimates(@PathVariable("pageNo") Integer pageNo,
                                                   @PathVariable("pageSize") Integer pageSize){
		return new ResponseEntity<Page<EstimatesResponse>>(this.estimatesService.getAllEstimates(pageNo,pageSize),HttpStatus.OK);
	}
	// get Estimates
		@GetMapping("/{estimatesId}")
		public ResponseEntity<EstimatesResponse> getEstimatesById(@PathVariable Integer estimatesId) {
			return ResponseEntity.ok(this.estimatesService.getEstimatesById(estimatesId));
		}


	// filter searching 
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<EstimatesResponse>> searchEstimates(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody EstimatesRequest estimatesRequest){
		
		Page<EstimatesResponse> invoices = this.estimatesService.searchEstimates(pageNo, pageSize, estimatesRequest);
		return new ResponseEntity<Page<EstimatesResponse>>(invoices,HttpStatus.OK);
	}
	
	// delete Estimates by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteEstimates(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.estimatesService.deleteEstimates(id),HttpStatus.ACCEPTED);	
	}

	
}
