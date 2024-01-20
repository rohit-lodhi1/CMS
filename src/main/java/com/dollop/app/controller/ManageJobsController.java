
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
import com.dollop.app.entity.payload.ManageJobsRequest;
import com.dollop.app.entity.payload.ManageJobsResponse;
import com.dollop.app.entity.payload.TicketsResponse;
import com.dollop.app.service.IManageJobsService;

@RestController
@RequestMapping("/rise/administration/manageJobs")
@CrossOrigin("*")

public class ManageJobsController {

	@Autowired
	private IManageJobsService manageJobsService;

	// add goal manageJobs
	@PostMapping("/")
	public ResponseEntity<ManageJobsResponse> createManageJobsResponse(
			@RequestBody ManageJobsRequest manageJobsRequest) {
		return new ResponseEntity<ManageJobsResponse>(this.manageJobsService.addManageJobs(manageJobsRequest),
				HttpStatus.CREATED);
	}

	// update manageJobs
	@PutMapping("/")
	public ResponseEntity<ManageJobsResponse> updateManageJobsResponse(
			@RequestBody ManageJobsRequest manageJobsRequest) {
		ManageJobsResponse update = this.manageJobsService.updateManageJobs(manageJobsRequest);
		return ResponseEntity.ok(update);
	}

	// get all manageJobs
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ManageJobsResponse>> getAllManageJobs(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<ManageJobsResponse>>(this.manageJobsService.getAllManageJobs(pageNo, pageSize),
				HttpStatus.OK);
	}

	// get manageJobs
	@GetMapping("/{id}")
	public ResponseEntity<ManageJobsResponse> getManageJobsById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.manageJobsService.getManageJobsById(id));
	}

	// filter manageJobs
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ManageJobsResponse>> searchManageJobs(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @RequestBody ManageJobsRequest manageJobsRequest) {

		Page<ManageJobsResponse> manageJobs = this.manageJobsService.searchManageJobs(pageNo, pageSize,
				manageJobsRequest);
		return new ResponseEntity<Page<ManageJobsResponse>>(manageJobs, HttpStatus.OK);
	}



	// update update status by id
	 	@GetMapping("/status/{status}/{id}/{oftype}")
	 	public ResponseEntity<ManageJobsResponse> updateOverTimeStatus(@PathVariable Integer id,
	 			                                                        @PathVariable String status,@PathVariable String oftype) {
	 		ManageJobsResponse updateStatus = this.manageJobsService.updateManageJobsStatus(id, status,oftype);
	 		return new ResponseEntity<ManageJobsResponse>(updateStatus, HttpStatus.OK);
	 	}
	 
	
	
	// delete manageJobs by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteManageJobs(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.manageJobsService.deleteManageJobs(id), HttpStatus.ACCEPTED);
	}

	// update manageJobs status by id
	@GetMapping("/type/{type}/{id}")
	public ResponseEntity<ManageJobsResponse> updateManageJobs(@PathVariable Integer id, @PathVariable String type) {
		ManageJobsResponse ManageJobs = this.manageJobsService.updateManageJobType(id, type);
		return new ResponseEntity<ManageJobsResponse>(ManageJobs, HttpStatus.OK);
	}
	
	// update manageJobs views by id
		@GetMapping("/jobViews/{id}")
		public ResponseEntity<?> updateManageJobsViews(@PathVariable Integer id) {
			 
			return this.manageJobsService.updateManageJobViews(id);
		}
		
		

}
