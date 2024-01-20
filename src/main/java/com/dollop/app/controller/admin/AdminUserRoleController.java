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

import com.dollop.app.entity.payload.admin.UserRoleRequest;
import com.dollop.app.entity.payload.admin.UserRoleResponse;
import com.dollop.app.service.admin.IAdminUserRolesService;

@RestController
@RequestMapping("/rise/admin/userRole")
@CrossOrigin("*")
public class AdminUserRoleController {

	@Autowired
	private IAdminUserRolesService adminUserRolesService;
	
	@PostMapping("/")
	public ResponseEntity<UserRoleResponse> addUserRole(@RequestBody UserRoleRequest request){
		return new ResponseEntity<UserRoleResponse>(this.adminUserRolesService.addUserRole(request),HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<UserRoleResponse> updateUserRole(@RequestBody UserRoleRequest request){
		return new ResponseEntity<UserRoleResponse>(this.adminUserRolesService.updateUserRole(request),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserRoleResponse> getUserRoleById(@PathVariable Integer id){
		return new ResponseEntity<UserRoleResponse>(this.adminUserRolesService.getUserRoleById(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserRoleResponse>> getAllUserRoles(){
		return new ResponseEntity<List<UserRoleResponse>>(this.adminUserRolesService.getAllUserRole(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUserRole(@PathVariable Integer id){
		return new ResponseEntity<Boolean>(this.adminUserRolesService.deleteUserRole(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<UserRoleResponse>> getUserRolesOfUser(@PathVariable Integer userId){
		return new ResponseEntity<List<UserRoleResponse>>(this.adminUserRolesService.getUserRolesOfUser(userId),HttpStatus.OK);
	}
}
