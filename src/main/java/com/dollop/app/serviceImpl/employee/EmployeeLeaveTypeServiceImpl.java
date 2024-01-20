package com.dollop.app.serviceImpl.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.payload.LeaveTypeRequest;
import com.dollop.app.entity.payload.LeaveTypeResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.LeaveTypeRepository;
import com.dollop.app.service.employee.ILeaveTypeService;

@Service
public class EmployeeLeaveTypeServiceImpl implements ILeaveTypeService {

	@Autowired
	private LeaveTypeRepository leaveTypeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public LeaveTypeResponse leaveTypeToLeaveTypeResponse(LeaveTypes leaveTypes) {
		return this.modelMapper.map(leaveTypes, LeaveTypeResponse.class);
	}

	public LeaveTypes leaveTypeRequestToLeaveType(LeaveTypeRequest leaveTypeRequest) {
		return this.modelMapper.map(leaveTypeRequest, LeaveTypes.class);
	}

	// get All leaves Tyoe
	@Override
	public List<LeaveTypeResponse> getAllLeaveTypes() {
		List<LeaveTypeResponse> leaveType = this.leaveTypeRepository.findAllByDeleted(false).stream()
				.map(l -> this.leaveTypeToLeaveTypeResponse(l)).collect(Collectors.toList());
		return leaveType;
	}

	// get LeaveType by Id
	@Override
	public LeaveTypeResponse getLeaveTypeById(Integer id) {
		LeaveTypes leaveTypes = this.leaveTypeRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.LEAVE_NOT_FOUND + id));
		return this.leaveTypeToLeaveTypeResponse(leaveTypes);
	}

	@Override
	public List<LeaveTypeResponse> getAllLeaveTypesActive() {
	
		List<LeaveTypeResponse> leaveType = this.leaveTypeRepository.findAllByStatus("Active").stream()
				.map(l -> this.leaveTypeToLeaveTypeResponse(l)).collect(Collectors.toList());
		return leaveType;
	}

	
}
