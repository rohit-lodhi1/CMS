package com.dollop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.EducationInformationsRequest;
import com.dollop.app.entity.payload.EducationInformationsResponse;
import com.dollop.app.service.IEducationInformationsService;

@RestController
@RequestMapping("/rise/educationInformations")
@CrossOrigin("*")
public class EducationInformationsController {
	
	@Autowired
	private IEducationInformationsService educationInformationsService;

	// add  emergencyContact
	@PostMapping("/{userId}")
	public ResponseEntity<List<EducationInformationsResponse>> createEducationInformations(
			@RequestPart(name="data") List<EducationInformationsRequest> educationInformationsRequests,@PathVariable Integer userId) {
		return new ResponseEntity<List<EducationInformationsResponse>>(this.educationInformationsService.addEducationInformations(educationInformationsRequests,userId),
				HttpStatus.CREATED);
	}
	
	// get emergencyContact
		@GetMapping("/{employeeId}")
		public ResponseEntity<List<EducationInformationsResponse>> getEducationInformationsByUserId(@PathVariable Integer employeeId) {
		
			return ResponseEntity.ok(this.educationInformationsService.getAllEducationInformations(employeeId));
		}

}
