package com.dollop.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.LeaveTypeRequest;
import com.dollop.app.entity.payload.LeaveTypeResponse;
import com.dollop.app.service.admin.ILeaveTypeService;

@RestController
@RequestMapping("/rise/admin/leaveTypes")
@CrossOrigin("*")
public class LeaveTypesController {

	@Autowired
	private ILeaveTypeService leaveTypeService;

	// create leave type
	@PostMapping("/")
	public ResponseEntity<LeaveTypeResponse> createLeaveType(@RequestBody LeaveTypeRequest leaveType) {

		LeaveTypeResponse leave = this.leaveTypeService.addLeaveType(leaveType);
		ResponseEntity<LeaveTypeResponse> response = new ResponseEntity<LeaveTypeResponse>(leave, HttpStatus.CREATED);
		return response;
	}

	// update leave type
	@PutMapping("/")
	public ResponseEntity<LeaveTypeResponse> updateLeaveType(@RequestBody LeaveTypeRequest leaveType) {

		LeaveTypeResponse leave = this.leaveTypeService.updateLeaveType(leaveType);
		ResponseEntity<LeaveTypeResponse> response = new ResponseEntity<LeaveTypeResponse>(leave, HttpStatus.OK);
		return response;
	}

	 
	 // delete leave type
		@DeleteMapping("/{id}")
		public ResponseEntity<Boolean> deleteLeaveType(@PathVariable Integer id){
			this.leaveTypeService.deleteLeaveTypeById(id);
			return  new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
		}
		
		// update LeaveTypeStatus status by id
		@GetMapping("/status/{status}/{id}")
		public ResponseEntity<LeaveTypeResponse> updateLeaveTypeStatus(@PathVariable Integer id,
				                                                        @PathVariable String status) {
			LeaveTypeResponse leaveTypeResponse = this.leaveTypeService.updateLeaveTypeStatus(id, status);
			return new ResponseEntity<LeaveTypeResponse>(leaveTypeResponse, HttpStatus.OK);
		}

}
