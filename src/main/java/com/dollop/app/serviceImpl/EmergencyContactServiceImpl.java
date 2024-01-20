package com.dollop.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.EmergencyContact;
import com.dollop.app.entity.PersonalInformations;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;
import com.dollop.app.entity.payload.PersonalInformationsRequest;
import com.dollop.app.entity.payload.PersonalInformationsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.EmergencyContactRepository;
import com.dollop.app.repository.PersonalInformationsRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IEmergencyContactService;
@Service
public class EmergencyContactServiceImpl implements IEmergencyContactService
{
	
	
	@Autowired
	public UsersRepository usersRepository;
	

	@Autowired
	public EmergencyContactRepository emergencyContactRepository;

	@Autowired
	private ModelMapper modelMapper;

	public EmergencyContactResponse emergencyContactToEmergencyContactResponse(EmergencyContact emergencyContact) {
		return this.modelMapper.map(emergencyContact, EmergencyContactResponse.class);
	}

	public EmergencyContact emergencyContactRequestToEmergencyContact(EmergencyContactRequest emergencyContactRequest) {
		return this.modelMapper.map(emergencyContactRequest, EmergencyContact.class);
	}

	@Override
	public EmergencyContactResponse addEmergencyContact(EmergencyContactRequest emergencyContactRequest,Integer userId) {
		Users users = this.usersRepository.findByIdAndDeleted(userId, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND + userId));

		EmergencyContact emergencyContact = this.emergencyContactRequestToEmergencyContact(emergencyContactRequest);
		emergencyContact.setUser(users);
		return this.emergencyContactToEmergencyContactResponse(this.emergencyContactRepository.save(emergencyContact));
	
	}

	@Override
	public Page<EmergencyContactResponse> getAllEmergencyContact(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmergencyContactResponse getEmergencyContactById(Integer userId) {
		Users users = this.usersRepository.findByIdAndDeleted(userId, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND + userId));

		EmergencyContact emergency = this.emergencyContactRepository.findByUserAndIsDelete(users, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.CONTACT_NOT_FOUND +userId ));
		return this.emergencyContactToEmergencyContactResponse(emergency);
	}

}
