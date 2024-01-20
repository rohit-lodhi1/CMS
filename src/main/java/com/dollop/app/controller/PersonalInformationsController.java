package com.dollop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.ManageJobsRequest;
import com.dollop.app.entity.payload.ManageJobsResponse;
import com.dollop.app.entity.payload.PersonalInformationsRequest;
import com.dollop.app.entity.payload.PersonalInformationsResponse;
import com.dollop.app.service.IManageJobsService;
import com.dollop.app.service.IPersonalInformations;

@RestController
@RequestMapping("/rise/personalInformations")
@CrossOrigin("*")

public class PersonalInformationsController {
	
	
	@Autowired
	private IPersonalInformations informationservice;

	// add  personalInformations
	@PostMapping("/{userId}")
	public ResponseEntity<PersonalInformationsResponse> createPersonalInformations(
			@RequestBody PersonalInformationsRequest informationsRequest, @PathVariable Integer userId) {
		return new ResponseEntity<PersonalInformationsResponse>(this.informationservice.addPersonalInformations(informationsRequest,userId),
				HttpStatus.CREATED);
	}
	
	// get PersonalInformations
		@GetMapping("/{personalInformationsId}")
		public ResponseEntity<PersonalInformationsResponse> getPersonalInformationsById(@PathVariable Integer personalInformationsId) {
			return ResponseEntity.ok(this.informationservice.getPersonalInformationsById(personalInformationsId));
		}

}
