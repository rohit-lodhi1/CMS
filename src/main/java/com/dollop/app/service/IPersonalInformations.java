package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.PersonalInformationsRequest;
import com.dollop.app.entity.payload.PersonalInformationsResponse;
import com.dollop.app.entity.payload.PromotionRequest;


public interface IPersonalInformations {
	
	public PersonalInformationsResponse addPersonalInformations(PersonalInformationsRequest personalInformationsRequest , Integer userId);

	
	public Page<PersonalInformationsResponse> getAllPersonalInformations(Integer pageNo, Integer pageSize);

	public PersonalInformationsResponse getPersonalInformationsById(Integer promotionId);


}
