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

import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;
import com.dollop.app.entity.payload.ExperienceInformationsRequest;
import com.dollop.app.entity.payload.ExperienceInformationsResponse;
import com.dollop.app.service.IEmergencyContactService;
import com.dollop.app.service.IExperienceInformationsService;

@RestController
@RequestMapping("/rise/experienceInformations")
@CrossOrigin("*")

public class ExperienceInformationsController {

	@Autowired
	private IExperienceInformationsService experienceInformationsService;

//	// add   ExperienceInformations
	
	@PostMapping("/{userId}")
	public ResponseEntity<List<ExperienceInformationsResponse>> createExperienceInformations(
			@RequestPart(name="data") List<ExperienceInformationsRequest> informationsRequest,@PathVariable Integer userId) {
		return new ResponseEntity<List<ExperienceInformationsResponse>>(this.experienceInformationsService.addExperienceInformations(informationsRequest, userId),
				HttpStatus.CREATED);
	
}


// get emergencyContact
	@GetMapping("/get/{experienceInformationsId}")
	public ResponseEntity<ExperienceInformationsResponse> getExperienceInformationsById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.experienceInformationsService.getExperienceInformationsByID(Id));
	}
	
	@GetMapping("/{userProfileId}")
	public ResponseEntity<List<ExperienceInformationsResponse>>getExperienceInformationsByUser(@PathVariable Integer userProfileId)
	{
		return new ResponseEntity<List<ExperienceInformationsResponse>>(this.experienceInformationsService.getAllExperienceInformations(userProfileId),HttpStatus.OK);
		
	}
	

}

