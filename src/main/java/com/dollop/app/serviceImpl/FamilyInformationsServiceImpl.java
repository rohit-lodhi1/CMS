package com.dollop.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.EducationInformations;
import com.dollop.app.entity.FamilyInformations;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.EducationInformationsResponse;
import com.dollop.app.entity.payload.FamilyInformationsRequest;
import com.dollop.app.entity.payload.FamilyInformationsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.FamilyInformationsRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IFamilyInformationsService;

@Service
public class FamilyInformationsServiceImpl implements IFamilyInformationsService{


	@Autowired
	public FamilyInformationsRepository familyInformationsRepository;
	
	@Autowired
	public UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	public FamilyInformationsResponse familyInformationsTofamilyInformationsResponse(FamilyInformations familyInformations) {
		return this.modelMapper.map(familyInformations, FamilyInformationsResponse.class);
	}

	public FamilyInformations familyInformationsRequestToFamilyInformations(FamilyInformationsRequest familyInformationsRequest) {
		return this.modelMapper.map(familyInformationsRequest, FamilyInformations.class);
	}

	
	public List<FamilyInformationsResponse> addFamilyInformations(List<FamilyInformationsRequest> familyInformations,
			Integer userId) {
		Users user=this.usersRepository.findByIdAndDeleted(userId,false).
				orElseThrow(()->new ResourceNotFoundException(AppConstants.USER_NOT_FOUND_+userId));
		
		List<FamilyInformationsResponse>list=new ArrayList<>();
		
		familyInformations.stream().forEach(m->
		{
			
			FamilyInformations familyInformations2=this.familyInformationsRequestToFamilyInformations(m);
			
			familyInformations2.setUser(user);
			list.add(this.familyInformationsTofamilyInformationsResponse(this.familyInformationsRepository.save(familyInformations2)));
		});
		return list;
	}

	@Override
	public FamilyInformationsResponse updateFamilyInformations(FamilyInformationsRequest familyInformations) {
		FamilyInformations familyInformations2=this.familyInformationsRepository.findByIdAndIsDelete(familyInformations.getId(), false)
				.orElseThrow(()->new ResourceNotFoundException(AppConstants.FAMILY_INFORMATIONS_NOT_FOUND+familyInformations.getId()));
				familyInformations2.setDateOfBirth(familyInformations.getDateOfBirth());
				familyInformations2.setIsDelete(familyInformations.getIsDelete());
				familyInformations2.setName(familyInformations.getName());
				familyInformations2.setPhone(familyInformations.getPhone());
				familyInformations2.setRelationship(familyInformations.getRelationship());
				
		
		return this.familyInformationsTofamilyInformationsResponse(this.familyInformationsRepository.save(familyInformations2));
	}

	@Override
	public FamilyInformationsResponse getFamilyInformationsById(Integer id) {
		FamilyInformations familyInformations2=this.familyInformationsRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(AppConstants.FAMILY_INFORMATIONS_NOT_FOUND+id));
		
		return this.familyInformationsTofamilyInformationsResponse(familyInformations2);
		
		
	}

	@Override
	public List<FamilyInformationsResponse> getAllFamilyInformations(Integer userProfileId) {
List<FamilyInformations> familyInformations = this.familyInformationsRepository.findByUserAndIsDelete(new Users (userProfileId), false);

		
		return 	familyInformations.stream()
			    .map(ef -> this.familyInformationsTofamilyInformationsResponse(ef))
			    .collect(Collectors.toList());}

	}
	
	
	
	
	

  
