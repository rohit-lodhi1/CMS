package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;

public interface IEmergencyContactService {
	
	

	public EmergencyContactResponse addEmergencyContact(EmergencyContactRequest emergencyContactRequest,Integer userId);

	
	public Page<EmergencyContactResponse> getAllEmergencyContact(Integer pageNo, Integer pageSize);

	public EmergencyContactResponse getEmergencyContactById(Integer emergencyContactID);


}
