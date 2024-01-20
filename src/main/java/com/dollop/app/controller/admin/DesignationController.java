package com.dollop.app.controller.admin;

import java.util.List;

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

import com.dollop.app.entity.payload.DepartmentRequest;
import com.dollop.app.entity.payload.DepartmentResponse;
import com.dollop.app.entity.payload.DesignationRequest;
import com.dollop.app.entity.payload.DesignationResponse;
import com.dollop.app.service.admin.IDesigntionService;

@RestController
@RequestMapping("/rise/admin/designation")
@CrossOrigin("*")
public class DesignationController {

	@Autowired
	private IDesigntionService designationService;


	// add designation
	@PostMapping("/")
	public ResponseEntity<DesignationResponse> createDesignation(@RequestBody DesignationRequest designation) {

		
		ResponseEntity<DesignationResponse> rs = new ResponseEntity<DesignationResponse>(
				this.designationService.createDesignation(designation), HttpStatus.CREATED);
		return rs;
	}
	
	// update designation
		@PutMapping("/")
		public ResponseEntity<DesignationResponse> updateDesignation(@RequestBody DesignationRequest designation) throws Exception {

			ResponseEntity<DesignationResponse> rs = new ResponseEntity<DesignationResponse>(
					this.designationService.createDesignation(designation), HttpStatus.CREATED);
			return rs;
		}

	// delete designation by id
	@DeleteMapping("/delete/{designationId}")
	public ResponseEntity<Boolean> deletedDesignation(@PathVariable Integer designationId) {
		
		return ResponseEntity.ok(designationService.deleteDesignation(designationId));
	}


	// get department by id
	@GetMapping("/{departmentId}")
	public ResponseEntity<List<DesignationResponse>> getAllDesignationByDepartment(@PathVariable Integer departmentId) {
		return ResponseEntity.ok(designationService.getAllDesignationByDepartment(departmentId));
	}
	
	@GetMapping("/update/{designationId}")
	   public ResponseEntity<DesignationResponse> getDesignationById(@PathVariable Integer designationId ){
			
			return ResponseEntity.ok(this.designationService.getDesignationById(designationId));
		}
	
	// filter searching 
		@PostMapping("search/{pageNo}/{pageSize}")
		public ResponseEntity<Page<DesignationResponse>> searchDepartment(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody DesignationRequest designation){
			Page<DesignationResponse> departments = this.designationService.searchDesignation(pageNo, pageSize, designation);
			return new ResponseEntity<Page<DesignationResponse>>(departments,HttpStatus.OK);
		}
}
