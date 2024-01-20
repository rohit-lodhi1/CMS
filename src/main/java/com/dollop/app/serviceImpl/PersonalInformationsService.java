package com.dollop.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.PersonalInformations;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.PersonalInformationsRequest;
import com.dollop.app.entity.payload.PersonalInformationsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PersonalInformationsRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IPersonalInformations;

@Service

public class PersonalInformationsService implements IPersonalInformations{


	@Autowired
	public PersonalInformationsRepository informationsRepository;
	@Autowired
	public UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PersonalInformationsResponse personalInformationsToPersonalInformationsResponse(PersonalInformations personalInformations) {
		return this.modelMapper.map(personalInformations, PersonalInformationsResponse.class);
	}

	public PersonalInformations personalInformationsRequestToPersonalInformations(PersonalInformationsRequest PersonalInformationsRequest) {
		return this.modelMapper.map(PersonalInformationsRequest, PersonalInformations.class);
	}

	
	
	
	@Override
	public PersonalInformationsResponse addPersonalInformations(
			PersonalInformationsRequest personalInformationsRequest, Integer userID) {
		

		Users users = this.usersRepository.findByIdAndDeleted(userID, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND + userID));

		
		PersonalInformations personalInformations = this.personalInformationsRequestToPersonalInformations(personalInformationsRequest);
	personalInformations.setUser(users);
		return this.personalInformationsToPersonalInformationsResponse(this.informationsRepository.save(personalInformations));
}

	@Override
	public Page<PersonalInformationsResponse> getAllPersonalInformations(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonalInformationsResponse getPersonalInformationsById(Integer userId) {
		PersonalInformations personalInformations = this.informationsRepository.findByUserAndIsDelete(new Users(userId), false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND + userId));
		return this.personalInformationsToPersonalInformationsResponse(personalInformations);
	}

}
