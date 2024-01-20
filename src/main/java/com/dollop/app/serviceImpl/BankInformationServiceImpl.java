package com.dollop.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.BankInformation;
import com.dollop.app.entity.EmergencyContact;
import com.dollop.app.entity.PersonalInformations;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.BankInformationRequest;
import com.dollop.app.entity.payload.BankInformationResponse;
import com.dollop.app.entity.payload.EmergencyContactResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.BankInformationRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IBankInformationService;
@Service
public class BankInformationServiceImpl implements IBankInformationService{

	
	@Autowired
	public UsersRepository usersRepository;


	@Autowired
	public BankInformationRepository bankInformationRepository;

	@Autowired
	private ModelMapper modelMapper;

	public BankInformationResponse bankInformationToBankInformationResponse(BankInformation BankInformationResponse) {
		return this.modelMapper.map(BankInformationResponse, BankInformationResponse.class);
	}

	public BankInformation bankInformationRequestToBankInformation(BankInformationRequest bankInformationRequest) {
		return this.modelMapper.map(bankInformationRequest, BankInformation.class);
	}
	
	
	@Override
	public BankInformationResponse addBankInformation(BankInformationRequest bankInformation,Integer userId) {
		Users users = this.usersRepository.findByIdAndDeleted(userId, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND + userId));

		
		BankInformation bankInformations = this.bankInformationRequestToBankInformation(bankInformation);
		bankInformations.setUser(users);
		
		return this.bankInformationToBankInformationResponse(this.bankInformationRepository.save(bankInformations));
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public BankInformationResponse updateBankInformation(BankInformationRequest bankInformation) {
		BankInformation bankInformations = this.bankInformationRepository.findById(bankInformation.getId())
				
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.BANK_INFORMATIONS_NOT_FOUND + bankInformation.getId()));
		bankInformations.setBankAccountNo(bankInformation.getBankAccountNo());
		bankInformations.setBankName(bankInformation.getBankName());
		bankInformations.setIfscCode(bankInformation.getIfscCode());
		bankInformations.setPanNo(bankInformation.getPanNo());

		return this.bankInformationToBankInformationResponse(this.bankInformationRepository.save(bankInformations));
}

	@Override
	public BankInformationResponse getBankInformationById(Integer id) {
	

	BankInformation bankInformations = this.bankInformationRepository.findByUserAndIsDelete(new Users(id), false)
			.orElseThrow(() -> new ResourceNotFoundException(AppConstants.BANK_INFORMATIONS_NOT_FOUND + id));
	return this.bankInformationToBankInformationResponse(bankInformations);
	}
	
	@Override
	public Boolean deleteBankInformation(Integer id) {
		BankInformation bankInformation = this.bankInformationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.BANK_INFORMATIONS_NOT_FOUND + id));
		bankInformation.setIsDelete(true);
		this.bankInformationRepository.save(bankInformation);
		return true;
	}

}
