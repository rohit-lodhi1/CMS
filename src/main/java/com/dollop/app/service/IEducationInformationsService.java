package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.EducationInformationsRequest;
import com.dollop.app.entity.payload.EducationInformationsResponse;
import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;

public interface IEducationInformationsService {
	

	public List<EducationInformationsResponse> addEducationInformations(List<EducationInformationsRequest> educationInformationsRequests,Integer userId);

	
	public List<EducationInformationsResponse> getAllEducationInformations(Integer userProfileId);

	public EducationInformationsResponse getEducationInformationsById(Integer educationInformationsId);


}
