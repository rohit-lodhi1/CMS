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
import com.dollop.app.service.IResignationService;

@RestController
@RequestMapping("/rise/resignations")
@CrossOrigin("*")
public class ResignationsController {
	@Autowired
	private IResignationService resignationService;

	// add goal resignation
	@PostMapping("/")
	public ResponseEntity<ResignationResponse> createResignation(@RequestBody ResignationRequest resignationRequest) {
		return new ResponseEntity<ResignationResponse>(this.resignationService.addResignation(resignationRequest),
				HttpStatus.CREATED);
	}

	// update resignation
	@PutMapping("/")
	public ResponseEntity<ResignationResponse> updateGoalList(@RequestBody ResignationRequest resignationRequest) {
		ResignationResponse updateresignation = this.resignationService.updateResignation(resignationRequest);
		return ResponseEntity.ok(updateresignation);
	}

	// get all resignation
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ResignationResponse>> getAllResignation(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<ResignationResponse>>(
				this.resignationService.getAllResignation(pageNo, pageSize), HttpStatus.OK);
	}

	// get resignation
	@GetMapping("/{resignationId}")
	public ResponseEntity<ResignationResponse> getResignationById(@PathVariable Integer resignationId) {
		return ResponseEntity.ok(this.resignationService.getResignationById(resignationId));
	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ResignationResponse>> searchGoalList(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @RequestBody ResignationRequest resignationRequest) {

		Page<ResignationResponse> goalList = this.resignationService.searchResignation(pageNo, pageSize,
				resignationRequest);
		return new ResponseEntity<Page<ResignationResponse>>(goalList, HttpStatus.OK);
	}

	// delete resignation by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteGoalList(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.resignationService.deleteResignation(id), HttpStatus.ACCEPTED);
	}
}
