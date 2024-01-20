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
import com.dollop.app.entity.GoalType;
import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.GoalListRepository;
import com.dollop.app.service.IGoalListService;
import com.dollop.app.utils.GoalListSchedular;
@Service
public class GoalListServiceImpl implements  IGoalListService{

	@Autowired
	public GoalListRepository goalListRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private GoalListSchedular  goalListSchedular;
	public GoalListResponse goalListToGoalListResponse(GoalList goalList) {
		return this.modelMapper.map(goalList, GoalListResponse.class);
	}

	public GoalList goalListRequestToGoalList(GoalListRequest goalListRequest) {
		return this.modelMapper.map(goalListRequest, GoalList.class);
	}
	
	@Override
	public GoalListResponse addGoalList(GoalListRequest goalList) {
		GoalList goalLis = this.goalListRequestToGoalList(goalList);
		goalLis.setProgress(this.goalListSchedular.calculateProgress(goalLis.getStartDate(), goalLis.getEndDate()));
		return this.goalListToGoalListResponse(this.goalListRepository.save(goalLis));
}

	@Override
	public GoalListResponse updateGoalList(GoalListRequest goalList) {
		GoalList goalLis = this.goalListRepository.findById(goalList.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.GOAL_LIST_NOT_FOUND + goalList.getId()));
		goalLis.setDescription(goalList.getDescription());
		goalLis.setGoalType(goalList.getGoalType());
		goalLis.setStatus(goalList.getStatus());
		goalLis.setSubject(goalList.getStatus());
		goalLis.setEndDate(goalLis.getEndDate());
		goalLis.setTargetAchievement(goalList.getTargetAchievement());
		goalLis.setStartDate(goalList.getStartDate());
		return this.goalListToGoalListResponse(this.goalListRepository.save(goalLis));
	}

	@Override
	public GoalListResponse getGoalListById(Integer id) {
		GoalList goalLis = this.goalListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.GOAL_LIST_NOT_FOUND+ id));
		return this.goalListToGoalListResponse(goalLis);

	}

	@Override
	public Page<GoalListResponse> getAllGoalList(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		 Page<GoalList> page =this.goalListRepository.findByIsDelete(pageRequest, false);
	
			return page.map( c -> this.goalListToGoalListResponse(c)); 	
		}
	

	@Override
	public Boolean deleteGoalList(Integer id) {
		GoalList goalLis = this.goalListRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstants.GOAL_LIST_NOT_FOUND+id ));
		goalLis.setIsDelete(true);
		this.goalListRepository.save(goalLis);
		return true;
	}

	@Override
	public GoalListResponse updateGoalListStatus(Integer id, String status) {
		GoalList goalLis = this.goalListRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstants.GOAL_LIST_NOT_FOUND+id ));
		goalLis.setStatus(status);
		return this.goalListToGoalListResponse(this.goalListRepository.save(goalLis));
	
	}

	@Override
	public Page<GoalListResponse> searchGoalList(Integer pageNo, Integer pageSize, GoalListRequest goalList) {
		//goalList.setGoalType(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)))// for
		.withMatcher("goalType.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for
		Example<GoalList> example = Example.of(this.goalListRequestToGoalList(goalList), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<GoalList> page = this.goalListRepository.findAll(example, pageable);
		
		
		 return page.map( u -> this.goalListToGoalListResponse(u));
	}

}
