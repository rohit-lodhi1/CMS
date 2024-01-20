package com.dollop.app.controller.employee;

import java.security.Principal;

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
import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.employee.EmployeeLeaveStatics;
import com.dollop.app.service.employee.ILeaveApplicationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rise/employee/leave")
public class EmployeeLeaveApplicationsController {

	@Autowired
	private ILeaveApplicationService leaveService;

	// create leaveApplication
	@PostMapping("/")
	public ResponseEntity<LeaveApplicationResponse> createApplication(@RequestBody LeaveApplicationRequest leaveApplications,Principal p) {

		LeaveApplicationResponse leave = this.leaveService.createApplication(leaveApplications,p.getName());
		ResponseEntity<LeaveApplicationResponse> response = new ResponseEntity<LeaveApplicationResponse>(leave, HttpStatus.CREATED);
		return response;
	}

	// update leaveApplication
	@PutMapping("/")
	public ResponseEntity<LeaveApplicationResponse> updateLeaveApplication(@RequestBody LeaveApplicationRequest leaveApplications) {
        
        LeaveApplicationResponse leave = this.leaveService.updateLeaveApplication(leaveApplications);
		ResponseEntity<LeaveApplicationResponse> response = new ResponseEntity<LeaveApplicationResponse>(leave, HttpStatus.OK);
		return response;
	}

	// get by id
	@GetMapping("/{id}")
	public ResponseEntity<LeaveApplicationResponse> getLeaveApplicationById(@PathVariable Integer id) {

		LeaveApplicationResponse leave = this.leaveService.getLeaveApplicationById(id);
		ResponseEntity<LeaveApplicationResponse> response = new ResponseEntity<LeaveApplicationResponse>(leave, HttpStatus.OK);
		return response;
	}

	// get by applicant id
	@GetMapping("/applicant/{pageNo}/{pageSize}")
	public ResponseEntity<Page<LeaveApplicationResponse>> getAllLeavesApplicationsByApplicantId(@PathVariable("pageNo") Integer pageNo,
			                                                                             @PathVariable("pageSize") Integer pageSize,
			                                                                             Principal p) {
		Page<LeaveApplicationResponse> leaves = this.leaveService.getLeaveApplicationByApplicantId(pageNo, pageSize,p.getName());
		ResponseEntity<Page<LeaveApplicationResponse>> response = new ResponseEntity<Page<LeaveApplicationResponse>>(leaves,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/statics")
	public ResponseEntity<EmployeeLeaveStatics> getEmployeeLeaveStatics(Principal principal){
		return new ResponseEntity<EmployeeLeaveStatics>(this.leaveService.getLeaveStatics(principal.getName()),HttpStatus.OK);
	}
	
	// delete LeaveApplication
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteLeaveApplication(@PathVariable Integer id){
		this.leaveService.deleteLeaveApplication(id);
		return  new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
	}
	
}
