package com.dollop.app.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.admin.AdminAttendanceSearchRequest;
import com.dollop.app.service.admin.IAttendenceService;

@RestController
@RequestMapping("/rise/admin/attendance")
@CrossOrigin("*")
public class AdminAttendanceController {

	@Autowired
	private IAttendenceService attendenceService;
	
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<Object>> getAttandance(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		
		return new ResponseEntity<Page<Object>>(this.attendenceService.getAttendance(pageNo,pageSize),HttpStatus.OK);
	}
	
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<Object>> searchAttendance(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody AdminAttendanceSearchRequest request){
		return new ResponseEntity<Page<Object>>(this.attendenceService.searchAttendances(pageNo, pageSize, request),HttpStatus.OK);
	}
	
}
