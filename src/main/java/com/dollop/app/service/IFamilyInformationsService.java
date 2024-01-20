package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.FamilyInformationsRequest;
import com.dollop.app.entity.payload.FamilyInformationsResponse;

public interface IFamilyInformationsService {
	
	

	public List<FamilyInformationsResponse> addFamilyInformations(List<FamilyInformationsRequest> familyInformations ,Integer userId);

	public FamilyInformationsResponse updateFamilyInformations(FamilyInformationsRequest familyInformations);

	public FamilyInformationsResponse getFamilyInformationsById(Integer id);

	public List<FamilyInformationsResponse> getAllFamilyInformations(Integer userProfileId);

	


}
