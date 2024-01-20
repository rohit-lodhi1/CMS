package com.dollop.app.controller.admin;

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

import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.StaffSalaryRequest;
import com.dollop.app.entity.payload.StaffSalaryResponse;
import com.dollop.app.service.admin.IStaffSalaryService;

@RestController
@RequestMapping("/rise/admin/staffSalary")
@CrossOrigin("*")

public class StaffSalaryController {
	
	

	@Autowired
	private IStaffSalaryService staffSalaryService;

    // create staffSalary
	@PostMapping("/")
	public ResponseEntity<StaffSalaryResponse> createStaffSalary(@RequestBody StaffSalaryRequest staffSalary) {
		return new ResponseEntity<StaffSalaryResponse>(this.staffSalaryService.addStaffSalary(staffSalary), HttpStatus.CREATED);
	}

    // update staffSalary
	@PutMapping("/")
	public ResponseEntity<StaffSalaryResponse> updateStaffSalary(@RequestBody StaffSalaryRequest staffSalary) {
		StaffSalaryResponse updateTrainers = this.staffSalaryService.updateStaffSalary(staffSalary);
		return ResponseEntity.ok(updateTrainers);
	}

	//  get staffSalary by id
	@GetMapping("/{id}")
	public ResponseEntity<StaffSalaryResponse> getSingleStaffSalary(@PathVariable Integer id) {
		return ResponseEntity.ok(this.staffSalaryService.getStaffSalaryById(id));
	}

    // get all staffSalary
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<StaffSalaryResponse>> getAllStaffSalary(@PathVariable Integer pageNo, 
																@PathVariable Integer pageSize) {
		Page<StaffSalaryResponse> trainers = this.staffSalaryService.getAllStaffSalary(pageNo, pageSize);
		return new ResponseEntity<Page<StaffSalaryResponse>>(trainers, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTrainer(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.staffSalaryService.deleteStaffSalary(id),HttpStatus.ACCEPTED);	
	}
	
	
	// filter assets
		@PostMapping("/search/{pageNo}/{pageSize}")
		public ResponseEntity<Page<StaffSalaryResponse>> searchStaffSalary(@PathVariable Integer pageNo,
				                                                   @PathVariable Integer pageSize, 
				                                                    @RequestBody StaffSalaryRequest staffSalaryRequest) {

			
			Page<StaffSalaryResponse> assets = this.staffSalaryService.searchStaffSalary(pageNo, pageSize, staffSalaryRequest);
			return new ResponseEntity<Page<StaffSalaryResponse>>(assets, HttpStatus.OK);
		}


}
