package com.dollop.app.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.AppliedCandidateRequest;
import com.dollop.app.entity.payload.AppliedCandidateResponse;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.service.employee.IUsersService;


@RestController
@RequestMapping("/rise/employee/allEmployee")
@CrossOrigin("*")
public class EmployeeUsersContoller {
	@Autowired
	private IUsersService service;

	// add employee
	@PostMapping(path = "/", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<UsersResponse> createAppliedCandidate(
			@RequestPart(value = "image", required = false) MultipartFile file,
			@RequestPart("data") UsersRequest usersRequest) {
		
	
		return new ResponseEntity<UsersResponse>(this.service.addUser(usersRequest, file),
				HttpStatus.CREATED);

	}
	
	// update employee

	@PutMapping(path = "/", consumes = { "multipart/form-data", "application/octet-stream" })
		public ResponseEntity<UsersResponse> updateEmployee(
				@RequestPart(value = "image", required = false) MultipartFile file,
				@RequestPart("data") UsersRequest usersRequest) {
			
		
			return new ResponseEntity<UsersResponse>(this.service.updateUser(usersRequest, file),
					HttpStatus.OK);

		}

	// get employees by id
	@GetMapping("/{userId}")
	public ResponseEntity<UsersResponse> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(this.service.getUsersById(userId));
	}
	
	
}
