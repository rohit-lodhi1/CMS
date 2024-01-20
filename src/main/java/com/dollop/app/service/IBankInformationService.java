package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.BankInformationRequest;
import com.dollop.app.entity.payload.BankInformationResponse;
import com.dollop.app.entity.payload.EmergencyContactRequest;
import com.dollop.app.entity.payload.EmergencyContactResponse;
import com.dollop.app.entity.payload.FamilyInformationsRequest;
import com.dollop.app.entity.payload.FamilyInformationsResponse;

public interface IBankInformationService {
	
	

	public BankInformationResponse addBankInformation(BankInformationRequest bankInformation,Integer userId);

	public BankInformationResponse updateBankInformation(BankInformationRequest bankInformation);

	public BankInformationResponse getBankInformationById(Integer id);

	public Boolean deleteBankInformation(Integer id);


}
