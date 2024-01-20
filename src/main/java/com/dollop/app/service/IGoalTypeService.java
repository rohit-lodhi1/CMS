package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.GoalTypeRequest;
import com.dollop.app.entity.payload.GoalTypeResponse;

public interface IGoalTypeService {

	 public GoalTypeResponse addGoalType (GoalTypeRequest goalType); 
	   
	   public GoalTypeResponse updateGoalType(GoalTypeRequest goalType);
	   
	   public GoalTypeResponse getGoalTypeById(Integer id);
	   
	   public Page<GoalTypeResponse> getAllGoalType(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteGoalType(Integer id);
	  
	   public GoalTypeResponse updateGoalTypeStatus(Integer id,String status);
	  
	   public Page<GoalTypeResponse> searchGoalType(Integer pageNo, Integer pageSize, GoalTypeRequest goalType);

	   public List<GoalTypeResponse> getAllGoalTypeList();

}
