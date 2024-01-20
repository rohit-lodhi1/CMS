package com.dollop.app.controller.admin;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.listPayloads.UserListResponse;
import com.dollop.app.service.admin.IAdminDashboardService;
import com.dollop.app.service.admin.IUsersService;

@RestController
@RequestMapping("/rise/admin/allEmployee")
@CrossOrigin("*")
public class AdminUsersContoller {
	@Autowired
	private IUsersService service;

	@Autowired
	private IAdminDashboardService adminDashboardService;

	// add user
	@PostMapping(path = "/{role}", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<UsersResponse> createUserByRoleName(
			@RequestPart(value = "files[]", required = false) MultipartFile file,
			@RequestPart("data") UsersRequest usersRequest, @PathVariable String role) {

		return new ResponseEntity<UsersResponse>(this.service.addUser(usersRequest, role, file), HttpStatus.CREATED);

	}
	
	
	// update user
	@PutMapping("/")
	public ResponseEntity<UsersResponse> updateUser(@RequestBody UsersRequest usersRequest) {
		UsersResponse updateuser = this.service.updateUser(usersRequest);
		return ResponseEntity.ok(updateuser);
	}

	// get all users
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<UsersResponse>> getAllUsers(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,Principal p) {
		return new ResponseEntity<Page<UsersResponse>>(this.service.getAllUsers(pageNo, pageSize,p), HttpStatus.OK);
	}

	@GetMapping("/userRoles/{roleName}")
	public ResponseEntity<List<UsersResponse>> getAllByUserRole(@PathVariable("roleName") String roleName) {
		return new ResponseEntity<List<UsersResponse>>(this.service.getByUserRole(roleName), HttpStatus.OK);
	}

	// get all employee
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/employee/{pageNo}/{pageSize}/{role}")
//	public ResponseEntity<Page<UsersResponse>> getAllEmployees(@PathVariable("pageNo") Integer pageNo,
//			@PathVariable("pageSize") Integer pageSize,@PathVariable("role") Integer role) {
//		
//		return new ResponseEntity<Page<UsersResponse>>(this.service.getAllEmployee(pageNo, pageSize,role), HttpStatus.OK);
//	}

	
	@GetMapping("/employeeList/{pageNo}/{pageSize}/{roleId}")
	public ResponseEntity<Page<UserListResponse>> getAllEmployeesList(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,@PathVariable Integer roleId,Principal p) {
		
		return new ResponseEntity<Page<UserListResponse>>(this.service.getAllUserByRole(pageNo, pageSize,roleId,p.getName()), HttpStatus.OK);
	}
	
	
//	// get all owner
//	@GetMapping("/owner/{pageNo}/{pageSize}")
//	public ResponseEntity<Page<UsersResponse>> getAllOwners(@PathVariable("pageNo") Integer pageNo,
//			@PathVariable("pageSize") Integer pageSize,Principal p) {
//		return new ResponseEntity<Page<UsersResponse>>(this.service.getAllUserByRole(pageNo, pageSize,3,p.getName()), HttpStatus.OK);
//	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<UsersResponse>> searchUser(@PathVariable Integer pageNo, @PathVariable Integer pageSize,
			@RequestBody UsersRequest user) {
		Page<UsersResponse> users = this.service.searchUser(pageNo, pageSize, user);
		return new ResponseEntity<Page<UsersResponse>>(users, HttpStatus.OK);
	}

	// delete user by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.service.deleteUsers(id), HttpStatus.ACCEPTED);
	}

	// get user by id
	@GetMapping("/{id}")
	public ResponseEntity<UsersResponse> getUserById(@PathVariable Integer id) {
		return new ResponseEntity<UsersResponse>(this.service.getUserById(id), HttpStatus.OK);
	}
}
