	package com.dollop.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.dollop.app.service.admin.IDepartmentService;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.Users;


@RequestMapping("/rise/admin/department/")
@RestController
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;

	// filter searching 
	@PostMapping("search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<DepartmentResponse>> searchDepartment(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody DepartmentRequest department){
		Page<DepartmentResponse> departments = this.departmentService.searchDepartment(pageNo, pageSize, department);
		return new ResponseEntity<Page<DepartmentResponse>>(departments,HttpStatus.OK);
	}

	// create department
	@PostMapping
	public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest department) {
		ResponseEntity<DepartmentResponse> rs = new ResponseEntity<DepartmentResponse>(this.departmentService.createDepartment(department), HttpStatus.CREATED);
		return rs;
	}
	
	// update department
	@PutMapping
	public ResponseEntity<DepartmentResponse> updateDepartment(@RequestBody DepartmentRequest department) {

		ResponseEntity<DepartmentResponse> rs = new ResponseEntity<DepartmentResponse>(
				this.departmentService.updateDepartment(department), HttpStatus.CREATED);
		

		return rs;
	}
	
	// get all department
//	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE') ")
	@GetMapping
	public ResponseEntity<List<DepartmentResponse>> getAllDepartment() {
		return ResponseEntity.ok(departmentService.getAllDeparments());
	}
	
	// get department by id
	@GetMapping("update/{depId}")
   public ResponseEntity<DepartmentResponse> getDeparmentById(@PathVariable Integer depId ){
		
		return ResponseEntity.ok(departmentService.getDepartmentById(depId));
	}
	
	// delete department by id
	@DeleteMapping("delete/{depId}")
	public ResponseEntity<Boolean> deletedDepartment(@PathVariable Integer depId ){
		
		return ResponseEntity.ok(departmentService.deleteDepartment(depId));
	}
	
	
	// get all department
	@PreAuthorize("hasRole('EMPLOYEE')")
		@GetMapping("/deparment")
		public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
			return ResponseEntity.ok(departmentService.getAllDeparments());
		}
		

}
