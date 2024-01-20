package com.dollop.app.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.LeaveTypeResponse;
import com.dollop.app.service.employee.ILeaveTypeService;

@RestController
@RequestMapping("/rise/employee/leaveTypes")
@CrossOrigin("*")
public class EmployeeLeaveTypesController {

	@Autowired
	private ILeaveTypeService leaveTypeService;

	// create leave type

	// get by id
	@GetMapping("/{id}")
	public ResponseEntity<LeaveTypeResponse> getLeaveTypeById(@PathVariable Integer id) {

		LeaveTypeResponse leave = this.leaveTypeService.getLeaveTypeById(id);
		ResponseEntity<LeaveTypeResponse> response = new ResponseEntity<LeaveTypeResponse>(leave, HttpStatus.OK);
		return response;
	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<LeaveTypeResponse>> getAllLeaveType() {

		List<LeaveTypeResponse> leave = this.leaveTypeService.getAllLeaveTypes();
		ResponseEntity<List<LeaveTypeResponse>> response = new ResponseEntity<List<LeaveTypeResponse>>(leave,
				HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<LeaveTypeResponse>> getAllLeaveTypeByStatusActive() {

		List<LeaveTypeResponse> leave = this.leaveTypeService.getAllLeaveTypesActive();
		ResponseEntity<List<LeaveTypeResponse>> response = new ResponseEntity<List<LeaveTypeResponse>>(leave,
				HttpStatus.OK);
		return response;
	}
}
