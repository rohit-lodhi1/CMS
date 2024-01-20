package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Department;
import com.dollop.app.entity.Designation;
import com.dollop.app.entity.payload.DepartmentResponse;
import com.dollop.app.entity.payload.DesignationRequest;
import com.dollop.app.entity.payload.DesignationResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.ResourcesAlreadyExists;
import com.dollop.app.repository.DesignationRepository;
import com.dollop.app.service.admin.IDesigntionService;

@Service
public class DesignationServiceImpl implements IDesigntionService {

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

	
	
	// add designation
	@Override
	public DesignationResponse createDesignation(DesignationRequest designationRequest) {
		designationRequest.setIsDeleted(false);
	   if(!this.designationRepository.existsByTitle(designationRequest.getTitle())) {
		   
		   Designation designation = this.designationRepository.save(this.designationRequestToDesignation(designationRequest));
		   return this.designationToDesignationResponse(designation);
	   }
	   throw new ResourcesAlreadyExists(AppConstants.DESIGNATION_AlREADY_FOUND+designationRequest.getTitle());
	   
	}

	// update designation
	@Override
	public DesignationResponse updateDesignation(DesignationRequest designationRequest) {
		   Designation designation = this.designationRepository.findById(designationRequest.getId()).orElseThrow(()->new ResourceNotFoundException(AppConstants.DESIGNATION_NOT_FOUND+designationRequest.getId()));
		return this.designationToDesignationResponse(designation);
	}
	

	

	// get designation by id
	@Override
	public DesignationResponse getDesignationById(Integer designationId) {
		Designation designation = this.designationRepository.findByIdAndIsDeleted(designationId,false).orElseThrow(()->new ResourceNotFoundException(AppConstants.DESIGNATION_NOT_FOUND+designationId));		
		return this.designationToDesignationResponse(designation);
	}

	// delete designation
	@Override
	public Boolean deleteDesignation(Integer designationId) {
		Designation designation = this.designationRepository.findById(designationId).orElseThrow(()->new ResourceNotFoundException(AppConstants.DESIGNATION_NOT_FOUND));
		designation.setIsDeleted(true);
		this.designationRepository.save(designation);
		return true;
	}

	//get designations by department
	@Override
	public List<DesignationResponse> getAllDesignationByDepartment(Integer departmentId) {
		Department dept = new Department();
		
		dept.setId(departmentId);
		List<DesignationResponse> list = this.designationRepository.findByDepartment(dept).stream().map(d -> this.designationToDesignationResponse(d)).collect(Collectors.toList());
		return list;
	}

	@Override
	public Page<DesignationResponse> searchDesignation(Integer pageNo, Integer pageSize,
			DesignationRequest designationRequest) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for

		// for

		Example<Designation> example = Example.of(this.designationRequestToDesignation(designationRequest), matcher);
		List<Designation> list = this.designationRepository.findAll(example);

		return new PageImpl<DesignationResponse>(
				list.stream().map(d -> this.designationToDesignationResponse(d)).collect(Collectors.toList()));
	}

	

}
