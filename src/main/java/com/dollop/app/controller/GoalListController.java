package com.dollop.app.controller;

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

import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.GoalTypeRequest;
import com.dollop.app.entity.payload.GoalTypeResponse;
import com.dollop.app.service.IGoalListService;
import com.dollop.app.service.IGoalTypeService;
import com.dollop.app.serviceImpl.GoalListServiceImpl;

@RestController
@RequestMapping("/rise/goalList")
@CrossOrigin("*")

public class GoalListController {

	@Autowired
	private IGoalListService goalListeService;

	
	

	// add goal goalList
	@PostMapping("/")
	public ResponseEntity<GoalListResponse> createGoalList(@RequestBody GoalListRequest goalListRequest) {
		return new ResponseEntity<GoalListResponse>(this.goalListeService.addGoalList(goalListRequest),
				HttpStatus.CREATED);
	}

	// update goalList
	@PutMapping("/")
	public ResponseEntity<GoalListResponse> updateGoalList(@RequestBody GoalListRequest goalListRequest) {
		GoalListResponse updateGoalList = this.goalListeService.updateGoalList(goalListRequest);
		return ResponseEntity.ok(updateGoalList);
	}

	// get all goalList
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<GoalListResponse>> getAllGoalList(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<GoalListResponse>>(this.goalListeService.getAllGoalList(pageNo, pageSize),
				HttpStatus.OK);
	}

	// get goalList
	@GetMapping("/{goallistId}")
	public ResponseEntity<GoalListResponse> getGoalListById(@PathVariable Integer goallistId) {
		return ResponseEntity.ok(this.goalListeService.getGoalListById(goallistId));
	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<GoalListResponse>> searchGoalList(@PathVariable Integer pageNo,
			                                                   @PathVariable Integer pageSize, 
			                                                    @RequestBody GoalListRequest goalListRequest) {
		Page<GoalListResponse> goalList = this.goalListeService.searchGoalList(pageNo, pageSize, goalListRequest);
		return new ResponseEntity<Page<GoalListResponse>>(goalList, HttpStatus.OK);
	}

	// update goalList status by id
	@GetMapping("/status/{status}/{id}")
	public ResponseEntity<GoalListResponse> updateGoalListStatus(@PathVariable Integer id,
			                                                        @PathVariable String status) {
		GoalListResponse updateGoalList = this.goalListeService.updateGoalListStatus(id, status);
		return new ResponseEntity<GoalListResponse>(updateGoalList, HttpStatus.OK);
	}
	
	// delete goalList by id
			@DeleteMapping("/{id}")
			public ResponseEntity<Boolean> deleteGoalList(@PathVariable Integer id){
			     return new ResponseEntity<Boolean>(this.goalListeService.deleteGoalList(id),HttpStatus.ACCEPTED);	
			}

}
