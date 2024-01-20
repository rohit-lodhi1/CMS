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

import com.dollop.app.entity.payload.ResignationRequest;
import com.dollop.app.entity.payload.ResignationResponse;
import com.dollop.app.entity.payload.TerminationRequest;
import com.dollop.app.entity.payload.TerminationResponse;
import com.dollop.app.service.IResignationService;
import com.dollop.app.service.ITerminationService;

@RestController
@RequestMapping("/rise/admin/termination")
@CrossOrigin("*")

public class TerminationController {

	@Autowired
	private ITerminationService terminationService;

	// add goal termination
	@PostMapping("/")
	public ResponseEntity<TerminationResponse> createTermination(@RequestBody TerminationRequest terminationRequest) {
		return new ResponseEntity<TerminationResponse>(this.terminationService.addTermination(terminationRequest),
				HttpStatus.CREATED);
	}

	// update termination
	@PutMapping("/")
	public ResponseEntity<TerminationResponse> updateTermination(@RequestBody TerminationRequest terminationRequest) {
		TerminationResponse response = this.terminationService.updateTermination(terminationRequest);
		return ResponseEntity.ok(response);
	}

	// get all termination
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TerminationResponse>> getAllTermination(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<TerminationResponse>>(
				this.terminationService.getAllTermination(pageNo, pageSize), HttpStatus.OK);
	}

	// get termination
	@GetMapping("/{terminationId}")
	public ResponseEntity<TerminationResponse> getTerminationById(@PathVariable Integer terminationId) {
		return ResponseEntity.ok(this.terminationService.getTerminationById(terminationId));
	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TerminationResponse>> searchTermination(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @RequestBody TerminationRequest terminationRequest) {

		Page<TerminationResponse> goalList = this.terminationService.searchTermination(pageNo, pageSize,
				terminationRequest);
		return new ResponseEntity<Page<TerminationResponse>>(goalList, HttpStatus.OK);
	}

	// delete resignation by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTermination(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.terminationService.deleteTermination(id), HttpStatus.ACCEPTED);
	}

	
	
}
