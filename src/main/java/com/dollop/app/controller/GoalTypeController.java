package com.dollop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.GoalTypeRequest;
import com.dollop.app.entity.payload.GoalTypeResponse;
import com.dollop.app.service.IGoalTypeService;

@RestController
@RequestMapping("/rise/goalType")
@CrossOrigin("*")

public class GoalTypeController {
	@Autowired
	private IGoalTypeService  goalTypeService;

	// add goal type
	@PostMapping("/")
	public ResponseEntity<GoalTypeResponse> createGoalType(@RequestBody GoalTypeRequest  goalTypeRequest) {
		return new ResponseEntity<GoalTypeResponse>(this.goalTypeService.addGoalType(goalTypeRequest), HttpStatus.CREATED);
	}
	
	// update goal type
	@PutMapping("/")
	public ResponseEntity<GoalTypeResponse> updateGoalType(@RequestBody GoalTypeRequest goalTypeRequest){
		GoalTypeResponse updateGoalType = this.goalTypeService.updateGoalType(goalTypeRequest);
	return ResponseEntity.ok(updateGoalType);
	}
	
	
	
	// get all goal type
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<GoalTypeResponse>> getAllGoalType(@PathVariable("pageNo") Integer pageNo,
                                                   @PathVariable("pageSize") Integer pageSize){
		return new ResponseEntity<Page<GoalTypeResponse>>(this.goalTypeService.getAllGoalType(pageNo,pageSize),HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<GoalTypeResponse>> getAllGoalsTypes(){
		return new ResponseEntity<List<GoalTypeResponse>>(this.goalTypeService.getAllGoalTypeList(),HttpStatus.OK);
	}

	
	
	// get goal type
		@GetMapping("/{goaltypeId}")
		public ResponseEntity<GoalTypeResponse> getGoalTypeById(@PathVariable Integer goaltypeId) {
			return ResponseEntity.ok(this.goalTypeService.getGoalTypeById(goaltypeId));
		}
		
		// filter searching 
		@PostMapping("/search/{pageNo}/{pageSize}")
		public ResponseEntity<Page<GoalTypeResponse>> searchGoalType(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody GoalTypeRequest goalTypeRequest){
		
			Page<GoalTypeResponse> goalType = this.goalTypeService.searchGoalType(pageNo, pageSize, goalTypeRequest);
			return new ResponseEntity<Page<GoalTypeResponse>>(goalType,HttpStatus.OK);
		}
		
		// delete goalType by id
		@DeleteMapping("/{id}")
		public ResponseEntity<Boolean> deleteGoalType(@PathVariable Integer id){
		     return new ResponseEntity<Boolean>(this.goalTypeService.deleteGoalType(id),HttpStatus.ACCEPTED);	
		}
		// update goalType status by id
		@GetMapping("/status/{status}/{id}")
		public ResponseEntity<GoalTypeResponse> updateGoalTypeStatus(@PathVariable Integer id,@PathVariable String status) {
			GoalTypeResponse updateGoalType = this.goalTypeService.updateGoalTypeStatus(id,status);
			return new ResponseEntity<GoalTypeResponse>(updateGoalType, HttpStatus.OK);
		}

}
