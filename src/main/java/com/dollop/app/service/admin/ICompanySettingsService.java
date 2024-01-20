package com.dollop.app.service.admin;

import org.springframework.stereotype.Service;

import com.dollop.app.entity.CompanySettings;
import com.dollop.app.entity.payload.admin.CompanySettingsRequest;
import com.dollop.app.entity.payload.admin.CompanySettingsResponse;
@Service
public interface ICompanySettingsService {

	public CompanySettingsResponse updateCompanySettings(CompanySettingsRequest companySettingsRequest);

	public CompanySettings getCompanySettingsById(Integer id);

	

}
