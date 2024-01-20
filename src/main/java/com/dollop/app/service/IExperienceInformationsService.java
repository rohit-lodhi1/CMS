package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.EducationInformationsRequest;
import com.dollop.app.entity.payload.EducationInformationsResponse;
import com.dollop.app.entity.payload.ExperienceInformationsRequest;
import com.dollop.app.entity.payload.ExperienceInformationsResponse;
import com.dollop.app.entity.payload.ExperienceInformationsResponse;

public interface IExperienceInformationsService {
public List<ExperienceInformationsResponse> addExperienceInformations(List<ExperienceInformationsRequest> experienceInformationsRequests,Integer userId);

	
	public List<ExperienceInformationsResponse> getAllExperienceInformations(Integer userProfileId);

	public ExperienceInformationsResponse getExperienceInformationsByID(Integer id);

}




