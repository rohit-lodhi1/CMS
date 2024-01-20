package com.dollop.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.FamilyInformationsRequest;
import com.dollop.app.entity.payload.FamilyInformationsResponse;
import com.dollop.app.service.IFamilyInformationsService;

@RestController
@RequestMapping("/rise/admin/familyInformations")
@CrossOrigin("*")

public class FamilyInformationsController {

	@Autowired
	private IFamilyInformationsService familyInformationService;

	// add familyInformation
	@PostMapping("/{userId}")
	public ResponseEntity<List<FamilyInformationsResponse>> createfamilyInformation(
			@RequestPart(name = "data") List<FamilyInformationsRequest> familyInformationRequest,
			@PathVariable Integer userId) {

		return new ResponseEntity<List<FamilyInformationsResponse>>(
				this.familyInformationService.addFamilyInformations(familyInformationRequest, userId),
				HttpStatus.CREATED);
	}

	// update familyInform
	@PutMapping("/")
	public ResponseEntity<FamilyInformationsResponse> updateFamilyInformations(
			@RequestBody FamilyInformationsRequest familyInformationRequest) {
		FamilyInformationsResponse familyInform = this.familyInformationService
				.updateFamilyInformations(familyInformationRequest);
		return ResponseEntity.ok(familyInform);
	}

	// get all familyInformations
	@GetMapping("/byprofile/{userProfileId}")
	public ResponseEntity<List<FamilyInformationsResponse>> getAllFamilyInformations(
			@PathVariable Integer userProfileId) {
		return new ResponseEntity<List<FamilyInformationsResponse>>(
				this.familyInformationService.getAllFamilyInformations(userProfileId), HttpStatus.OK);
	}

	// get FamilyInformations
	@GetMapping("/getfinfo/{id}")
	public ResponseEntity<FamilyInformationsResponse> getFamilyInformationsById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.familyInformationService.getFamilyInformationsById(id));
	}

}
