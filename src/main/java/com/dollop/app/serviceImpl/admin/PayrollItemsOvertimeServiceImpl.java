package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.PayrollItemsOvertime;
import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.payload.PayrollItemsOvertimeRequest;
import com.dollop.app.entity.payload.PayrollItemsOvertimeResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PayrollItemsOvertimeRepository;
import com.dollop.app.service.admin.IPayrollItemsOvertimeService;
@Service
public class PayrollItemsOvertimeServiceImpl implements IPayrollItemsOvertimeService {

	@Autowired
	private PayrollItemsOvertimeRepository payrollItemsOvertimeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PayrollItemsOvertimeResponse payrollItemsOvertimeToPayrollItemsOvertimeResponse(
			PayrollItemsOvertime payrollItemsOvertime) {
		return this.modelMapper.map(payrollItemsOvertime, PayrollItemsOvertimeResponse.class);
	}

	public PayrollItemsOvertime payrollItemsOvertimeResquestToPayrollItemsOvertime(
			PayrollItemsOvertimeRequest payrollItemsOvertimeRequest) {
		return this.modelMapper.map(payrollItemsOvertimeRequest, PayrollItemsOvertime.class);
	}

	@Override
	public PayrollItemsOvertimeResponse addPayrollItemsOvertime(PayrollItemsOvertimeRequest payrollItemsOvertime) {
		PayrollItemsOvertime payrollItemsOvertimes = this.payrollItemsOvertimeRepository
				.save(this.payrollItemsOvertimeResquestToPayrollItemsOvertime(payrollItemsOvertime));
		return this.payrollItemsOvertimeToPayrollItemsOvertimeResponse(payrollItemsOvertimes);
	}

	@Override
	public PayrollItemsOvertimeResponse getPayrollItemsOvertimeById(Integer id) {
		PayrollItemsOvertime payrollItemsOvertimes = this.payrollItemsOvertimeRepository
				.findByIdAndIsDelete(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMSOVERTIME_NOT_FOUND + id));

		return this.payrollItemsOvertimeToPayrollItemsOvertimeResponse(payrollItemsOvertimes);
	}

	@Override
	public PayrollItemsOvertimeResponse updatePayrollItemsOvertime(PayrollItemsOvertimeRequest payrollItemsOvertime) {
		PayrollItemsOvertime payrollItemsOvertimes = this.payrollItemsOvertimeRepository
				.findById(payrollItemsOvertime.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMSOVERTIME_NOT_FOUND + payrollItemsOvertime.getId()));
		payrollItemsOvertimes.setName(payrollItemsOvertime.getName());
		payrollItemsOvertimes.setRate(payrollItemsOvertime.getRate());
		payrollItemsOvertimes.setRateType(payrollItemsOvertime.getRateType());
		
		return this.payrollItemsOvertimeToPayrollItemsOvertimeResponse(this.payrollItemsOvertimeRepository.save(payrollItemsOvertimes));
}

	@Override
	public Page<PayrollItemsOvertimeResponse> getAllPayrollItemsOvertime(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<PayrollItemsOvertime> trainers = this.payrollItemsOvertimeRepository.findByIsDelete(page,false);

		return trainers.map( t -> this.payrollItemsOvertimeToPayrollItemsOvertimeResponse(t));
	}

	@Override
	public Boolean deletePayrollItemsOvertime(Integer id) {
			PayrollItemsOvertime payrollItemsOvertimes = this.payrollItemsOvertimeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PAYROLLITEMSOVERTIME_NOT_FOUND + id));

		payrollItemsOvertimes.setIsDelete(true);
		this.payrollItemsOvertimeRepository.save(payrollItemsOvertimes);
		return true;
	}

}
