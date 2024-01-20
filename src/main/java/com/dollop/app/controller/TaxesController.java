package com.dollop.app.controller;

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

import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.TaxesRequest;
import com.dollop.app.entity.payload.TaxesResponse;
import com.dollop.app.entity.payload.TrainerRequest;
import com.dollop.app.entity.payload.TrainerResponse;
import com.dollop.app.service.ITaxesService;
import com.dollop.app.service.admin.ITrainersService;

@RestController
@RequestMapping("/rise/taxes")
@CrossOrigin("*")

public class TaxesController {
	
	
	@Autowired
	private ITaxesService taxesService;

    // create taxes
	@PostMapping("/")
	public ResponseEntity<TaxesResponse> createTaxes (@RequestBody TaxesRequest taxes) {
		return new ResponseEntity<TaxesResponse>(this.taxesService.addTaxes(taxes), HttpStatus.CREATED);
	}

    // update taxes
	@PutMapping("/")
	public ResponseEntity<TaxesResponse> updateTaxes(@RequestBody TaxesRequest taxes) {
		TaxesResponse updatetaxes = this.taxesService.updateTaxes(taxes);
		return ResponseEntity.ok(updatetaxes);
	}

	//  get taxes by id
	@GetMapping("/{id}")
	public ResponseEntity<TaxesResponse> getSingleTaxes(@PathVariable Integer id) {
		return ResponseEntity.ok(this.taxesService.getTaxesById(id));
	}

    // get all taxes
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TaxesResponse>> getAllTaxes(@PathVariable Integer pageNo, 
																@PathVariable Integer pageSize) {
		Page<TaxesResponse> taxes = this.taxesService.getAllTaxes(pageNo, pageSize);
		return new ResponseEntity<Page<TaxesResponse>>(taxes, HttpStatus.OK);
	}

	// get by status taxes
	@GetMapping("/status/{pageNo}/{pageSize}/{status}")
	public ResponseEntity<Page<TaxesResponse>> getAllTaxesByStatus(@PathVariable("pageNo") Integer pageNo,
																		@PathVariable("pageSize") Integer pageSize,
																		@PathVariable("id") String status) {
		Page<TaxesResponse> leaves = this.taxesService.getTaxesByStatus(pageNo, pageSize, status);
		ResponseEntity<Page<TaxesResponse>> response = new ResponseEntity<Page<TaxesResponse>>(leaves, HttpStatus.OK);
		return response;
	}
	
	// delete taxes by id
		@DeleteMapping("/{id}")
		public ResponseEntity<Boolean> deleteTaxes(@PathVariable Integer id) {
			return new ResponseEntity<Boolean>(this.taxesService.deleteTaxes(id), HttpStatus.ACCEPTED);
		}
		// update taxes status by id
		@GetMapping("/status/{status}/{id}")
		public ResponseEntity<TaxesResponse> updateTaxesStatus(@PathVariable Integer id,
				                                                        @PathVariable String status) {
			TaxesResponse updateGoalList = this.taxesService.updateTaxesStatus(id, status);
			return new ResponseEntity<TaxesResponse>(updateGoalList, HttpStatus.OK);
		}

}
