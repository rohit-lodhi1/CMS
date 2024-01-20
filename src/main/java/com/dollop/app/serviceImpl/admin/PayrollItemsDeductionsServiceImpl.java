package com.dollop.app.serviceImpl.admin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.PayrollItemsDeductions;
import com.dollop.app.entity.payload.PayrollItemsDeductionsRequest;
import com.dollop.app.entity.payload.PayrollItemsDeductionsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PayrollItemsDeductionsRepository;
import com.dollop.app.service.admin.IPayrollItemsDeductionsService;
@Service
public class PayrollItemsDeductionsServiceImpl implements IPayrollItemsDeductionsService {

	@Autowired
	private PayrollItemsDeductionsRepository payrollItemsDeductionsRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PayrollItemsDeductionsResponse payrollItemsDeductionsToPayrollItemsDeductionsResponse(
			PayrollItemsDeductions payrollItemsDeductions) {
		return this.modelMapper.map(payrollItemsDeductions, PayrollItemsDeductionsResponse.class);
	}

	public PayrollItemsDeductions PayrollItemsDeductionsResquestToTrainer(
			PayrollItemsDeductionsRequest payrollItemsDeductionsRequest) {
		return this.modelMapper.map(payrollItemsDeductionsRequest, PayrollItemsDeductions.class);
	}

	@Override
	public PayrollItemsDeductionsResponse addPayrollItemsDeductions(
			PayrollItemsDeductionsRequest payrollItemsDeductions) {
		PayrollItemsDeductions payrollItemsDeduction = this.payrollItemsDeductionsRepository
				.save(this.PayrollItemsDeductionsResquestToTrainer(payrollItemsDeductions));
		return this.payrollItemsDeductionsToPayrollItemsDeductionsResponse(payrollItemsDeduction);
	}

	@Override
	public PayrollItemsDeductionsResponse getPayrollItemsDeductionssById(Integer id) {
		PayrollItemsDeductions payrollItemsDeduction = this.payrollItemsDeductionsRepository
				.findByIdAndIsDelete(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMS_DEDUCTIONS_NOT_FOUND + id));

		return this.payrollItemsDeductionsToPayrollItemsDeductionsResponse(payrollItemsDeduction);
	}

	@Override
	public PayrollItemsDeductionsResponse updatePayrollItemsDeductions(
			PayrollItemsDeductionsRequest payrollItemsDeductions) {
		PayrollItemsDeductions payrollItemsDeduction = this.payrollItemsDeductionsRepository
				.findById(payrollItemsDeductions.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMS_DEDUCTIONS_NOT_FOUND + payrollItemsDeductions.getId()));
		payrollItemsDeduction.setName(payrollItemsDeductions.getName());
		payrollItemsDeduction.setUnitAmount(payrollItemsDeductions.getUnitAmount());
		payrollItemsDeduction.setUnitCalculation(payrollItemsDeductions.getUnitCalculation());
		
		return this.payrollItemsDeductionsToPayrollItemsDeductionsResponse(this.payrollItemsDeductionsRepository.save(payrollItemsDeduction));
	}

	@Override
	public Page<PayrollItemsDeductionsResponse> getAllPayrollItemsDeductions(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<PayrollItemsDeductions> trainers = this.payrollItemsDeductionsRepository.findByIsDelete(page,false);

		return trainers.map( t -> this.payrollItemsDeductionsToPayrollItemsDeductionsResponse(t));
	}

	@Override
	public Boolean deletePayrollItemsDeductions(Integer id) {
		PayrollItemsDeductions payrollItemsDeduction = this.payrollItemsDeductionsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMS_DEDUCTIONS_NOT_FOUND + id));

		payrollItemsDeduction.setIsDelete(true);
		this.payrollItemsDeductionsRepository.save(payrollItemsDeduction);
		return true;
	}

}
