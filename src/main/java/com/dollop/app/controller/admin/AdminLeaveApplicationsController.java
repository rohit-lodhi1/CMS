package com.dollop.app.controller.admin;

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
import com.dollop.app.entity.payload.admin.LeaveStatics;
import com.dollop.app.service.admin.ILeaveApplicationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rise/admin/leave")
public class AdminLeaveApplicationsController {

	@Autowired
	private ILeaveApplicationService leaveService;

	// create leaveApplication
	@PostMapping("/")
	public ResponseEntity<LeaveApplicationResponse> createApplication(@RequestBody LeaveApplicationRequest leaveApplications) {

		LeaveApplicationResponse leave = this.leaveService.createApplication(leaveApplications);
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

	// get all leaveApplications
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<LeaveApplicationResponse>> getAllLeavesApplications(@PathVariable("pageNo") Integer pageNo,
			                                                                @PathVariable("pageSize") Integer pageSize) {
		Page<LeaveApplicationResponse> leaves = this.leaveService.getAllLeaveApplication(pageNo, pageSize);
		ResponseEntity<Page<LeaveApplicationResponse>> response = new ResponseEntity<Page<LeaveApplicationResponse>>(leaves,	HttpStatus.OK);
		return response;
	}

	// get by status
	@GetMapping("/status/{pageNo}/{pageSize}/{status}")
	public ResponseEntity<Page<LeaveApplicationResponse>> getAllLeavesApplicationsByStatus(@PathVariable("pageNo") Integer pageNo,
			     																	@PathVariable("pageSize") Integer pageSize,
			     																	@PathVariable("id") String status) {
		Page<LeaveApplicationResponse> leaves = this.leaveService.getLeaveApplicationByStatus(pageNo, pageSize, status);
		ResponseEntity<Page<LeaveApplicationResponse>> response = new ResponseEntity<Page<LeaveApplicationResponse>>(leaves,HttpStatus.OK);
		return response;
	}

	// get leave application statics
	@GetMapping("/statics")
	public ResponseEntity<LeaveStatics> getLeaveApplicatonStatics(){
		return new ResponseEntity<LeaveStatics>(this.leaveService.getLeaveStatics(),HttpStatus.OK);
	}
	
	// update status of LeaveApplication
	@PutMapping("/status/{id}")
	public ResponseEntity<LeaveApplicationResponse> updateLeaveApplicationStatus(@RequestBody String status,@PathVariable Integer id,Principal p){
		
		LeaveApplicationResponse leave = this.leaveService.updateLeaveApplicationStatus(status,id,p.getName());
		ResponseEntity<LeaveApplicationResponse> response = new ResponseEntity<LeaveApplicationResponse>(leave, HttpStatus.OK);
		return response;
	}
	
	// delete LeaveApplication by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteLeaveApplication(@PathVariable Integer id){
		this.leaveService.deleteLeaveApplication(id);
		return  new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<LeaveApplicationResponse>> searchLeaveApplication(@PathVariable("pageNo") Integer pageNo,
																		  @PathVariable("pageSize") Integer pageSize,
																		  @RequestBody LeaveApplicationRequest leaveApplication) {
	 	Page<LeaveApplicationResponse> leaves = this.leaveService.searchLeaveApplication(pageNo, pageSize, leaveApplication);
		ResponseEntity<Page<LeaveApplicationResponse>> response = new ResponseEntity<Page<LeaveApplicationResponse>>(leaves,HttpStatus.OK);
		return response;
	}
	
}
