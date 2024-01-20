package com.dollop.app.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dollop.app.entity.payload.DesignationResponse;
import com.dollop.app.service.employee.IDesignationService;


@RestController
@RequestMapping("/rise/employee/designation")
@CrossOrigin("*")
public class EmployeeDesignationController {

	@Autowired
	private IDesignationService designationService;
	
	// get all designation
		@GetMapping("/")
		public ResponseEntity<List<DesignationResponse>> getAllDesignation() {
			return ResponseEntity.ok(this.designationService.getAllDesignation());
		}
}
