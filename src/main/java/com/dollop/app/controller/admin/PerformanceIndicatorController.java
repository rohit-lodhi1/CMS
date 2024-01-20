
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

import com.dollop.app.entity.PerformanceIndicator;
import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.PerformanceIndicatorRequest;

import com.dollop.app.entity.payload.PerformanceIndicatorResponse;
import com.dollop.app.service.admin.PerformanceIndicatorService;

@RestController
@RequestMapping("/rise/admin/performanceIndicator")
@CrossOrigin("*")
public class PerformanceIndicatorController {

	@Autowired
	private PerformanceIndicatorService performanceIndicatorService;

	// create performanceIndicator
	@PostMapping("/add")
	public ResponseEntity<PerformanceIndicatorResponse> createPerformanceIndicator(
			@RequestBody PerformanceIndicatorRequest perIndicatorRequest) {
		ResponseEntity<PerformanceIndicatorResponse> response = new ResponseEntity<PerformanceIndicatorResponse>(
				this.performanceIndicatorService.createPerformanceIndicator(perIndicatorRequest), HttpStatus.CREATED);
		return response;

	}

	// updateperformanceIndicator
	@PutMapping("/update")
	public ResponseEntity<PerformanceIndicatorResponse> updatePerformanceIndicator(
			@RequestBody PerformanceIndicatorRequest perIndicatorRequest) {
		PerformanceIndicatorResponse perIndicator = this.performanceIndicatorService
				.updatePerformanceIndicator(perIndicatorRequest);
		ResponseEntity<PerformanceIndicatorResponse> response = new ResponseEntity<PerformanceIndicatorResponse>(
				perIndicator, HttpStatus.CREATED);
		return response;

	}

	// getallperformamceIndicator
	@GetMapping("/{pagNo}/{pageSize}")
	public ResponseEntity<Page<PerformanceIndicatorResponse>> getallPerformanceIndicator(@PathVariable Integer pagNo,
			@PathVariable Integer pageSize) {
		Page<PerformanceIndicatorResponse> perPage = this.performanceIndicatorService.getallPerformanceIndicator(pagNo,
				pageSize);
		return new ResponseEntity<Page<PerformanceIndicatorResponse>>(perPage, HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<PerformanceIndicatorResponse> getallPerformanceIndicatorById(@PathVariable Integer id) {
			PerformanceIndicatorResponse perPage = this.performanceIndicatorService.getaPerformanceIndicatorById(id);
		return new ResponseEntity<PerformanceIndicatorResponse>(perPage, HttpStatus.OK);

	}
	// deleteperformanceindicator
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePerformanceindicator(@PathVariable Integer id) {

		this.performanceIndicatorService.deletePerformanceIndicator(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}
	
	// filter PerformanceIndicator
		@PostMapping("/search/{pageNo}/{pageSize}")
		public ResponseEntity<Page<PerformanceIndicatorResponse>> searchPerformanceIndicator(@PathVariable Integer pageNo,
				                                                   @PathVariable Integer pageSize, 
				                                                    @RequestBody PerformanceIndicatorRequest performanceIndicatorRequest) {

			
			Page<PerformanceIndicatorResponse> assets = this.performanceIndicatorService.searchPerformanceIndicator(pageNo, pageSize, performanceIndicatorRequest);
			return new ResponseEntity<Page<PerformanceIndicatorResponse>>(assets, HttpStatus.OK);
		}
		
		
		// update PerformanceIndicator status by id
		@GetMapping("/status/{status}/{id}")
		public ResponseEntity<PerformanceIndicatorResponse> updatePerformanceIndicatorStatus(@PathVariable Integer id,
				                                                        @PathVariable String status) {
		
			return new ResponseEntity<PerformanceIndicatorResponse>( this.performanceIndicatorService.getPerformanceIndicatorByStatus(id, status), HttpStatus.OK);
		}
		
}
