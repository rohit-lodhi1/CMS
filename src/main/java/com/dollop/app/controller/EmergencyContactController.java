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

import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;
import com.dollop.app.entity.payload.PersonalInformationsRequest;
import com.dollop.app.entity.payload.PersonalInformationsResponse;
import com.dollop.app.service.IEmergencyContactService;
import com.dollop.app.service.IPersonalInformations;

@RestController
@RequestMapping("/rise/emergencyContact")
@CrossOrigin("*")

public class EmergencyContactController {
	
	
	@Autowired
	private IEmergencyContactService EContactService;

	// add  emergencyContact
	@PostMapping("/{userId}")
	public ResponseEntity<EmergencyContactResponse> createEmergencyContact(
			@RequestBody EmergencyContactRequest informationsRequest, @PathVariable Integer userId) {
	    return new ResponseEntity<EmergencyContactResponse>(this.EContactService.addEmergencyContact(informationsRequest,userId),
				HttpStatus.CREATED);
	}
	
	// get emergencyContact
		@GetMapping("/{userId}")
		public ResponseEntity<EmergencyContactResponse> getEmergencyContactById(@PathVariable Integer userId) {
			return ResponseEntity.ok(this.EContactService.getEmergencyContactById(userId));
		}


}
