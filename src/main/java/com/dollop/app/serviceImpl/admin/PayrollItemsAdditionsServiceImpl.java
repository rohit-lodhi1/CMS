package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.PayrollItemsAdditions;
import com.dollop.app.entity.PayrollItemsOvertime;
import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.payload.PayrollItemsAdditionsRequest;
import com.dollop.app.entity.payload.PayrollItemsAdditionsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PayrollItemsAdditionsRepository;
import com.dollop.app.service.admin.IPayrollItemsAdditionsService;
@Service
public class PayrollItemsAdditionsServiceImpl implements IPayrollItemsAdditionsService{

	@Autowired
	private PayrollItemsAdditionsRepository payrollItemsAdditionsRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PayrollItemsAdditionsResponse payrollItemsAdditionsToPayrollItemsAdditionsResponse(PayrollItemsAdditions payrollItemsAdditions) {
		return this.modelMapper.map(payrollItemsAdditions, PayrollItemsAdditionsResponse.class);
	}

	public PayrollItemsAdditions payrollItemsAdditionsResquestToPayrollItemsAdditions(PayrollItemsAdditionsRequest payrollItemsAdditionsRequest) {
		return this.modelMapper.map(payrollItemsAdditionsRequest, PayrollItemsAdditions.class);
	}

	
	
	
	@Override
	public PayrollItemsAdditionsResponse addPayrollItemsAdditions(PayrollItemsAdditionsRequest payrollItemsAdditions) {
		PayrollItemsAdditions payrollItemsAddition = this.payrollItemsAdditionsRepository.save(this.payrollItemsAdditionsResquestToPayrollItemsAdditions(payrollItemsAdditions));
		return this.payrollItemsAdditionsToPayrollItemsAdditionsResponse(payrollItemsAddition);
	}

	@Override
	public PayrollItemsAdditionsResponse getPayrollItemsAdditionsById(Integer id) {
		PayrollItemsAdditions payrollItemsAddition = this.payrollItemsAdditionsRepository.findByIdAndIsDelete(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMS_ADDITIONS_NOT_FOUND + id));

		return this.payrollItemsAdditionsToPayrollItemsAdditionsResponse(payrollItemsAddition);
		}

	@Override
	public PayrollItemsAdditionsResponse updatePayrollItemsAdditions(
			PayrollItemsAdditionsRequest payrollItemsAdditions) {
		PayrollItemsAdditions payrollItemsAddition = this.payrollItemsAdditionsRepository.findById(payrollItemsAdditions.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINERS_NOT_FOUND + payrollItemsAdditions.getId()));
		payrollItemsAddition.setCategory(payrollItemsAdditions.getCategory());
		payrollItemsAddition.setName(payrollItemsAdditions.getName());
		payrollItemsAddition.setUnitAmount(payrollItemsAdditions.getUnitAmount());
		payrollItemsAddition.setUnitCalculation(payrollItemsAdditions.getUnitCalculation());
		
		return this.payrollItemsAdditionsToPayrollItemsAdditionsResponse(this.payrollItemsAdditionsRepository.save(payrollItemsAddition));
	}

	@Override
	public Page<PayrollItemsAdditionsResponse> getAllPayrollItemsAdditions(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<PayrollItemsAdditions> trainers = this.payrollItemsAdditionsRepository.findByIsDelete(page, false);

		return trainers.map( t -> this.payrollItemsAdditionsToPayrollItemsAdditionsResponse(t));
	}

	@Override
	public Boolean deletePayrollItemsAdditions(Integer id) {
		PayrollItemsAdditions payrollItemsAddition= this.payrollItemsAdditionsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMS_ADDITIONS_NOT_FOUND + id));

		payrollItemsAddition.setIsDelete(true);
		this.payrollItemsAdditionsRepository.save(payrollItemsAddition);
		return true;
	}

}
