package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.GoalTypeResponse;
import com.dollop.app.entity.payload.InvoicesRequest;

public interface IGoalListService {
	 public GoalListResponse addGoalList (GoalListRequest goalList); 
	   
	   public GoalListResponse updateGoalList(GoalListRequest goalList);
	   
	   public GoalListResponse getGoalListById(Integer id);
	   
	   public Page<GoalListResponse> getAllGoalList(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteGoalList(Integer id);
	  
	   public GoalListResponse updateGoalListStatus(Integer id,String status);
	  
	   public Page<GoalListResponse> searchGoalList(Integer pageNo, Integer pageSize, GoalListRequest goalList);

}
