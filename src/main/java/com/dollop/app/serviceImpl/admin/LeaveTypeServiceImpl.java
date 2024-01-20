package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.GoalType;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.payload.LeaveTypeRequest;
import com.dollop.app.entity.payload.LeaveTypeResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.LeaveTypeRepository;
import com.dollop.app.service.admin.ILeaveTypeService;

@Service
public class LeaveTypeServiceImpl implements ILeaveTypeService {

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

	// add leave type
	@Override
	public LeaveTypeResponse addLeaveType(LeaveTypeRequest leaveTypeRequest) {
		LeaveTypes leaveType = this.leaveTypeRepository.save(this.leaveTypeRequestToLeaveType(leaveTypeRequest));
		return this.leaveTypeToLeaveTypeResponse(leaveType);
	}

	// update Leave Type
	@Override
	public LeaveTypeResponse updateLeaveType(LeaveTypeRequest leaveType) {
		LeaveTypes leaveTypes = this.leaveTypeRepository.findById(leaveType.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.LEAVE_NOT_FOUND + leaveType.getId()));

		leaveTypes.setStatus(leaveType.getStatus());
		leaveTypes.setDescription(leaveType.getDescription());

		leaveTypes.setTitle(leaveType.getTitle());
		return this.leaveTypeToLeaveTypeResponse(this.leaveTypeRepository.save(leaveTypes));
	}

	



	// delete By id
	@Override
	public Boolean deleteLeaveTypeById(Integer id) {
		LeaveTypes leaveTypes = this.leaveTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.LEAVE_NOT_FOUND + id));
		leaveTypes.setDeleted(true);
		this.leaveTypeRepository.save(leaveTypes);
		return true;
	}

	@Override
	public LeaveTypeResponse updateLeaveTypeStatus(Integer id, String status) {
		LeaveTypes leaveTypes = this.leaveTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.LEAVE_NOT_FOUND + id));
		leaveTypes.setStatus(status);
		return this.leaveTypeToLeaveTypeResponse(this.leaveTypeRepository.save(leaveTypes));

	}

}
