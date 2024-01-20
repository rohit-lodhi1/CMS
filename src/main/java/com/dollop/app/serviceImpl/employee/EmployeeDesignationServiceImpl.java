package com.dollop.app.serviceImpl.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.entity.Designation;
import com.dollop.app.entity.payload.DesignationRequest;
import com.dollop.app.entity.payload.DesignationResponse;
import com.dollop.app.repository.DesignationRepository;
import com.dollop.app.service.employee.IDesignationService;

@Service
public class EmployeeDesignationServiceImpl implements IDesignationService{
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public DesignationResponse designationToDesignationResponse(Designation designation) {
		return this.modelMapper.map(designation, DesignationResponse.class);
	}

	public Designation designationRequestToDesignation(DesignationRequest designation) {
		return this.modelMapper.map(designation, Designation.class);
	}

	@Override
	public List<DesignationResponse> getAllDesignation() {
		List<DesignationResponse> list = this.designationRepository.findByIsDeleted(false).stream().map(d -> this.designationToDesignationResponse(d)).collect(Collectors.toList());
		return list;
	}
}
