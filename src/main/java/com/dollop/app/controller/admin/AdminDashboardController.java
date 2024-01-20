package com.dollop.app.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.admin.AdminDashBoardResponse;
import com.dollop.app.service.admin.IAdminDashboardService;

@RestController
@RequestMapping("/rise/admin/dashboard")
@CrossOrigin("*")
public class AdminDashboardController {

	@Autowired
	private IAdminDashboardService adminDashboardService;
	
	@GetMapping("/details")
	public ResponseEntity<AdminDashBoardResponse> fetchDetails(){
		return new ResponseEntity<AdminDashBoardResponse>(this.adminDashboardService.fetchDetails(),HttpStatus.OK);
	}
	
	
	  @GetMapping("/total-tasks")
	    public ResponseEntity<Map<String, Object>> getTotalWorkedHoursBetweenDates(){
	        Object summary = adminDashboardService.fetchTaskDetailsForAdminDash();
	        Map<String, Object> response = new HashMap<>();
	        response.put("taskData", summary);
	        return ResponseEntity.ok(response);
	  }
	   
}
