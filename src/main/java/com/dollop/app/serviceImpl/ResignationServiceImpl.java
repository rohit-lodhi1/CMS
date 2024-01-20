package com.dollop.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.Resignation;
import com.dollop.app.entity.payload.ResignationRequest;
import com.dollop.app.entity.payload.ResignationResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.ResignationRepository;
import com.dollop.app.service.IResignationService;
@Service
public class ResignationServiceImpl implements IResignationService{

	@Autowired
	public ResignationRepository resignationRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ResignationResponse resignationToResignationResponse(Resignation resignation) {
		return this.modelMapper.map(resignation, ResignationResponse.class);
	}

	public Resignation resignationRequestToResignation(ResignationRequest resignation) {
		return this.modelMapper.map(resignation, Resignation.class);
	}
	
	
	
	@Override
	public ResignationResponse addResignation(ResignationRequest promotionRequest) {
		Resignation resignations = this.resignationRequestToResignation(promotionRequest);
		return this.resignationToResignationResponse(this.resignationRepository.save(resignations));

	}

	@Override
	public ResignationResponse updateResignation(ResignationRequest resignation) {
		Resignation resignations = this.resignationRepository.findById(resignation.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESIGNATIONS_NOT_FOUND + resignation.getId()));
		resignations.setDepartment(resignation.getDepartment());
		resignations.setEmployee(resignation.getEmployee());
		resignations.setNoticeDate(resignation.getNoticeDate());
		resignations.setReason(resignation.getReason());
		resignations.setResigning(resignation.getResigning());
		
		return this.resignationToResignationResponse(this.resignationRepository.save(resignations));


	}

	@Override
	public ResignationResponse getResignationById(Integer id) {
		Resignation resignation = this.resignationRepository.findByIdAndIsDelete(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.RESIGNATIONS_NOT_FOUND + id));
		return this.resignationToResignationResponse(resignation);

	}

	@Override
	public Page<ResignationResponse> getAllResignation(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		 Page<Resignation> page =this.resignationRepository.findByIsDelete(pageRequest, false);
	
			return page.map( c -> this.resignationToResignationResponse(c)); 	
		}
	
	
	@Override
	public Boolean deleteResignation(Integer id) {
		Resignation resignation = this.resignationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstants.RESIGNATIONS_NOT_FOUND+id ));
		resignation.setIsDelete(true);
		this.resignationRepository.save(resignation);
		return true;
		
	}

	@Override
	public Page<ResignationResponse> searchResignation(Integer pageNo, Integer pageSize,
			ResignationRequest resignationRequest) {
		resignationRequest.getEmployee().setDesignation(null);
		resignationRequest.getEmployee();
		resignationRequest.getEmployee().setIsAdmin(null);
		resignationRequest.getEmployee().setIsPrime(null);
		resignationRequest.getEmployee().setEnableWebNotification(null);
		resignationRequest.getEmployee().setEnableEmailNotification(null);
		resignationRequest.getEmployee().setDisableLogin(null);
		
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)))// for
				.withMatcher("employee.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)));
			
				// for

		Example<Resignation> example = Example.of(this.resignationRequestToResignation(resignationRequest), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);
		Page<Resignation > page = this.resignationRepository.findAll(example, pageable);
		

		 return page.map( u -> this.resignationToResignationResponse(u));
	}

}
