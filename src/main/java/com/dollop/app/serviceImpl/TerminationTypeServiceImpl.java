package com.dollop.app.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.TerminationType;
import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.TerminationTypeRequest;
import com.dollop.app.entity.payload.TerminationTypeResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.GoalListRepository;
import com.dollop.app.repository.TerminationTypeRepository;
import com.dollop.app.service.ITerminationTypeService;
@Service
public class TerminationTypeServiceImpl implements ITerminationTypeService{

	@Autowired
	public TerminationTypeRepository terminationTypeRepository ;

	@Autowired
	private ModelMapper modelMapper;

	public TerminationTypeResponse terminationTypeToTerminationTypeResponse(TerminationType terminationType) {
		return this.modelMapper.map(terminationType, TerminationTypeResponse.class);
	}

	public TerminationType terminationTypeRequestToTerminationType(TerminationTypeRequest terminationType) {
		return this.modelMapper.map(terminationType, TerminationType.class);
	}
	
	
	
	@Override
	public TerminationTypeResponse addTerminationType(TerminationTypeRequest terminationTypeRequest) {
		TerminationType terminationType = this.terminationTypeRequestToTerminationType(terminationTypeRequest);
		return this.terminationTypeToTerminationTypeResponse(this.terminationTypeRepository.save(terminationType));
}

	

	@Override
	public TerminationTypeResponse updateTermination(TerminationTypeRequest terminationTypeRequest) {
		TerminationType terminationType = this.terminationTypeRepository.findById(terminationTypeRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TERMINATIONTYPE_NOT_FOUND + terminationTypeRequest.getId()));
		terminationType.setTerminationType(terminationTypeRequest.getTerminationType());
		
		return this.terminationTypeToTerminationTypeResponse(this.terminationTypeRepository.save(terminationType));
	
	}

	

	@Override
	public TerminationTypeResponse getTerminationById(Integer id) {
		TerminationType terminationType = this.terminationTypeRepository.findByIdAndIsDelete(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TERMINATIONTYPE_NOT_FOUND + id));
		return this.terminationTypeToTerminationTypeResponse(terminationType);

	}
	

	@Override
	public Boolean deleteTerminationById(Integer id) {
		TerminationType terminationType = this.terminationTypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstants.TERMINATIONTYPE_NOT_FOUND+id ));
		terminationType.setIsDelete(true);
		this.terminationTypeRepository.save(terminationType);
		return true;
	}

	@Override
	public Page<TerminationTypeResponse> getAllTerminationType(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		 Page<TerminationType> page =this.terminationTypeRepository.findByIsDelete(pageRequest, false);
	
			return page.map( c -> this.terminationTypeToTerminationTypeResponse(c)); 	
		}
	}


