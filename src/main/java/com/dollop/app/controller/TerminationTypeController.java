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
import com.dollop.app.entity.payload.TerminationTypeRequest;
import com.dollop.app.entity.payload.TerminationTypeResponse;

import com.dollop.app.service.ITerminationTypeService;

@RestController
@RequestMapping("/rise/admin/terminationType")
@CrossOrigin("*")

public class TerminationTypeController {

	@Autowired
	private ITerminationTypeService terminationTypeService;

	// add goal terminationType
	@PostMapping("/")
	public ResponseEntity<TerminationTypeResponse> createTerminationType(@RequestBody TerminationTypeRequest terminationTypeRequest) {
		return new ResponseEntity<TerminationTypeResponse>(this.terminationTypeService.addTerminationType(terminationTypeRequest),
				HttpStatus.CREATED);
	}

	// update terminationType
	@PutMapping("/")
	public ResponseEntity<TerminationTypeResponse> updateTermination(@RequestBody TerminationTypeRequest terminationTypeRequest) {
		TerminationTypeResponse response = this.terminationTypeService.updateTermination(terminationTypeRequest);
		return ResponseEntity.ok(response);
	}

	// get all terminationType
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TerminationTypeResponse>> getAllTermination(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<TerminationTypeResponse>>(
				this.terminationTypeService.getAllTerminationType(pageNo, pageSize), HttpStatus.OK);
	}

	// get terminationType
	@GetMapping("/{terminationTypeId}")
	public ResponseEntity<TerminationTypeResponse> getTerminationById(@PathVariable Integer terminationTypeId) {
		return ResponseEntity.ok(this.terminationTypeService.getTerminationById(terminationTypeId));
	}
// delete terminationType by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTermination(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.terminationTypeService.deleteTerminationById(id), HttpStatus.ACCEPTED);
	}

	

}
