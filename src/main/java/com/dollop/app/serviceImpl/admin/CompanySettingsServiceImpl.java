package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.CompanySettings;
import com.dollop.app.entity.payload.admin.CompanySettingsRequest;
import com.dollop.app.entity.payload.admin.CompanySettingsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.CompanySettingsRepository;
import com.dollop.app.service.admin.ICompanySettingsService;

@Service
public class CompanySettingsServiceImpl implements ICompanySettingsService {

	@Autowired
	private CompanySettingsRepository companySettingsRepository;

	@Autowired

	private ModelMapper modelMapper;

	public CompanySettingsResponse CompanySettingsToCompanySettingsResponse(CompanySettings companySettings) {

		return this.modelMapper.map(companySettings, CompanySettingsResponse.class);
	}

	public CompanySettings ComanySettingsRequestToComopanySettings(CompanySettingsRequest companySettingsRequest) {
		return this.modelMapper.map(companySettingsRequest, CompanySettings.class);
	}

	
	public CompanySettingsResponse updateCompanySettings(CompanySettingsRequest companySettingsRequest)
	{
		CompanySettings companySettings=this.companySettingsRepository.findById(companySettingsRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.COMPANY_SETTINGS_NOT_FOUND + companySettingsRequest.getId()));
		
		companySettings.setAddress(companySettingsRequest.getAddress());
		companySettings.setCity(companySettingsRequest.getCity());
		companySettings.setCompanyName(companySettingsRequest.getCompanyName());
		companySettings.setContactPerson(companySettingsRequest.getContactPerson());
		companySettings.setCountry(companySettingsRequest.getCountry());
		companySettings.setEmail(companySettingsRequest.getEmail());
		companySettings.setFaxNumber(companySettingsRequest.getFaxNumber());
		companySettings.setMobileNumber(companySettingsRequest.getMobileNumber());
		companySettings.setPhoneNumber(companySettingsRequest.getPhoneNumber());
		companySettings.setPinCode(companySettingsRequest.getPinCode());
		companySettings.setState(companySettingsRequest.getState());
		companySettings.setWebsiteUrl(companySettingsRequest.getWebsiteUrl());
		companySettings.setEmail(companySettingsRequest.getEmail());
     companySettings=this.companySettingsRepository.save(companySettings);
		
		return this.CompanySettingsToCompanySettingsResponse(companySettings);
		
	}

	@Override
	public CompanySettings getCompanySettingsById(Integer id) {
		CompanySettings companySettings=this.companySettingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.COMPANY_SETTINGS_NOT_FOUND + id));
		
	
      
		return companySettings;
	}
	

}
