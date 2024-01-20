package com.dollop.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.payload.admin.AdminPermissionResponse;
import com.dollop.app.service.admin.IAdminPermissionService;

@RestController
@RequestMapping("/rise/admin/permission")
@CrossOrigin("*")
public class AdminPermissionController {
	
	@Autowired
	private IAdminPermissionService adminPermissionService;
	
	@GetMapping("/role/{id}")
	public ResponseEntity<List<AdminPermissionResponse>> getPermissionsOfRoleByRoleId(@PathVariable Integer id){
		return new ResponseEntity<List<AdminPermissionResponse>>(this.adminPermissionService.getPermissionOfRoleByRoleId(id),HttpStatus.OK);
	}
	
	@GetMapping("/{title}")
	public ResponseEntity<AdminPermissionResponse> getPermissionByTitleContaining(@PathVariable("title") String title){
		return new ResponseEntity<AdminPermissionResponse>(this.adminPermissionService.getPermissionByTitleContaining(title),HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<List<AdminPermissionResponse>> updateAllPermissions(@RequestBody List<Permissions> permissions){
		return new ResponseEntity<List<AdminPermissionResponse>>(this.adminPermissionService.updatePermissions(permissions),HttpStatus.OK);
	}

}
