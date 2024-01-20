package com.dollop.app.controller.employee;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.employee.AttendanceRequest;
import com.dollop.app.entity.payload.employee.AttendanceResponse;
import com.dollop.app.entity.payload.employee.AttendanceStaticsResponse;
import com.dollop.app.service.employee.IAttendenceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rise/employee/attendance")
public class EmployeeAttendanceController {

	@Autowired
	private IAttendenceService attendenceService;
	
	// add attendance
	@PostMapping("/")
	public ResponseEntity<AttendanceResponse> createAttendance(@RequestBody AttendanceRequest attendanceRequest) {
		ResponseEntity<AttendanceResponse> response = new ResponseEntity<AttendanceResponse>(this.attendenceService.createAttendance(attendanceRequest),HttpStatus.CREATED);
		return response;
	}
	
	// update attendance
	@PutMapping("/")
	public ResponseEntity<AttendanceResponse> updateAttendance(@RequestBody AttendanceRequest attendanceRequest) {
		ResponseEntity<AttendanceResponse> response = new ResponseEntity<AttendanceResponse>(this.attendenceService.updateAttendence(attendanceRequest),HttpStatus.CREATED);
		return response;
	}
	
	// get attendance by id
	@GetMapping("/{id}")
	public ResponseEntity<AttendanceResponse> getAttendanceById(@PathVariable Long id) {
		ResponseEntity<AttendanceResponse> response = new ResponseEntity<AttendanceResponse>(this.attendenceService.getAttendanceById(id),HttpStatus.CREATED);
		return response;
	}
	
	
	// get attendance by  user id
	@GetMapping("/user/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<AttendanceResponse>> getAttendanceByUserId(@PathVariable Integer pageNo,
																		  @PathVariable Integer pageSize,
																		  @PathVariable Integer id) {
		ResponseEntity<Page<AttendanceResponse>> response = new ResponseEntity<Page<AttendanceResponse>>(this.attendenceService.getAttendanceByUserId(pageNo,pageSize, id),HttpStatus.CREATED);
		return response;
	}
	
	
	
	
	// get all attendance
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<AttendanceResponse>> getAllAttendance(@PathVariable Integer pageNo,
																	 @PathVariable Integer pageSize) {
		ResponseEntity<Page<AttendanceResponse>> response = new ResponseEntity<Page<AttendanceResponse>>(this.attendenceService.getAllAttendance(pageNo,pageSize),HttpStatus.CREATED);
		return response;
	}
	
	// get latest attendance entry of user by id
	@GetMapping("/latest/{id}")
	public ResponseEntity<AttendanceResponse> getLatestAttendanceByUserId(@PathVariable Integer id){
		return new ResponseEntity<AttendanceResponse>(this.attendenceService.getLatestAttendanceByUserId(id),HttpStatus.OK);
	}
	
	// first in attendance of User According to date
	@GetMapping("/firstIn/{date}/{id}")
	public ResponseEntity<AttendanceResponse> getTodaysFirstInTimeByUserId(@PathVariable String date,
																		   @PathVariable Integer id){
		return new ResponseEntity<AttendanceResponse>(this.attendenceService.getFirstInTime(date, id),HttpStatus.OK);
	}
	
	// last entry in attendance of User According to date
	@GetMapping("/lastOut/{date}/{id}")
	public ResponseEntity<AttendanceResponse> getTodaysLastOutTimeByUserId(@PathVariable String date,
																		   @PathVariable Integer id){
		return new ResponseEntity<AttendanceResponse>(this.attendenceService.getFirstInTime(date, id),HttpStatus.OK);
	}
	
	// get all attendance of user by given date
	@GetMapping("/date/{date}/{id}")
	public ResponseEntity<List<AttendanceResponse>> getAttendanceOfDateByUserId(@PathVariable String date,
																				@PathVariable Integer id){
		return new ResponseEntity<List<AttendanceResponse>>(this.attendenceService.getAttendanceofDateByUserId(date, id),HttpStatus.OK);
	}
	
	// get attendance history of user by user id  (Chat GPT Kiya tha 'aise m to loop zyada lg rhe the')
    @GetMapping("/history/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<AttendanceResponse>> getAttendanceHistoryOfUserByUserId(@PathVariable Integer pageNo,
			 																		   @PathVariable Integer pageSize,
			 																		   @PathVariable  Integer id ){
		return new ResponseEntity<Page<AttendanceResponse>>(this.attendenceService.getAttendanceHistoryOfUserByUserId(pageNo,pageSize,id),HttpStatus.OK);
	}
    
    // search filter 
    @PostMapping("/search/{pageNo}/{pageSize}/{id}")
    public ResponseEntity<Page<AttendanceResponse>> searchAttendance(@PathVariable Integer pageNo,
			   														 @PathVariable Integer pageSize,
			   														 @RequestBody String attendanceRequest,
			   														 @PathVariable(required = false) Integer id){
    	return new ResponseEntity<Page<AttendanceResponse>>(this.attendenceService.searchAttandance(pageNo, pageSize, attendanceRequest, id),HttpStatus.OK);
    }
    
    @GetMapping("/statics")
    public ResponseEntity<AttendanceStaticsResponse> getAttendanceStaticsOfUser(Principal p){
    	return new ResponseEntity<AttendanceStaticsResponse>(this.attendenceService.getAttendanceStaticsByUserId(p.getName()),HttpStatus.OK);
    }
   
}
