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

import com.dollop.app.entity.payload.admin.AdminRoleRequest;
import com.dollop.app.entity.payload.admin.AdminRoleResponse;
import com.dollop.app.service.admin.IAdminRoleService;

import lombok.Delegate;

@RestController
@RequestMapping("/rise/admin/roles")
@CrossOrigin("*")
public class AdminRolesController {

	@Autowired
	private IAdminRoleService adminRoleService;
	
	
	@PostMapping("/")
	public ResponseEntity<AdminRoleResponse> addRoles(@RequestBody AdminRoleRequest request){
		return new ResponseEntity<AdminRoleResponse>(this.adminRoleService.addRole(request),HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<AdminRoleResponse> updateRoles (@RequestBody AdminRoleRequest request){
		return new ResponseEntity<AdminRoleResponse>(this.adminRoleService.updateRole(request),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdminRoleResponse> getRolesById(@PathVariable("id") Integer id){
		return new ResponseEntity<AdminRoleResponse>(this.adminRoleService.getRole(id),HttpStatus.OK);
	}
	

	@GetMapping("/")
	public ResponseEntity<List<AdminRoleResponse>> getAllRoles(){
		return new ResponseEntity<List<AdminRoleResponse>>(this.adminRoleService.getAllRoles(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRoleById(@PathVariable("id") Integer id){
		return new ResponseEntity<Boolean>(this.adminRoleService.deleteRoleById(id),HttpStatus.ACCEPTED);
	}
	
	
}
