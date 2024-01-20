package com.dollop.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Clients;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.GoalType;
import com.dollop.app.entity.Invoices;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.GoalTypeRequest;
import com.dollop.app.entity.payload.GoalTypeResponse;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.InvoicesResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.GoalTypeRepository;
import com.dollop.app.repository.InvoicesRepository;
import com.dollop.app.service.IGoalTypeService;

@Service
public class GoalTypeServiceImpl implements IGoalTypeService {
	@Autowired
	public GoalTypeRepository goalTypeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public GoalTypeResponse goalTypeToGoalTypeResponse(GoalType goalType) {
		return this.modelMapper.map(goalType, GoalTypeResponse.class);
	}

	public GoalType goalTypeRequestToGoalType(GoalTypeRequest goalTypeRequest) {
		return this.modelMapper.map(goalTypeRequest, GoalType.class);
	}

	@Override
	public GoalTypeResponse addGoalType(GoalTypeRequest goalType) {
		GoalType goalTypes = this.goalTypeRequestToGoalType(goalType);
		return this.goalTypeToGoalTypeResponse(this.goalTypeRepository.save(goalTypes));

	}

	@Override
	public GoalTypeResponse updateGoalType(GoalTypeRequest goalType) {
		GoalType goalTypes = this.goalTypeRepository.findById(goalType.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.GOALTYPE_NOT_FOUND + goalType.getId()));
		goalTypes.setDescription(goalType.getDescription());
		goalTypes.setGoalLists(goalType.getGoalLists());
		goalTypes.setStatus(goalType.getStatus());
		return this.goalTypeToGoalTypeResponse(this.goalTypeRepository.save(goalTypes));

	}

	@Override
	public GoalTypeResponse getGoalTypeById(Integer id) {
		GoalType goalTypes = this.goalTypeRepository.findByIdAndIsDelete(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.GOALTYPE_NOT_FOUND + id));
		return this.goalTypeToGoalTypeResponse(goalTypes);

	}

	@Override
	public Page<GoalTypeResponse> getAllGoalType(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<GoalType> page = this.goalTypeRepository.findByIsDelete(pageRequest, false);
//	System.out.println(page.getContent());
		return page.map(c -> this.goalTypeToGoalTypeResponse(c));
	}

	@Override
	public Boolean deleteGoalType(Integer id) {
		GoalType goalTypes = this.goalTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.GOALTYPE_NOT_FOUND + id));
		goalTypes.setIsDelete(true);
		this.goalTypeRepository.save(goalTypes);
		return true;
	}

	@Override
	public GoalTypeResponse updateGoalTypeStatus(Integer id, String status) {
		GoalType goalTypes = this.goalTypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstants.GOALTYPE_NOT_FOUND+id ));
		goalTypes.setStatus(status);
		return this.goalTypeToGoalTypeResponse(this.goalTypeRepository.save(goalTypes));
	
	}

	@Override
	public Page<GoalTypeResponse> searchGoalType(Integer pageNo, Integer pageSize, GoalTypeRequest goalType) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for

		Example<GoalType> example = Example.of(this.goalTypeRequestToGoalType(goalType), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<GoalType> page = this.goalTypeRepository.findAll(example, pageable);
			
		 return page.map( u -> this.goalTypeToGoalTypeResponse(u));
	}

	@Override
	public List<GoalTypeResponse> getAllGoalTypeList() {
		List<GoalType> page = this.goalTypeRepository.findByIsDelete(false);
//		System.out.println(page.getContent());
		List<GoalTypeResponse> list = page.stream().map( g -> this.goalTypeToGoalTypeResponse(g)).collect(Collectors.toList());
			return list;
		}

}
